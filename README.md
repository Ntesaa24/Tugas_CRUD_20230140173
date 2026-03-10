# Tugas CRUD Spring Boot - KTP Management

This project is a Spring Boot application for managing KTP (Indonesian Identity Card) records. It includes a RESTful API backend and a modern, premium frontend using HTML, CSS, and jQuery.

## Features

- **Full CRUD Operations**: Create, Read, Update, and Delete KTP records.
- **Premium UI**: Modern dashboard with Outfit typography, smooth gradients, and micro-animations.
- **Validation**: Server-side validation for mandatory fields and 16-digit KTP numbers.
- **Error Handling**: Centralized global exception handling with friendly error messages.
- **Package Structure**: clean architecture with `model`, `entity`, `dto`, `repository`, `service`, `impl`, `util`, `mapper`, and `controller`.

## Tech Stack

- **Backend**: Java 17, Spring Boot 3.4.1, Spring Data JPA, MySQL Connector, ModelMapper, Lombok.
- **Frontend**: HTML5, CSS3 (Vanilla), jQuery (Ajax).
- **Database**: MySQL.

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6+
- MySQL Server (running on localhost:3306)

### Installation

1. Create a MySQL database named `spring`.
2. Configure your database credentials in `src/main/resources/application.properties`.
3. Run the application:
   ```bash
   mvn spring-boot:run
   ```
4. Access the application at `http://localhost:8080/index.html`.

## API Endpoints

- `POST /ktp`: Create a new KTP.
- `GET /ktp`: Get all KTP records.
- `GET /ktp/{id}`: Get a KTP by ID.
- `PUT /ktp/{id}`: Update an existing KTP.
- `DELETE /ktp/{id}`: Delete a KTP.
