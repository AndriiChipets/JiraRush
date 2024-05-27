Task management application, such Jira or Trello.

# Introduction
This application is not created from scratch by myself. I've implemented some features which are described bellow.

# Technologies Used
- Spring Boot
- Spring JPA
- Hibernate
- PostgreSQL
- Liquibase
- Spring Security
- Spring MVC
- Thymeleaf
- jQuery
- Swagger
- Lombok
- Mapstruct
- Spring Test
- JUnit
- Docker

# Implemented Features
- removed from application vk and yandex social media
- moved all sensitive information to the .env file
- changed testing DB from PostgresQL to H2 in-memory DB
- added test methods for ProfileRestController class
- refactored com.javarush.jira.bugtracking.attachment.FileUtil#upload method to use a modern approach working with a file system
- added new functionality to add TAG to TASK entities, only the backend part
- added new functionality to count the time taken to work with TASK and to test TASK
- added a docker file for the main server
- added docker-compose file to start an application with DB and NGING server
