-- productos
INSERT INTO products (id, description, unit_price, stock) VALUES (1, 'Laptop Dell Inspiron', 850.0, 10);
INSERT INTO products (id, description, unit_price, stock) VALUES (2, 'Mouse Inalámbrico', 25.99, 50);
INSERT INTO products (id, description, unit_price, stock) VALUES (3, 'Monitor Samsung 24"', 150.0, 20);
INSERT INTO products (id, description, unit_price, stock) VALUES (4, 'Teclado Mecánico', 70.0, 15);
INSERT INTO products (id, description, unit_price, stock) VALUES (5, 'Silla gamer', 210.5, 5);
INSERT INTO products (id, description, unit_price, stock) VALUES (6, 'Disco Duro Externo 1TB', 89.99, 25);
INSERT INTO products (id, description, unit_price, stock) VALUES (7, 'Tablet Samsung Galaxy Tab', 300.0, 12);
INSERT INTO products (id, description, unit_price, stock) VALUES (8, 'Webcam Logitech Full HD', 49.99, 30);
INSERT INTO products (id, description, unit_price, stock) VALUES (9, 'Router TP-Link', 65.0, 18);
INSERT INTO products (id, description, unit_price, stock) VALUES (10, 'USB Kingston 64GB', 15.0, 100);
INSERT INTO products (id, description, unit_price, stock) VALUES (11, 'Procesador AMD Ryzen 5', 220.0, 8);
INSERT INTO products (id, description, unit_price, stock) VALUES (12, 'Tarjeta Madre ASUS', 140.0, 6);
INSERT INTO products (id, description, unit_price, stock) VALUES (13, 'Gabinete', 110.0, 7);
INSERT INTO products (id, description, unit_price, stock) VALUES (14, 'Fuente de Poder 650W', 85.0, 10);
INSERT INTO products (id, description, unit_price, stock) VALUES (15, 'SSD Samsung 500GB', 75.0, 20);

ALTER TABLE products ALTER COLUMN id RESTART WITH 16;

-- ventas
INSERT INTO sales (id, product_id, date, quantity, unit_price, total) VALUES (1, 1, '2025-04-13 20:00:00', 1, 850.0, 850.0);
INSERT INTO sales (id, product_id, date, quantity, unit_price, total) VALUES (2, 2, '2025-04-21 18:30:00', 2, 25.99, 51.98);
INSERT INTO sales (id, product_id, date, quantity, unit_price, total) VALUES (3, 3, '2025-04-15 12:25:00', 1, 150.0, 150.0);
INSERT INTO sales (id, product_id, date, quantity, unit_price, total) VALUES (4, 5, '2025-04-14 15:50:00', 1, 210.5, 210.5);
INSERT INTO sales (id, product_id, date, quantity, unit_price, total) VALUES (5, 6, '2025-04-15 08:35:00', 2, 89.99, 179.98);
INSERT INTO sales (id, product_id, date, quantity, unit_price, total) VALUES (6, 8, '2025-04-16 10:55:00', 1, 49.99, 49.99);
INSERT INTO sales (id, product_id, date, quantity, unit_price, total) VALUES (7, 10, '2025-04-17 11:45:00', 3, 15.0, 45.0);
INSERT INTO sales (id, product_id, date, quantity, unit_price, total) VALUES (8, 15, '2025-04-16 19:05:00', 1, 75.0, 75.0);

ALTER TABLE sales ALTER COLUMN id RESTART WITH 9;