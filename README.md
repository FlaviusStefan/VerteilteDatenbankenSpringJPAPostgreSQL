# VerteilteDatenbankenSpringJPAPostgreSQL

## Introduction

This is a simple web application written in Java using the Spring Boot framework. The project focuses on user registration and login functionalities through a straightforward form.

## Table of Contents

1. [Prerequisites](#prerequisites)
2. [Installation](#installation)
3. [Usage](#usage)
4. [Technologies Used](#technologies-used)
5. [Project Structure](#project-structure)
6. [Configuration](#configuration)

## Prerequisites

Before you begin, ensure you have the following tools installed:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [PostgreSQL](https://www.postgresql.org/download/)

## Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/your-username/your-repository.git

2. **Navigate to the project directory:**
   ```bash
   cd your-repository

3. **Build and run the application:**
   ```bash
   ./mvnw spring-boot:run

# Usage

Explore the functionality of the application by following these detailed steps:

1. **Access the application at http://localhost:8080.**

This is the entry point of the application. Open your web browser and navigate to the provided URL to start exploring.

2. **Utilize the registration form to create a new account.**

Click on the registration link and fill out the necessary information to create a new account. This step ensures you have access to the full features of the application.

3. **Log in with your credentials.**

Once registered, log in using the credentials you just created. This step is essential for personalized user interactions and data management.

4. **Discover and navigate through the various features of the application.**

From the dashboard to specific modules, explore the functionalities that the application offers. This may include viewing, creating, or updating data based on the project's scope.

## Technologies Used

The project incorporates the following technologies, each playing a crucial role in its functionality:

- **Java:** The core programming language that powers the application. Learn more about Java [here](https://www.java.com/).

  **Installation Guide:**
  
  - Visit the [Java Downloads](https://www.oracle.com/java/technologies/javase-downloads.html) page.
  - Download and install the appropriate version of the Java Development Kit (JDK) for your operating system.
  - Follow the installation instructions provided on the Java website.

- **Spring Boot:** A powerful framework for building Java-based enterprise applications. Explore Spring Boot [here](https://spring.io/projects/spring-boot).

  **Installation Guide:**
  
  - Visit the [Spring Boot](https://spring.io/projects/spring-boot) project page.
  - Follow the "Installation" or "Getting Started" section for the latest instructions on installing Spring Boot.
  - Typically, you can include Spring Boot in your project using your preferred build tool such as Maven or Gradle.

- **JPA (Java Persistence API):** Provides a Java specification for managing relational data in applications. Dive into JPA [here](https://docs.oracle.com/javaee/7/tutorial/persistence-intro.htm).

  **Installation Guide:**
  
  - JPA is part of the Java EE (Enterprise Edition) specification and is included in many Java EE application servers.
  - If you're using a specific JPA implementation, such as Hibernate, visit the respective project's website for installation instructions.

- **PostgreSQL:** The chosen relational database management system. Understand PostgreSQL [here](https://www.postgresql.org/).

  **Installation Guide:**
  
  - Visit the [PostgreSQL Downloads](https://www.postgresql.org/download/) page.
  - Select the appropriate installer for your operating system.
  - Follow the installation instructions provided on the PostgreSQL website.



# Project Structure

The project is organized with the following structure:

- **/.mvn/wrapper:** Contains Maven Wrapper files for project-specific Maven version control.
  - `maven-wrapper.jar`
  - `maven-wrapper.properties`

- **/src:** Contains the source code for the project.
  - **/main:** Main source folder.
    - **/controller:** Controller package containing:
      - `UsersController` class: Manages user-related HTTP requests.
    - **/model:** Model package containing:
      - `UsersModel` class: Represents the user entity in the application.
    - **/repository:** Repository package containing:
      - `UsersRepository` class: Manages the database interactions for user entities.
    - **/service:** Service package containing:
      - `UsersService` class: Provides business logic related to user entities.
    - `SimpleFormApplication.java`: The main application class, serving as the entry point.

- **/pom.xml:** Maven Project Object Model (POM) file. It defines the project's configuration, dependencies, and build settings.

- **/mvnw:** Maven Wrapper script for Unix-based systems. It allows you to run the Maven build without requiring a globally installed Maven version.

- **/mvnw.cmd:** Maven Wrapper script for Windows systems. It provides the same functionality as `mvnw` but is tailored for Windows environments.

# Classes

## UsersController

The `UsersController` is a Spring Framework controller class responsible for handling user-related web requests. It is annotated with `@Controller` to indicate that it is a Spring MVC controller.

### 1. `/register`

- **Method:** `GET`
- **Description:** This endpoint is mapped to the `/register` URL and handles HTTP GET requests. It returns the view named "register_page," rendering the registration page for users.


@GetMapping("/register")
public String getRegisterPage(){
    return "register_page";
}

### 2. `/login`

- **Method:** `GET`
- **Description:** This endpoint is mapped to the /login URL and handles HTTP GET requests. It returns the view named "login_page," rendering the login page for users.

@GetMapping("/login")
public String getLoginPage(){
    return "login_page";
}

## UsersModel

The `UsersModel` class represents the entity for users in the application. It is annotated with `@Entity` to indicate that it is a JPA entity, and its data is stored in a database table specified by the `@Table` annotation.

### 1. **`id`**

   - Type: `Integer`
   - Description: Auto-generated identifier for each user, annotated with `@Id` and `@GeneratedValue` for automatic generation based on the strategy specified by `GenerationType.IDENTITY`.

### 2. **`login`**

   - Type: `String`
   - Description: Represents the user's login name.

### 3. **`password`**

   - Type: `String`
   - Description: Represents the user's password.

### 4. **`email`**

   - Type: `String`
   - Description: Represents the user's email address.

#### Constructors

- The class has a default constructor and getters/setters for all fields.

#### Methods

1. **`equals(Object o)`**

   - Description: Overrides the `equals` method to compare `UsersModel` instances based on their `id`, `login`, `password`, and `email` attributes.

2. **`hashCode()`**

   - Description: Overrides the `hashCode` method to generate a hash code based on the `id`, `login`, `password`, and `email` attributes.

3. **`toString()`**

   - Description: Overrides the `toString` method to provide a meaningful string representation of a `UsersModel` instance, including the `id`, `login`, and `email` attributes.

#### Table Mapping

- The entity is mapped to a database table named "users_table" through the `@Table` annotation.


## UserRepository Interface

The `UserRepository` interface is part of the Spring Data JPA framework and is designed to handle database operations for the `UsersModel` entity. It extends the `JpaRepository` interface, providing convenient methods for common CRUD operations and additional querying.

### Methods

#### 1. `findByLogin(String login)`

- **Description:** Queries the database to find a user by their login name.
- **Parameters:**
  - `login` (Type: `String`) - The login name of the user to search for.
- **Return Type:** `Optional<UsersModel>` - An optional `UsersModel` instance corresponding to the found user.

#### 2. `findByEmail(String email)`

- **Description:** Queries the database to find a user by their email address.
- **Parameters:**
  - `email` (Type: `String`) - The email address of the user to search for.
- **Return Type:** `Optional<UsersModel>` - An optional `UsersModel` instance corresponding to the found user.

#### Inheritance

- Extends the `JpaRepository` interface, inheriting its methods for common CRUD operations.

## UsersService

The `UsersService` class serves as the service layer responsible for handling business logic related to user operations. It interacts with the `UsersRepository` to perform database operations.

### Constructor

- **`UsersService(@Autowired UsersRepository usersRepository)`**
  - **Description:** Constructor for the service class, injecting the `UsersRepository` dependency.
  - **Parameters:**
    - `usersRepository` (Type: `UsersRepository`) - The repository responsible for database interactions.

### Methods

#### 1. `registerUser(String login, String password, String email)`

- **Description:** Registers a new user by creating a `UsersModel` instance, setting the provided login, password, and email, and saving it using the injected `UsersRepository`.
- **Parameters:**
  - `login` (Type: `String`) - The login name of the user.
  - `password` (Type: `String`) - The password of the user.
  - `email` (Type: `String`) - The email address of the user.
- **Return Type:** `UsersModel` - The registered user's model, or `null` if login or password is `null`.

#### 2. `authenticate(String login, String password)`

- **Description:** Authenticates a user by querying the database for a matching login and password combination using the `UsersRepository`.
- **Parameters:**
  - `login` (Type: `String`) - The login name of the user.
  - `password` (Type: `String`) - The password of the user.
- **Return Type:** `UsersModel` - The authenticated user's model, or `null` if no match is found.


# Configuration

1. **Database Configuration:**

   - Open `/src/main/resources/application.properties`.
   - Configure the PostgreSQL database connection properties.

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/your-database
   spring.datasource.username=your-username
   spring.datasource.password=your-password

2. **Thymeleaf Configuration**

    - Open `/src/main/resources/application.properties`.
    - Configure the Thymeleaf database connection properties.
    ```properties
    # Thymeleaf Configuration
    spring.thymeleaf.prefix=classpath:/templates/
    spring.thymeleaf.suffix=.html
    spring.thymeleaf.mode=HTML

3. **JPA Configuration**
    
  ```properties
  spring.datasource.url=jdbc:postgresql://localhost:5432/your-database
  spring.datasource.username=your-username
  spring.datasource.password=your-password
  spring.jpa.show-sql=true
  spring.jpa.hibernate.ddl-auto=update
  spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
