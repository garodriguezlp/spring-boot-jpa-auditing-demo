# Spring Data JPA Auditing Demo

A compact Spring Boot REST API demonstrating automatic auditing fields using Spring Data JPA.

## Features

- CRUD API for todo items.
- Automatic `createdDate` and `lastModifiedDate` handling.
- In-memory H2 database for zero-setup local runs.
- Bean Validation on incoming API payloads.

## Stack

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- H2 Database
- Maven

## Run Locally

```bash
mvn spring-boot:run
```

Base URL: `http://localhost:8080/api/todos`

## Quick API Smoke Test

Create:

```bash
curl -s -X POST http://localhost:8080/api/todos \
  -H 'Content-Type: application/json' \
  -d '{"title":"First task","details":"Created from curl"}'
```

Update (`id=1`):

```bash
curl -s -X PUT http://localhost:8080/api/todos/1 \
  -H 'Content-Type: application/json' \
  -d '{"title":"First task updated","details":"Updated from curl"}'
```

Get one:

```bash
curl -s http://localhost:8080/api/todos/1
```

Get all:

```bash
curl -s http://localhost:8080/api/todos
```

Delete:

```bash
curl -i -X DELETE http://localhost:8080/api/todos/1
```

## Auditing Behavior

- `createdDate` is populated once, when the entity is created.
- `lastModifiedDate` is updated on each successful update.
- On creation, both timestamps typically start with the same value.

## H2 Console

- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:auditingdb`
- User: `sa`
- Password: empty
