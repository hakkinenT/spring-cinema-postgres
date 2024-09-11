CREATE TABLE tb_user(
    user_id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    birth_date DATE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role_id INTEGER NOT NULL,
    PRIMARY KEY(user_id),
    FOREIGN KEY (role_id) REFERENCES tb_role(role_id)
);