
# User Login Registration System(Spring Boot-MongoDB)

This project implements a user login and registration system using Spring Security and MongoDB.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Setup](#setup)
- [Usage](#usage)
- [Endpoints](#endpoints)


## Introduction

This project serves as a backend for a user login and registration system. It utilizes Spring Security for authentication, MongoDB as the database, and provides RESTful endpoints for user management.

## Features

- User registration
- User login
- CRUD operations for user management
- Spring Security for authentication and authorization
- MongoDB for data storage

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java 8 or higher installed
- MongoDB installed and running
- Maven installed (for building the project)
- Your MongoDB connection details in `application.yml`

## Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/YeganaKhalilova/User-registration-login-SpringBoot.git
Navigate to the project directory:

bash

cd user-login-registration
Build the project:

bash

mvn clean install
Run the application:

bash

mvn spring-boot:run

Usage

After the application is running, you can access the endpoints for user management. Additionally, there is an unsecured welcome endpoint.

Endpoints
Welcome Endpoint:

/users/welcome: Unsecured endpoint
User Management Endpoints:

GET /users/all: Get all users
GET /users/{email}: Get user by email
POST /users/addUser: Create a new user
PUT /users/updateUser: Update an existing user
DELETE /users/{userId}: Delete user by userId



