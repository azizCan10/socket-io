# Socket.IO Project

A Socket.IO project where users can select a room and chat with each other in that room.

## Technologies
* Java 17
* Spring Boot 3.0.5
  * Socket.IO
  * Lombok

## Getting Started
To get started with this project, you will need to have the following installed on your local machine:

* JDK 14+
* Maven 3+

To build and run the project, follow these steps:

* Clone the repository: `https://github.com/azizCan10/socket-io.git`
* Navigate to the project directory
* In application.properties file, set your own values

* Build the project: `mvn clean install`
* Run the project: `mvn spring-boot:run`

-> The application will be available at http://localhost:8080

## Socket.IO

* **Avaliable at:** ws://<YOUR_HOST>:<YOUR_PORT>
* **Params:** room
* **Example:** ws://localhost:8085?room=test