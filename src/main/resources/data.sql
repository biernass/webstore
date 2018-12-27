INSERT INTO products(product_id, category, description, manufacturer, name,unit_price, units_in_stock, discounted)
 VALUES (1, 'ELECTRONICS', 'Opis pierwszego przedmiotu Opis pierwszego przedmiotu','APPLE', 'iPhone 6S',1000, 200, false );

INSERT INTO products(product_id, category, description, manufacturer, name,unit_price, units_in_stock, discounted)
 VALUES (2, 'ELECTRONICS', 'Opis drugiego przedmiotu Opis drugiego przedmiotu','LG', 'JAKIŚ',1000, 200, false );

INSERT INTO products(product_id, category, description, manufacturer, name,unit_price, units_in_stock, discounted)
 VALUES (3, 'ELECTRONICS', 'Opis trzeciego przedmiotu Opis trzeciego przedmiotu','SAMSUNG', 'GALAXY S9',1000, 200, false );


INSERT INTO address(address_id, street, number, city, zip_code)
 VALUES (1, 'Księcia Janusza', 14, 'Warszawa', '03-289');

INSERT INTO address(address_id, street, number, city, zip_code)
 VALUES (2, 'Świdnicka', 12, 'Kraków', '05-675');

 INSERT INTO address(address_id, street, number, city, zip_code)
 VALUES (3, 'Kolejowa', 5, 'Olsztyn', '11-223');


 INSERT INTO customer(customer_id, first_name, last_name, address_id, orders_number)
 VALUES (1, 'Łukasz', 'Niedźwiecki', 3, 14);

INSERT INTO customer(customer_id, first_name, last_name, address_id, orders_number)
 VALUES (2, 'Michał', 'Maleńczuk', 2, 1);

 INSERT INTO customer(customer_id, first_name, last_name, address_id, orders_number)
 VALUES (3, 'Artur', 'Płatek', 1, 2);
