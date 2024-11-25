# Интеграционное тестирование репозитория с встроенной БД PostgreSQL на io.zonky

Примечание:
1) Проект io.zonky (форк от otj-pg-embedded) позволяет запускать БД PostgreSQL без контейнера Docker
2) Проект otj-pg-embedded хоть и называется встроенной БД PostgreSQL, но требует Docker и при запуске начинает скачивать 
образы из Docker-Hub

### References
1. https://www.baeldung.com/spring-boot-embed-postgresql-testing
2. Шесть советов об использовании PostgreSQL в функциональных тестах https://habr.com/ru/articles/501454/