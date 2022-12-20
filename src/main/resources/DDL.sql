CREATE TABLE discount_card (
  id BIGINT NOT NULL,
   value INTEGER NOT NULL,
   CONSTRAINT pk_discount_card PRIMARY KEY (id)
);

CREATE TABLE product (
  id BIGINT NOT NULL,
   name VARCHAR(255) NOT NULL,
   price INTEGER NOT NULL,
   sale BOOLEAN NOT NULL,
   CONSTRAINT pk_product PRIMARY KEY (id)
);