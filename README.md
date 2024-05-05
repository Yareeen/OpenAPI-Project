
### OpenAPI Project

#### Description
The OpenAPI Project is a simple, powerful REST API for managing books and shelves, tailored for basic library management needs. It facilitates CRUD operations on books and shelves, leveraging a straightforward one-to-many relationship where each book is associated with a specific shelf.

#### Features
- **Manage Books:** Create, retrieve, update, and delete books in the system.
- **Manage Shelves:** Operate on shelves which can house multiple books.
- **API Documentation:** Fully documented API endpoints for easy integration.

#### Technology Stack
- **Spring Boot:** Simplifies the development of new Spring applications.
- **H2 Database:** In-memory database for rapid development and testing.
- **OpenAPI 3.0.3:** Ensures compliance with the OpenAPI specifications for REST APIs.

#### Getting Started
1. **Clone the repository**
   ```bash
   git clone https://github.com/Yareeen/OpenAPI-Project.git
   ```
2. **Navigate into the project directory**
   ```bash
   cd OpenAPI-Project
   ```
3. **Pull the Docker image**
   ```
 docker pull yarenn/openapiproject:latest
   ```

4. **Build the project**
   ```
   ./mvnw package
   ```

5. **Run the application**
   ```
   ./mvnw spring-boot:run
   ```
   Access the API at: `http://localhost:8080/api`.

#### API Endpoints
- **Books**
  - `GET /api/books/`: List all books.
  - `POST /api/books/`: Create a new book.
  - `GET /api/books/{id}`: Retrieve a book by its ID.
  - `PUT /api/books/{id}`: Update a book by its ID.
  - `DELETE /api/books/{id}`: Delete a book by its ID.
- **Shelves**
  - `GET /api/shelves/`: List all shelves.
  - `POST /api/shelves/`: Create a new shelf.
  - `GET /api/shelves/{id}`: Get a shelf by its ID.
  - `PUT /api/shelves/{id}`: Update a shelf by its ID.
  - `DELETE /api/shelves/{id}`: Delete a shelf by its ID.

#### Contact
- **Developer:** Yaren CAN
- [LinkedIn Profile](https://www.linkedin.com/in/yarencan/)
- [Send Email](mailto:yarencan.cse@gmail.com)

#### License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
