Setting Up the Backend Code

--Prerequisites--
Java Development Kit (JDK)
MongoDB Atlas Account
Postman
IDE: Visual Studio Code (VSCode), Spring Tool Suite, Eclipse, or any other Java IDE.

--Steps to Run the Backend Code--
Download the ZIP file containing the backend code.
Extract the ZIP file and rename the extracted folder to Backend.

--Import the Project into Your IDE--
Open your preferred IDE (VSCode, Spring Tool Suite, or Eclipse).

--Configure MongoDB Atlas--
Ensure you have a MongoDB Atlas account and cluster set up.
Update the application.properties in the src/main/resources directory with your MongoDB connection details. or you can use my cluster by dont changing anything.

--Run the Backend Application--
Locate the BackendApplication.java file in the src/main/java/com/example/backend directory.
Right-click the file and select Run As > Java Application.
Alternatively, you can run it using the terminal with the following command : mvn spring-boot:run

--Testing the API with Postman--
Open Postman.
Use the following endpoint to perform CRUD operations : http://localhost:8080/api/employees

--Endpoints--
Create Employee : POST http://localhost:8080/api/employees
Read All Employees : GET http://localhost:8080/api/employees
Read Single Employee : GET http://localhost:8080/api/employees/{id}
Update Employee : PUT http://localhost:8080/api/employees/{id}
Delete Employee : DELETE http://localhost:8080/api/employees/{id}
