bazenJaggedEdgeTest
======================
Jagged Edge Corp Sr. Java Developer Test for Jason Bazen.  Spring Boot project shell generated by Spring Initializr.  This project is located on GitHub at https://github.com/jbazen/bazenJaggedEdgeTest.

## Description
A Java 8 Spring Boot application using Spring MVC, Spring REST, Spring Data JPA, Jackson, & Orika built with Maven. This application runs Tasks 1, 2, & 8 of the Jagged Edge Corp Developer Test.  **Attention - I wasn't sure what was meant by a no password MySQL connection, so I am using "root" for my username & password.  Also I am connected to a schema in MySQL called "jaggededge".**

## Building
All build artifacts including JAR file are already created in the target directory.  To build the project again, navigate to the bazenJaggedEdgeTest root directory in a command line shell & execute the following:

```
mvn package
```

## Usage Instructions
With the project built & the resulting JAR file located in the project's target directory, navigate to the bazenJaggedEdgeTest project root directory in a command line shell and execute the following to run the application:

```
java -jar target/bazenJaggedEdgeTest-0.0.1-SNAPSHOT.jar
```

When the application starts it will automatically run through tasks 1, 2, & 8.  The output from each task is output to the console with slf4j.  The user can then run through each task by performing an HTTP GET to the appropriate REST endpoint:

**Task 1: REST API**
HTTP GET to http://localhost:8080/task1
- The results of the task are returned from the endpoint as well as written to console with slf4j.

**Task 2: WebSocket API**
HTTP GET to http://localhost:8080/task2
- A "Success" message is returned from the endpoint and the results of the task are written to the console with slf4j.
- In order to stop the WebSocket streaming by unsubscribing from the socket, perform an HTTP GET to http://localhost:8080/stopStreamCurrentBidPrice

**Task 8: Stream Order Updates from WebSocket API**
HTTP GET to http://localhost:8080/task8
- The UUID of the Order is returned from the endpoint and the results of the task are written to the console with slf4j.
- Inserts & updates of the Order are written to the ORDER_ENTITY table in the jaggededge MySQL schema.  The application connects to MySQL with "root" as both the username & password.
