package com.sricare.telco.activation;

import com.sricare.telco.activationline.ActivationLineRequest;
import com.sricare.telco.activationline.ActivationLineService;
import com.sricare.telco.customer.CustomerClient;
import com.sricare.telco.exception.BusinessException;
import com.sricare.telco.kafka.ActivationConfirmation;
import com.sricare.telco.kafka.ActivationProducer;
import com.sricare.telco.payment.PaymentClient;
import com.sricare.telco.payment.PaymentRequest;
import com.sricare.telco.product.ProductClient;
import com.sricare.telco.product.PurchaseRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivationService {

    private final ActivationRepository repository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final ActivationMapper mapper;
    private final ActivationLineService activationLineService;
    private final ActivationProducer activationProducer;
    private final PaymentClient paymentClient;
    public Integer createActivation(ActivationRequest request) {
        //check the customer using openFeign
        var customer = this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException("Cannot activate service:: No customer exists with the provided ID"));

        //purchase the product using the product ms (RestTemplate)
        var purchasedProducts = this.productClient.purchaseProducts(request.products());

        //persist activation
        var activation = this.repository.save(mapper.toActivate(request));

        //persist activation lines
        for (PurchaseRequest purchaseRequest : request.products()) {
            activationLineService.saveActivationLine(
                    new ActivationLineRequest(
                            null,
                            activation.getId(),
                            purchaseRequest.productId()
                    )
            );
        }

        //start payment process
        var paymentRequest = new PaymentRequest(
                request.amount(),
                request.paymentMethod(),
                activation.getId(),
                activation.getReference(),
                customer
        );

        paymentClient.requestOrderPayment(paymentRequest);

        //send the activation confirmation using the notification ms (kafka)
        activationProducer.sendActivationConfirmation(
                new ActivationConfirmation(
                        request.reference(),
                        request.amount(),
                        request.paymentMethod(),
                        customer,
                        purchasedProducts
                )
        );

        return activation.getId();
    }


    public List<ActivationResponse> findAllActivations() {
        return this.repository.findAll()
                .stream()
                .map(this.mapper::fromActivation)
                .collect(Collectors.toList());
    }

    public ActivationResponse findById(Integer id) {
        return this.repository.findById(id)
                .map(mapper::fromActivation)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No activation found with the provided ID: %d", id)));
    }
}
