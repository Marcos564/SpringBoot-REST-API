# SpringBoot-REST-API
Simple REST API using Springboot, Spring JPA, PostgreSQL and Hibernate

## Setup:
1. Clone the repository <br>
   `git clone https://github.com/Marcos564/SpringBoot-REST-API`

2. Create Postgres database
   `CREATE database vehicle_api`

3. Change postgres username and password:
   - open the file "application.properties" in `src/main/resources` <br>
   - edit `spring.datasource.username` and `spring.datasource.password` with your credentials

4. Run the application.
   The application will start running at http://localhost:8080 

## EndPoints

| Method    | URL     |  Response|
| -------- | -------- |-------|
| GET      | /api/all | A list of all the vehicles on the database |
| POST     | /api/all   | Add some new vehicle to the database |
| PUT    | /api/all/update/{id}?{atribute}={value} | Modified a specific atribute of a vehicle |
| DELETE | /api/all/{id}       | Delete a specific vehicle from the database    |
