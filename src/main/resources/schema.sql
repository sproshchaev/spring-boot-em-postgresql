-- Создание схемы (если она ещё не существует)
CREATE SCHEMA IF NOT EXISTS library;

-- Создание таблицы в рамках схемы
CREATE TABLE IF NOT EXISTS library.books (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL
);