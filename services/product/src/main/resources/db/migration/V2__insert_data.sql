-- Insert categories for Telco services
INSERT INTO category (id, description, name) VALUES (nextval('category_seq'), 'International roaming services for use abroad', 'Roaming');
INSERT INTO category (id, description, name) VALUES (nextval('category_seq'), 'Personalization services like ring-back tones', 'Personalization');
INSERT INTO category (id, description, name) VALUES (nextval('category_seq'), 'Data top-ups and internet packages', 'Data Services');
INSERT INTO category (id, description, name) VALUES (nextval('category_seq'), 'Additional value-added services for customers', 'Value-Added Services');

-- Insert products for the 'Roaming' category
INSERT INTO public.product (id, description, name, price, category_id)
VALUES
    (nextval('product_seq'), 'Global roaming service for seamless connectivity abroad', 'International Roaming Package', 50.00, (SELECT id FROM category WHERE name = 'Roaming')),
    (nextval('product_seq'), 'Daily roaming pass for short trips', 'Daily Roaming Pass', 15.00, (SELECT id FROM category WHERE name = 'Roaming'));

-- Insert products for the 'Personalization' category
INSERT INTO public.product (id, description, name, price, category_id)
VALUES
    (nextval('product_seq'), 'Customizable ring-back tone for personal calls', 'Ring-back Tone Personalization', 5.00, (SELECT id FROM category WHERE name = 'Personalization')),
    (nextval('product_seq'), 'Seasonal ring-back tones for special occasions', 'Seasonal Ring-back Tone', 3.00, (SELECT id FROM category WHERE name = 'Personalization'));

-- Insert products for the 'Data Services' category
INSERT INTO public.product (id, description, name, price, category_id)
VALUES
    (nextval('product_seq'), '1GB data top-up for high-speed internet', '1GB Data Top-up', 10.00, (SELECT id FROM category WHERE name = 'Data Services')),
    (nextval('product_seq'), '5GB data package for extensive use', '5GB Data Package', 40.00, (SELECT id FROM category WHERE name = 'Data Services'));

-- Insert products for the 'Value-Added Services' category
INSERT INTO public.product (id, description, name, price, category_id)
VALUES
    (nextval('product_seq'), 'Caller ID blocking service for privacy', 'Caller ID Block', 2.00, (SELECT id FROM category WHERE name = 'Value-Added Services')),
    (nextval('product_seq'), 'Voicemail to text service', 'Voicemail to Text', 4.99, (SELECT id FROM category WHERE name = 'Value-Added Services'));
