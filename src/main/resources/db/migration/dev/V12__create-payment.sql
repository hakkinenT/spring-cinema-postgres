CREATE TABLE tb_payment(
    payment_id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
    moment TIMESTAMP NOT NULL,
    payment_type INTEGER NOT NULL,
    order_id INTEGER NOT NULL,
    PRIMARY KEY(payment_id),
    FOREIGN KEY (order_id) REFERENCES tb_order(order_id)
);