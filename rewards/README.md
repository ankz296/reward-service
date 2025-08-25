## Call Stack

This project follows below Spring Boot structure:

1. Controller Layer (REST APIs) - Handles HTTP requests and responses
2. Service Layer - Service layer had business logic and reward calculation rules
3. Client Layer - Client Communicates with external services Hotel/Restaurant/Casino systems
4. Repository Layer - Repository layer for database uses if needed
5. DTO/Model Layer - Data transfer between UI to BE and BE to UI

Flow: Controller → Service → Client/Repository → External System → Response


Swagger URL : http://localhost:8080/rewards/swagger-ui/index.html
![img.png](img.png)

Get Rewards API:
It calculate rewards dynamically based on current data (Mock Data) :
Empty Activity Type:200 (OK) 
![img_1.png](img_1.png)

Single Activity Type : 200 (OK)  (HOTEL,RESTAURANT,CASINO) 
![img_5.png](img_5.png)

Empty Customer Id: 404 - Not Found:
![img_6.png](img_6.png)

Invalid Activity Type: 400 Bad Request (HOTEL,RESTAURANT,CASINO)
![img_4.png](img_4.png)
