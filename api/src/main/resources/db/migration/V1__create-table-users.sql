CREATE TABLE tb_users(
    id binary(16) PRIMARY KEY,
    login varchar(255) NOT NULL,
    password varchar(255) NOT NULL
);