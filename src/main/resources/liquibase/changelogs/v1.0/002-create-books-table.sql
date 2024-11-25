--liquibase formatted sql
--changeset author:create-books-table-v1.0
CREATE TABLE IF NOT EXISTS library.books (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL
);