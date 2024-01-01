CREATE TABLE shop
 (
 id integer primary key auto_increment,
 identifier varchar NOT null,
 status varchar NOT null,
 date_shop date
 );

CREATE TABLE shop_item
 (
 id integer PRIMARY KEY auto_increment,
 product_identifier VARCHAR(100) NOT NULL,
 amount INT NOT NULL,
 price FLOAT NOT NULL,
 shop_id BIGINT REFERENCES shop(id)
 ); 