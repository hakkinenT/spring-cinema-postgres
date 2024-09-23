CREATE TABLE tb_order(
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
    moment TIMESTAMP NOT NULL,
    total DECIMAL NOT NULL,
    user_id INTEGER NOT NULL,
    CONSTRAINT order_pk
        PRIMARY KEY(id),
    CONSTRAINT user_fk
        FOREIGN KEY (user_id) REFERENCES tb_user(id)
);