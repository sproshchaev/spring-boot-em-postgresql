# Интеграционное тестирование репозитория с встроенной БД PostgreSQL на io.zonky
- embedded-database-spring-test
- embedded-postgres

Примечание:
1) Проект io.zonky (форк от otj-pg-embedded) позволяет запускать БД PostgreSQL без контейнера Docker:
  - версию PostgreSQL можно менять через embedded-postgres в pom.xml, версия 2.7.0 запускает PostgreSQL 14.10
  - в schema.sql скрипт для создания БД
  - application.properties - настройки для подключения к БД

2) Проект otj-pg-embedded хоть и называется встроенной БД PostgreSQL, но требует Docker и при запуске начинает скачивать 
образы из Docker-Hub

### References
1. Embedded PostgreSQL for Spring Boot Tests https://www.baeldung.com/spring-boot-embed-postgresql-testing
2. Шесть советов об использовании PostgreSQL в функциональных тестах https://habr.com/ru/articles/501454/