-- =========================
-- Products (20 entries)
-- =========================
INSERT INTO product (name, description, price, category, created_at)
VALUES ('TrackIt Planner', 'A productivity planner app', 19.99, 'Productivity', CURRENT_TIMESTAMP);

INSERT INTO product (name, description, price, category, created_at)
VALUES ('Smart Lamp', 'WiFi-enabled lamp with voice control', 49.99, 'Home', CURRENT_TIMESTAMP);

INSERT INTO product (name, description, price, category, created_at)
VALUES ('Noise Cancelling Headphones', 'Over-ear headphones with ANC', 199.99, 'Electronics', CURRENT_TIMESTAMP);

INSERT INTO product (name, description, price, category, created_at)
VALUES ('Gaming Mouse', 'RGB mouse with 6 programmable buttons', 59.99, 'Electronics', CURRENT_TIMESTAMP);

INSERT INTO product (name, description, price, category, created_at)
VALUES ('Fitness Tracker', 'Tracks steps, heart rate, and sleep', 89.99, 'Health', CURRENT_TIMESTAMP);

INSERT INTO product (name, description, price, category, created_at)
VALUES ('Bluetooth Speaker', 'Portable waterproof speaker', 39.99, 'Electronics', CURRENT_TIMESTAMP);

INSERT INTO product (name, description, price, category, created_at)
VALUES ('Coffee Maker', 'Automatic drip coffee machine', 79.99, 'Home', CURRENT_TIMESTAMP);

INSERT INTO product (name, description, price, category, created_at)
VALUES ('Standing Desk', 'Adjustable height desk', 299.99, 'Office', CURRENT_TIMESTAMP);

INSERT INTO product (name, description, price, category, created_at)
VALUES ('Wireless Keyboard', 'Slim ergonomic keyboard', 69.99, 'Electronics', CURRENT_TIMESTAMP);

INSERT INTO product (name, description, price, category, created_at)
VALUES ('Smartwatch', 'Water-resistant smartwatch with GPS', 149.99, 'Electronics', CURRENT_TIMESTAMP);

INSERT INTO product (name, description, price, category, created_at)
VALUES ('Yoga Mat', 'Eco-friendly non-slip mat', 29.99, 'Health', CURRENT_TIMESTAMP);

INSERT INTO product (name, description, price, category, created_at)
VALUES ('Electric Kettle', 'Fast-boil stainless steel kettle', 34.99, 'Home', CURRENT_TIMESTAMP);

INSERT INTO product (name, description, price, category, created_at)
VALUES ('Drone', 'Quadcopter with HD camera', 399.99, 'Electronics', CURRENT_TIMESTAMP);

INSERT INTO product (name, description, price, category, created_at)
VALUES ('E-Reader', 'Lightweight e-reader with backlight', 129.99, 'Electronics', CURRENT_TIMESTAMP);

INSERT INTO product (name, description, price, category, created_at)
VALUES ('Air Purifier', 'HEPA filter for clean air', 199.99, 'Home', CURRENT_TIMESTAMP);

INSERT INTO product (name, description, price, category, created_at)
VALUES ('Smart Thermostat', 'Energy-saving thermostat', 249.99, 'Home', CURRENT_TIMESTAMP);

INSERT INTO product (name, description, price, category, created_at)
VALUES ('Laptop Stand', 'Aluminum adjustable stand', 49.99, 'Office', CURRENT_TIMESTAMP);

INSERT INTO product (name, description, price, category, created_at)
VALUES ('Portable Charger', '10000mAh power bank', 24.99, 'Electronics', CURRENT_TIMESTAMP);

INSERT INTO product (name, description, price, category, created_at)
VALUES ('VR Headset', 'Immersive virtual reality headset', 499.99, 'Electronics', CURRENT_TIMESTAMP);

INSERT INTO product (name, description, price, category, created_at)
VALUES ('Smart Doorbell', 'Video doorbell with motion detection', 179.99, 'Home', CURRENT_TIMESTAMP);


-- =========================
-- Product Image URLs
-- =========================
INSERT INTO product_image_urls (product_id, image_urls) VALUES (1, 'https://example.com/images/trackit1.png');
INSERT INTO product_image_urls (product_id, image_urls) VALUES (2, 'https://example.com/images/lamp1.png');
INSERT INTO product_image_urls (product_id, image_urls) VALUES (3, 'https://example.com/images/headphones1.png');
INSERT INTO product_image_urls (product_id, image_urls) VALUES (4, 'https://example.com/images/mouse1.png');
INSERT INTO product_image_urls (product_id, image_urls) VALUES (5, 'https://example.com/images/tracker1.png');
INSERT INTO product_image_urls (product_id, image_urls) VALUES (6, 'https://example.com/images/speaker1.png');
INSERT INTO product_image_urls (product_id, image_urls) VALUES (7, 'https://example.com/images/coffeemaker1.png');
INSERT INTO product_image_urls (product_id, image_urls) VALUES (8, 'https://example.com/images/desk1.png');
INSERT INTO product_image_urls (product_id, image_urls) VALUES (9, 'https://example.com/images/keyboard1.png');
INSERT INTO product_image_urls (product_id, image_urls) VALUES (10, 'https://example.com/images/smartwatch1.png');
INSERT INTO product_image_urls (product_id, image_urls) VALUES (11, 'https://example.com/images/yogamat1.png');
INSERT INTO product_image_urls (product_id, image_urls) VALUES (12, 'https://example.com/images/kettle1.png');
INSERT INTO product_image_urls (product_id, image_urls) VALUES (13, 'https://example.com/images/drone1.png');
INSERT INTO product_image_urls (product_id, image_urls) VALUES (14, 'https://example.com/images/ereader1.png');
INSERT INTO product_image_urls (product_id, image_urls) VALUES (15, 'https://example.com/images/airpurifier1.png');
INSERT INTO product_image_urls (product_id, image_urls) VALUES (16, 'https://example.com/images/thermostat1.png');
INSERT INTO product_image_urls (product_id, image_urls) VALUES (17, 'https://example.com/images/laptopstand1.png');
INSERT INTO product_image_urls (product_id, image_urls) VALUES (18, 'https://example.com/images/charger1.png');
INSERT INTO product_image_urls (product_id, image_urls) VALUES (19, 'https://example.com/images/vr1.png');
INSERT INTO product_image_urls (product_id, image_urls) VALUES (20, 'https://example.com/images/doorbell1.png');
