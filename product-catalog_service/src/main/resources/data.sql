-- =========================
-- Products (20 entries)
-- =========================
MERGE INTO product (id, name, description, price, category, created_at) KEY(id)
    VALUES ('11111111-1111-1111-1111-111111111111', 'TrackIt Planner', 'A productivity planner app', 19.99, 'Productivity', CURRENT_TIMESTAMP);

MERGE INTO product (id, name, description, price, category, created_at) KEY(id)
    VALUES ('22222222-2222-2222-2222-222222222222', 'Smart Lamp', 'WiFi-enabled lamp with voice control', 49.99, 'Home', CURRENT_TIMESTAMP);

MERGE INTO product (id, name, description, price, category, created_at) KEY(id)
    VALUES ('33333333-3333-3333-3333-333333333333', 'Noise Cancelling Headphones', 'Over-ear headphones with ANC', 199.99, 'Electronics', CURRENT_TIMESTAMP);

MERGE INTO product (id, name, description, price, category, created_at) KEY(id)
    VALUES ('44444444-4444-4444-4444-444444444444', 'Gaming Mouse', 'RGB mouse with 6 programmable buttons', 59.99, 'Electronics', CURRENT_TIMESTAMP);

MERGE INTO product (id, name, description, price, category, created_at) KEY(id)
    VALUES ('55555555-5555-5555-5555-555555555555', 'Fitness Tracker', 'Tracks steps, heart rate, and sleep', 89.99, 'Health', CURRENT_TIMESTAMP);

MERGE INTO product (id, name, description, price, category, created_at) KEY(id)
    VALUES ('66666666-6666-6666-6666-666666666666', 'Bluetooth Speaker', 'Portable waterproof speaker', 39.99, 'Electronics', CURRENT_TIMESTAMP);

MERGE INTO product (id, name, description, price, category, created_at) KEY(id)
    VALUES ('77777777-7777-7777-7777-777777777777', 'Coffee Maker', 'Automatic drip coffee machine', 79.99, 'Home', CURRENT_TIMESTAMP);

MERGE INTO product (id, name, description, price, category, created_at) KEY(id)
    VALUES ('88888888-8888-8888-8888-888888888888', 'Standing Desk', 'Adjustable height desk', 299.99, 'Office', CURRENT_TIMESTAMP);

MERGE INTO product (id, name, description, price, category, created_at) KEY(id)
    VALUES ('99999999-9999-9999-9999-999999999999', 'Wireless Keyboard', 'Slim ergonomic keyboard', 69.99, 'Electronics', CURRENT_TIMESTAMP);

MERGE INTO product (id, name, description, price, category, created_at) KEY(id)
    VALUES ('aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa', 'Smartwatch', 'Water-resistant smartwatch with GPS', 149.99, 'Electronics', CURRENT_TIMESTAMP);

MERGE INTO product (id, name, description, price, category, created_at) KEY(id)
    VALUES ('bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb', 'Yoga Mat', 'Eco-friendly non-slip mat', 29.99, 'Health', CURRENT_TIMESTAMP);

MERGE INTO product (id, name, description, price, category, created_at) KEY(id)
    VALUES ('cccccccc-cccc-cccc-cccc-cccccccccccc', 'Electric Kettle', 'Fast-boil stainless steel kettle', 34.99, 'Home', CURRENT_TIMESTAMP);

MERGE INTO product (id, name, description, price, category, created_at) KEY(id)
    VALUES ('dddddddd-dddd-dddd-dddd-dddddddddddd', 'Drone', 'Quadcopter with HD camera', 399.99, 'Electronics', CURRENT_TIMESTAMP);

MERGE INTO product (id, name, description, price, category, created_at) KEY(id)
    VALUES ('eeeeeeee-eeee-eeee-eeee-eeeeeeeeeeee', 'E-Reader', 'Lightweight e-reader with backlight', 129.99, 'Electronics', CURRENT_TIMESTAMP);

MERGE INTO product (id, name, description, price, category, created_at) KEY(id)
    VALUES ('ffffffff-ffff-ffff-ffff-ffffffffffff', 'Air Purifier', 'HEPA filter for clean air', 199.99, 'Home', CURRENT_TIMESTAMP);

MERGE INTO product (id, name, description, price, category, created_at) KEY(id)
    VALUES ('11112222-3333-4444-5555-666677778888', 'Smart Thermostat', 'Energy-saving thermostat', 249.99, 'Home', CURRENT_TIMESTAMP);

MERGE INTO product (id, name, description, price, category, created_at) KEY(id)
    VALUES ('22223333-4444-5555-6666-777788889999', 'Laptop Stand', 'Aluminum adjustable stand', 49.99, 'Office', CURRENT_TIMESTAMP);

