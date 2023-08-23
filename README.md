# question-service
Java Spring Boot application designed to handle questions and interact with a dedicated database named "question." This microservice is part of a quiz application microservices architecture and is responsible for managing questions within the system.

### Features
* Create new questions <br>
* Retrieve questions based on different criteria <br>
* Update existing questions <br>
* Delete questions <br>

### Technologies Used
* Java <br>
* Spring Boot <br>
* Spring Data JPA <br>
* RESTful APIs <br>
* Maven <br>
* MySQL

### Installation
1) Clone this repository: git clone [https://github.com/yourusername/question-service.git](https://github.com/Amila95/question-service)
2) Navigate to the project directory: cd question-service
3) Build the project: mvn clean install
4) Run the application: java -jar target/question-service.jar

### API Endpoints
Here are some of the main API endpoints provided by the Question Service Microservice:

> GET /questions:  Retrieve a list of all questions.<br>
> GET /questions/{id}:  Retrieve question details by ID. <br>
> POST /questions:  Create a new question.<br>
> PUT /questions/{id}:  Update an existing question.<br>
> DELETE /questions/{id}:  Delete a question by ID.<br>

   


