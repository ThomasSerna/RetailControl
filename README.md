# Retail Control API

## Overview

**Retail Control API** is a Spring Boot RESTful service for an **inventory management** system. It allows management of products, stores, stock inventory, and customer orders in a retail context. The API follows a **polyglot persistence** approach, using **MySQL** for core relational data and **MongoDB** for product reviews.

---

## Features

- Product management (CRUD + search)
- Store management
- Inventory management per store
- Order placement with automatic stock deduction
- Customer auto-creation by email
- Product reviews stored in MongoDB

---

## Tech Stack

- Java 21  
- Spring Boot 4  
- Spring Data JPA (MySQL)  
- Spring Data MongoDB  
- MySQL 8  
- MongoDB 7  
- Docker & Docker Compose  
- Maven  

---

## Installation & Setup

### Requirements

- Java 21
- Maven or Maven Wrapper
- Docker & Docker Compose

### Clone Repository

```bash
git clone https://github.com/ThomasSerna/RetailControlAPI.git
cd RetailControlAPI
```

### Start Databases (Docker)

```bash
docker-compose up -d
```

This starts:

- MySQL → `RetailControlDB`
- MongoDB → `RetailControlDB`

Credentials (default):

- User: `root`
- Password: `password`

### Run Application

```bash
./mvnw spring-boot:run
```

Or build and run:

```bash
./mvnw clean package
java -jar target/RetailControl-0.0.1-SNAPSHOT.jar
```

Application runs at:

```
http://localhost:8080
```

---

## API Response Format

All endpoints return a unified response structure:

```json
{
  "message": "Operation result",
  "status": "ok | created | error",
  "statusCode": 200,
  "data": {}
}
```

---

## API Endpoints

### Products

- `POST /product`
- `GET /product/{id}`
- `PUT /product`
- `DELETE /product/{id}`
- `GET /product`
- `GET /product/searchProduct?name=`

### Stores & Orders

- `POST /store`
- `GET /store/validate/{storeId}`
- `POST /store/placeOrder`

### Inventory

- `POST /inventory`
- `PUT /inventory`
- `GET /inventory/{storeId}`
- `GET /inventory/search/{storeId}?name=`
- `GET /inventory/validate/{storeId}/{productId}?quantity=`

### Reviews (MongoDB)

- `POST /reviews`
- `GET /reviews/{storeId}/{productId}`

---

## Example Request

### Create Product

```http
POST /product
Content-Type: application/json

{
  "name": "Wireless Mouse",
  "category": "Electronics",
  "price": 25.99,
  "sku": "WM-001"
}
```

---

## Notes

- Validation errors → HTTP 400
- Duplicate resources → HTTP 409
- Not found → HTTP 404
- Logs stored in `logs/app.log`
- Schema auto-updated via `ddl-auto=update`

---

Developed by **Thomas Serna**
