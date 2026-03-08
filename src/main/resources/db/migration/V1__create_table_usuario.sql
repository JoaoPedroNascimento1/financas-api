CREATE TABLE usuario (
                       id serial PRIMARY KEY,
                       title varchar(255) NOT NULL,
                       email varchar(255) NOT NULL UNIQUE,
                       senha varchar(255) NOT NULL
);
