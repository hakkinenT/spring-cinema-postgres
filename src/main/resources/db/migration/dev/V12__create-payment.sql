CREATE TABLE tb_payment(
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
    moment TIMESTAMP NOT NULL,
    payment_type INTEGER NOT NULL,
    order_id INTEGER NOT NULL,
    CONSTRAINT payment_pk
        PRIMARY KEY(id),
    CONSTRAINT order_fk
        FOREIGN KEY (order_id) REFERENCES tb_order(id)
);