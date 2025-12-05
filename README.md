# 🗂️ Product Catalog Service

## Overview
The **Product Catalog Service** is a core microservice in the e‑commerce ecosystem: "UniCart".  
Its responsibility is to **manage all product information**, including names, descriptions, pricing, categories, and images.  
This service is consumed by other services such as **Shopping Cart, Order, Review, and Search**.

---

## Key Features
- Full **CRUD operations** for products
- Store product details: name, description, images, price, category
- Fetch a list of all products
- Fetch details of a single product by ID
- Filter products by category
- Batch fetch products by IDs (used by Cart & Order services)

---

## Data Model

| Column       | Type                | Description                               |
|--------------|---------------------|-------------------------------------------|
| `product_id` | Integer             | Unique product identifier (e.g. `prod_1`) |
| `name`       | String              | Product name                              |
| `description`| String              | Product description                       |
| `price`      | Decimal/Money       | Product price                             |
| `category`   | String              | Product category                          |
| `image_urls` | String (comma‑sep)  | URLs of product images                    |
| `created_at` | Timestamp           | Record creation timestamp                 |

---

## Core API Endpoints

| Method   | Endpoint                    | Description                                                |
|----------|-----------------------------|------------------------------------------------------------|
| `GET`    | `/api/products`             | Returns all products, optional `?category=` filter         |
| `POST`   | `/api/products`             | (Admin) Create a new product                               |
| `GET`    | `/api/products/{productId}` | Get details of a single product                            |
| `PUT`    | `/api/products/{productId}` | (Admin) Update product details                             |
| `GET`    | `/api/products/batch`       | Fetch multiple products by IDs (e.g. `?ids=prod_1,prod_2`) |
| `DELETE` | `/api/products/{productId}` | (Admin) Delete a product by id                             |
| `DELETE` | `/api/products/`            | (Admin) Delete all product by                              |

---

## Inter‑Service Communication
- **Called by:** Shopping Cart, Order, Review, Search services  
- **Calls:** None (standalone service)

---

## Tech Stack
- **Language:** Java  
- **Framework:** Spring Boot  
- **Database:** H2 (dev/test) or MySQL/PostgreSQL (prod)  
- **Build Tool:** Maven  
- **API Style:** RESTful

---

## Project Structure
<pre>
src/
 ├─ main/java/com/uc/productcatalog_service/
 │   ├─ controller/                            # REST controllers
 │   ├─ dto/                                   # Request/Response DTOs
 │   ├─ exception                              # Custom exceptions
 │   ├─ mapper/                                # Converters between entities and DTOs
 │   ├─ model/                                 # Entities
 │   ├─ repository/                            # JPA repositories
 │   ├─ service/                               # Business logic
 │   └─ ProductCatalogServiceApplication.java  # Spring Boot entry point
 └─ resources/
     ├─ application.properties                 # Configuration
     ├─ db/migration/
         └─ V1_init.sql                        # Flyway schema deliverable
     ├─ data.sql                               # Seed/test data
     └─ db_schema.sql                          # schema
</pre>
---

### Prerequisites
- Java 21+
- Maven
- Spring Boot

### Run Locally
```bash
# Clone repository
git clone https://github.com/your-org/product-catalog-service.git
cd product-catalog-service

# Build & run
# from the project root
./mvnw spring-boot:run
# on Windows
mvnw.cmd spring-boot:run

# Check application.properties for seed/schema