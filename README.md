🎓 Event Registration System

A web-based Event Registration System built using Java, Spring Boot, Spring Data JPA, and MySQL. The application allows students to register for an event and provides REST APIs to retrieve registration details.

📌 Project Overview

The Event Registration System simplifies the process of collecting and managing student registrations for college events.

The backend exposes REST APIs to register participants, retrieve all registrations, and fetch individual registration details. A simple frontend provides a user-friendly interface for submitting and viewing registrations.

✨ Features

* 📝 Student event registration form
* 👤 Collects student name, email, college, and department
* 📋 View all registered participants
* 🔍 Retrieve registration details by ID
* 📧 Email-based duplicate registration validation
* 👥 Maximum registration capacity of 50 participants
* 🕒 Records the registration timestamp
* 🗄️ MySQL database integration
* 🌐 RESTful API endpoints
* 💻 Simple frontend built with HTML, CSS, and JavaScript

🛠️ Technologies Used

Technology	Purpose
Java	Backend programming
Spring Boot	Backend application framework
Spring Web	REST API development
Spring Data JPA	Database operations
Hibernate	ORM and entity management
MySQL	Relational database
Maven	Dependency management and build
HTML	Frontend structure
CSS	Frontend styling
JavaScript	Frontend functionality
Git & GitHub	Version control and source code hosting

📂 Project Structure

event_management/
├── frontend/
│   ├── index.html
│   ├── style.css
│   └── script.js
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── registration/
│       │           └── event_management/
│       │               ├── EventManagementApplication.java
│       │               ├── controller/
│       │               ├── entity/
│       │               ├── repository/
│       │               └── service/
│       └── resources/
│           └── application.properties
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md

Note: The Java package folders shown above are illustrative. Your actual folder names may differ depending on your implementation.

⚙️ Prerequisites

Before running the project, install:

* Java JDK compatible with the project’s Spring Boot version
* MySQL Server
* IntelliJ IDEA or another Java IDE
* Maven, if you are not using the included Maven Wrapper
* A web browser

🚀 Getting Started

1. Clone the repository

git clone https://github.com/Nithish-1218/event-registration-backend.git

2. Open the project

Open the cloned event-registration-backend folder in IntelliJ IDEA.

Allow Maven to download the required dependencies.

3. Create the MySQL database

Open MySQL and execute:

CREATE DATABASE event_management;

4. Configure the database connection

Open src/main/resources/application.properties and configure your database connection.

Example:

spring.datasource.url=${DB_URL:jdbc:mysql://localhost:3306/event_management}
spring.datasource.username=${DB_USERNAME:root}
spring.datasource.password=${DB_PASSWORD}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

Set the following environment variables in your IDE’s run configuration:

* DB_USERNAME: Your MySQL username
* DB_PASSWORD: Your actual MySQL password
* DB_URL: Optional; defaults to the local event_management database URL

Security: Never commit your actual database password or other credentials to GitHub.

5. Run the application

Run the main Spring Boot class:

EventManagementApplication.java

Once the application starts successfully, the backend will be available at:

http://localhost:8080

6. Open the frontend

Open frontend/index.html in your web browser while the Spring Boot backend is running.

The frontend communicates with the backend API to submit registrations and retrieve participant details.

🔗 API Endpoints

The backend provides the following REST API endpoints.

Method	Endpoint	Description
POST	/register	Register a participant
GET	/registrations	Retrieve all registrations
GET	/registrations/{id}	Retrieve a registration by ID

1. Register a participant

Endpoint:

POST /register

Sample JSON request:

{
  "name": "Rahul Kumar",
  "email": "rahul@example.com",
  "college": "ABC Engineering College",
  "department": "Information Technology"
}

Send the request with Content-Type: application/json.

2. Retrieve all registrations

Endpoint:

GET /registrations

Returns the registered participants.

3. Retrieve a registration by ID

Endpoint:

GET /registrations/1

Returns the registration associated with the specified ID.

Note: The exact HTTP status codes and error response formats depend on the controller and exception-handling implementation.

🗄️ Database

The application uses MySQL to store registration details.

The registration entity includes:

* Registration ID
* Student name
* Email address
* College
* Department
* Registration timestamp

The application uses Spring Data JPA to interact with the database.

🎯 Learning Outcomes

Through this project, I gained practical experience with:

* Developing REST APIs using Spring Boot
* Connecting a Java application to MySQL
* Using Spring Data JPA for database operations
* Implementing service and repository layers
* Validating duplicate email registrations
* Building a simple frontend that communicates with a backend
* Managing source code using Git and GitHub

🔮 Future Improvements

* Add student authentication and administrator login
* Add event creation and management
* Implement registration cancellation
* Improve validation and error handling
* Add automated unit and integration tests
* Deploy the application to a cloud platform
* Introduce role-based access control

👨‍💻 Author

Nithish P

B.Tech Information Technology Student
Chennai Institute of Technology

GitHub: Nithish-1218

📄 License

This project is available for learning and educational purposes. A formal open-source license has not yet been specified.
