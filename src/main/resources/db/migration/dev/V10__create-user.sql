CREATE TABLE tb_user(
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    birth_date DATE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role_id INTEGER NOT NULL,
    CONSTRAINT user_pk
        PRIMARY KEY(id),
    CONSTRAINT role_fk
        FOREIGN KEY (role_id) REFERENCES tb_role(id)
);