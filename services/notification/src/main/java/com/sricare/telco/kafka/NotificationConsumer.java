package com.sricare.telco.kafka;

import com.sricare.telco.email.EmailService;
import com.sricare.telco.kafka.activation.ActivationConfirmation;
import com.sricare.telco.kafka.payment.PaymentConfirmation;
import com.sricare.telco.notification.Notification;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.sricare.telco.notification.NotificationType.ACTIVATION_CONFIRMATION;
import static com.sricare.telco.notification.NotificationType.PAYMENT_CONFIRMATION;
import static java.lang.String.format;
import com.sricare.telco.notification.NotificationRepository;
@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationConsumer {

    private final NotificationRepository repository;
    private final EmailService emailService;
    @KafkaListener(topics = "payment-topic")
    public void consumePaymentSuccessNotifications(PaymentConfirmation paymentConfirmation) throws MessagingException {
        log.info(format("Consuming the message from payment-topic Topic:: %s", paymentConfirmation));
        repository.save(
                Notification.builder()
                        .type(PAYMENT_CONFIRMATION)
                        .notificationDate(LocalDateTime.now())
                        .paymentConfirmation(paymentConfirmation)
                        .build()
        );
        var customerName = paymentConfirmation.customerFirstname() + " " + paymentConfirmation.customerLastname();
        emailService.sendPaymentSuccessEmail(
                paymentConfirmation.customerEmail(),
                customerName,
                paymentConfirmation.amount(),
                paymentConfirmation.activationReference()
        );
    }

    @KafkaListener(topics = "activation-topic")
    public void consumeActivationConfirmationNotifications(ActivationConfirmation activationConfirmation) throws MessagingException {
        log.info(format("Consuming the message from activation-topic Topic:: %s", activationConfirmation));
        repository.save(
                Notification.builder()
                        .type(ACTIVATION_CONFIRMATION)
                        .notificationDate(LocalDateTime.now())
                        .activationConfirmation(activationConfirmation)
                        .build()
        );
        var customerName = activationConfirmation.customer().firstname() + " " + activationConfirmation.customer().lastname();
        emailService.sendActivationConfirmationEmail(
                activationConfirmation.customer().email(),
                customerName,
                activationConfirmation.totalAmount(),
                activationConfirmation.activationReference(),
                activationConfirmation.products()
        );
    }
}