MERGE INTO product (id, name, description, price, category, created_at) KEY(id)
    VALUES ('33334444-5555-6666-7777-888899990000', 'Portable Charger', '10000mAh power bank', 24.99, 'Electronics', CURRENT_TIMESTAMP);

MERGE INTO product (id, name, description, price, category, created_at) KEY(id)
    VALUES ('44445555-6666-7777-8888-999900001111', 'VR Headset', 'Immersive virtual reality headset', 499.99, 'Electronics', CURRENT_TIMESTAMP);

MERGE INTO product (id, name, description, price, category, created_at) KEY(id)
    VALUES ('55556666-7777-8888-9999-000011112222', 'Smart Doorbell', 'Video doorbell with motion detection', 179.99, 'Home', CURRENT_TIMESTAMP);

-- =========================
-- Image URLs (safe inserts)
-- =========================
MERGE INTO product_image_urls (product_id, image_urls) KEY(product_id, image_urls)
    VALUES ('11111111-1111-1111-1111-111111111111', 'https://example.com/images/trackit1.png');

MERGE INTO product_image_urls (product_id, image_urls) KEY(product_id, image_urls)
    VALUES ('22222222-2222-2222-2222-222222222222', 'https://example.com/images/lamp1.png');

MERGE INTO product_image_urls (product_id, image_urls) KEY(product_id, image_urls)
    VALUES ('33333333-3333-3333-3333-333333333333', 'https://example.com/images/headphones1.png');

MERGE INTO product_image_urls (product_id, image_urls) KEY(product_id, image_urls)
    VALUES ('44444444-4444-4444-4444-444444444444', 'https://example.com/images/mouse1.png');

MERGE INTO product_image_urls (product_id, image_urls) KEY(product_id, image_urls)
    VALUES ('55555555-5555-5555-5555-555555555555', 'https://example.com/images/tracker1.png');

MERGE INTO product_image_urls (product_id, image_urls) KEY(product_id, image_urls)
    VALUES ('66666666-6666-6666-6666-666666666666', 'https://example.com/images/speaker1.png');

MERGE INTO product_image_urls (product_id, image_urls) KEY(product_id, image_urls)
    VALUES ('77777777-7777-7777-7777-777777777777', 'https://example.com/images/coffeemaker1.png');

MERGE INTO product_image_urls (product_id, image_urls) KEY(product_id, image_urls)
    VALUES ('88888888-8888-8888-8888-888888888888', 'https://example.com/images/desk1.png');

MERGE INTO product_image_urls (product_id, image_urls) KEY(product_id, image_urls)
    VALUES ('99999999-9999-9999-9999-999999999999', 'https://example.com/images/keyboard1.png');

MERGE INTO product_image_urls (product_id, image_urls) KEY(product_id, image_urls)
    VALUES ('aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa', 'https://example.com/images/smartwatch1.png');

MERGE INTO product_image_urls (product_id, image_urls) KEY(product_id, image_urls)
    VALUES ('bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb', 'https://example.com/images/yogamat1.png');

MERGE INTO product_image_urls (product_id, image_urls) KEY(product_id, image_urls)
    VALUES ('cccccccc-cccc-cccc-cccc-cccccccccccc', 'https://example.com/images/kettle1.png');

MERGE INTO product_image_urls (product_id, image_urls) KEY(product_id, image_urls)
    VALUES ('dddddddd-dddd-dddd-dddd-dddddddddddd', 'https://example.com/images/drone1.png');

MERGE INTO product_image_urls (product_id, image_urls) KEY(product_id, image_urls)
    VALUES ('eeeeeeee-eeee-eeee-eeee-eeeeeeeeeeee', 'https://example.com/images/ereader1.png');

MERGE INTO product_image_urls (product_id, image_urls) KEY(product_id, image_urls)
    VALUES ('ffffffff-ffff-ffff-ffff-ffffffffffff', 'https://example.com/images/airpurifier1.png');

MERGE INTO product_image_urls (product_id, image_urls) KEY(product_id, image_urls)
    VALUES ('11112222-3333-4444-5555-666677778888', 'https://example.com/images/thermostat1.png');

MERGE INTO product_image_urls (product_id, image_urls) KEY(product_id, image_urls)
    VALUES ('22223333-4444-5555-6666-777788889999', 'https://example.com/images/laptopstand1.png');

MERGE INTO product_image_urls (product_id, image_urls) KEY(product_id, image_urls)
    VALUES ('33334444-5555-6666-7777-888899990000', 'https://example.com/images/charger1.png');

MERGE INTO product_image_urls (product_id, image_urls) KEY(product_id, image_urls)
    VALUES ('44445555-6666-7777-8888-999900001111', 'https://example.com/images/vr1.png');

MERGE INTO product_image_urls (product_id, image_urls) KEY(product_id, image_urls)
    VALUES ('55556666-7777-8888-9999-000011112222', 'https://example.com/images/doorbell1.png');
