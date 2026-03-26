# Spring Auditing POC

Small Spring Boot project showing Spring Data JPA date auditing with an embedded H2 database and CRUD REST endpoints.

## Run

```bash
mvn spring-boot:run
```

API base URL: `http://localhost:8080/api/todos`

## Verify Auditing with curl (bash)

1. Create one record and capture JSON:

```bash
curl -s -X POST http://localhost:8080/api/todos \
  -H 'Content-Type: application/json' \
  -d '{"title":"First task","details":"Created from curl"}'
```

Expected concept:
- `createdDate` is set automatically.
- `lastModifiedDate` is set automatically.
- On create, both timestamps should initially match.

2. Update same record (id `1`):

```bash
curl -s -X PUT http://localhost:8080/api/todos/1 \
  -H 'Content-Type: application/json' \
  -d '{"title":"First task updated","details":"Updated from curl"}'
```

Expected concept:
- `createdDate` stays unchanged.
- `lastModifiedDate` changes to a newer timestamp.

3. Read it back:

```bash
curl -s http://localhost:8080/api/todos/1
```

4. List all:

```bash
curl -s http://localhost:8080/api/todos
```

5. Delete it:

```bash
curl -i -X DELETE http://localhost:8080/api/todos/1
```

## Helpful Extras

- H2 Console: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:auditingdb`
- Username: `sa`
- Password: (empty)
