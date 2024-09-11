CREATE TABLE tb_order(
    order_id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
    moment TIMESTAMP NOT NULL,
    total DECIMAL NOT NULL,
    user_id INTEGER NOT NULL,
    PRIMARY KEY(order_id),
    FOREIGN KEY (user_id) REFERENCES tb_user(user_id)
);