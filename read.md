Project Description:

The project is a simple online bookstore API built using Spring Boot, Spring Data JPA, Hibernate, and MySQL. It allows users to perform CRUD operations on books, authors, and genres. Each book has a title, author, genre, price, and quantity available. Users can search for books by title, author, or genre.
How to Run the Project:
1. Clone the Repository:

Clone the project repository to your local machine using Git:

bash

git clone <repository-url>
cd bookstore-api

2. Set Up MySQL Database:

Ensure you have MySQL installed on your machine. Create a MySQL database named bookstore.
3. Configure Database Connection:

Modify the application.properties file in the src/main/resources directory to configure the database connection properties:

properties

spring.datasource.url=jdbc:mysql://localhost:3306/bookstore
spring.datasource.username=root
spring.datasource.password=password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update

Adjust the URL, username, and password according to your MySQL configuration.
4. Build and Run the Application:

You can build and run the application using Gradle or Maven.
Using Gradle:

Navigate to the project directory and run the following command:

bash

./gradlew bootRun

Using Maven:

Navigate to the project directory and run the following command:

bash

mvn spring-boot:run

5. Access the API Endpoints:

Once the application is running, you can access the API endpoints using a tool like Postman or cURL. Here are some example endpoints:

    GET http://localhost:8080/api/books
        Retrieves all books.
    GET http://localhost:8080/api/books/{id}
        Retrieves a specific book by ID.
    POST http://localhost:8080/api/books
        Creates a new book.
    PUT http://localhost:8080/api/books/{id}
        Updates an existing book.
    DELETE http://localhost:8080/api/books/{id}
        Deletes a book by ID.

Similarly, you can access endpoints for authors and genres. Make sure to adjust the base URL and endpoint paths accordingly for authors and genres.

That's it! You now have the bookstore API up and running on your local machine. You can explore the various endpoints and functionalities provided by the API.

(Written by ChatGTP)

- Was it easy to complete the task using AI?
Yes it was easy for the most part did most of the boilerplate code.
- How long did task take you to complete? (Please be honest, we need it to gather anonymized statistics)
2 Hours.
- Was the code ready to run after generation? What did you have to change to make it usable?
Mostly it did what I asked it to and if I had to change some things they were minor. 
- Which challenges did you face during completion of the task?
Sometimes it referred to an older version of the code instead of the newer one.

