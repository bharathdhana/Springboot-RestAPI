
# Spring Boot Project Documentation

This document provides step-by-step instructions to set up and run a Java Spring Boot application with PostgreSQL using Docker.

---

## ✅ 1. Install IntelliJ Ultimate

- **Important**: Use IntelliJ Ultimate for working with Spring Boot. The Community Edition does not support all Spring features.

---

## ✅ 2. Create Spring Boot Project

- Use **Spring Initializr** or IntelliJ's project wizard.
- Choose **Maven** as the build tool.
- Select required dependencies such as:
  - Spring Web
  - Spring Data JPA
  - PostgreSQL Driver
  - Lombok (optional but recommended)

---

## ✅ 3. Configure Database

- Use PostgreSQL as the database.
- Update `application.properties` as follows:

\`\`\`properties
spring.application.name=module-one
# server.port=3000

spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=password
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.show-sql=true
\`\`\`

---

## ✅ 4. Run the Spring Boot Application

- Run the main class in IntelliJ or use `mvn spring-boot:run`.

---

## ✅ 5. Create HTTP Requests

### Supported HTTP methods:
- `GET`
- `POST`
- `PUT`
- `DELETE`

---

## ✅ 6. Create API Endpoints

### Example:

### Create `Engineer.java`:

\`\`\`java
package com.example.demo.model;

import java.util.Objects;

public class Engineer {
    private Long id;
    private String name;
    private String[] techStack;

    public Engineer() {}

    public Engineer(Long id, String name, String[] techStack) {
        this.id = id;
        this.name = name;
        this.techStack = techStack;
    }

    // Getters and Setters

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Engineer)) return false;
        Engineer engineer = (Engineer) o;
        return id.equals(engineer.id) &&
               name.equals(engineer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
\`\`\`

### Create Controller:

\`\`\`java
package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/engineers")
public class EngineerController {

    @GetMapping
    @ResponseBody
    public String getEngineers() {
        return "GET Engineers";
    }

    @PostMapping
    @ResponseBody
    public String addEngineer() {
        return "POST Engineer";
    }

    @PutMapping
    @ResponseBody
    public String updateEngineer() {
        return "PUT Engineer";
    }

    @DeleteMapping
    @ResponseBody
    public String deleteEngineer() {
        return "DELETE Engineer";
    }
}
\`\`\`

---

## ✅ 7. Test HTTP Requests

- Use tools like Postman or Curl to test GET, POST, PUT, DELETE endpoints.

---

## ✅ 8. Install Docker Desktop

- Download and install [Docker Desktop](https://www.docker.com/products/docker-desktop).

---

## ✅ 9. Configure PostgreSQL using Docker

### Create `docker-compose.yml` file:

\`\`\`yaml
version: '3.8'

services:
  postgres:
    image: postgres:15.14-bookworm
    container_name: my-postgres
    restart: unless-stopped
    environment:
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: password
      POSTGRES_DB: data/postgres
    ports:
      - "5432:5432"
    volumes:
      - pgdata:/var/lib/postgresql/data

volumes:
  pgdata:
\`\`\`

### Start PostgreSQL container

\`\`\`bash
cd "/home/dhanavan/Documents/Full Stack Journey/SpringBoot/module-one/"
sudo docker-compose up -d
\`\`\`

### Check running containers

\`\`\`bash
docker-compose ps
\`\`\`

### Connect to PostgreSQL inside container

\`\`\`bash
docker exec -it my-postgres psql -U postgres -d data/postgres
\`\`\`

---

### Connect from Ubuntu Host

\`\`\`bash
sudo apt install postgresql-client -y
psql -h localhost -p 5432 -U postgres -d data/postgres
\`\`\`

---

### PostgreSQL Commands

- List all databases: `\l`
- Connect to database: `\c data/postgres`
- List tables: `\dt`
- Create table:

\`\`\`sql
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    email VARCHAR(100)
);
\`\`\`

- Insert data:

\`\`\`sql
INSERT INTO users (name, email) VALUES ('Bharath', 'bharath@example.com');
\`\`\`

- View data:

\`\`\`sql
SELECT * FROM users;
\`\`\`

- Exit PostgreSQL: `\q`

- View Docker logs:

\`\`\`bash
sudo docker-compose logs
\`\`\`

---

## ✅ 10. Working with Arrays in PostgreSQL

\`\`\`sql
CREATE TABLE engineer (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    tech_stack TEXT[]
);
\`\`\`

```sql
INSERT INTO engineer (name, tech_stack) VALUES ('Sean', '{"Java","Python","CSS"}');
```

For normal strings:

```sql
INSERT INTO engineer (name, tech_stack) VALUES ('Sean', 'Java, Python, CSS');
```

Query table:

```sql
SELECT * FROM engineer;
```

---

## ✅ 11. Additional PostgreSQL Commands

- Enter container:

```bash
sudo docker exec -it my-postgres bash
```

- Access PostgreSQL inside container:

```bash
psql -U postgres -d data/postgres
```

- List tables: `\dt`
- Query data: `SELECT * FROM users;`
- Exit: `\q`
- Exit container: `exit`

---

## ✅ 12. Verifying the Container

- Connect to database:

```bash
sudo psql -h localhost -p 5432 -U postgres -d data/postgres
```

- Enter container:

```bash
sudo docker exec -it my-postgres bash
```

- Connect inside container: `\c postgres`
- Check table structure: `\d tablename`

---

This documentation covers the installation, configuration, and basic usage of a Spring Boot application connected with PostgreSQL via Docker.
