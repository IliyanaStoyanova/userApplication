# CRUD User Management Application
Build REST CRUD API for a simple User Management application using Spring Boot, Maven, MySQL, IntelliJ IDE.

**You can see the full condition of the task in the <b><a href="https://github.com/users/IliyanaStoyanova/projects/7">Projects section</a></b>.**
**You can see the application documentation in the <b><a href="https://github.com/IliyanaStoyanova/userApplication/blob/master/API_DOC.md">API_DOC.md</a></b>**
## Using versions

1. Java 18
2. Maven 3.8.6
3. MySQL 8

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/IliyanaStoyanova/userApplication.git
```

**2. Create MySQL database**

```bash
create database dbuserapp
```

**3. Change MySQL username and password as per your installation**

  + open `src/main/resources/application.properties`
  
  + change `spring.datasource.username` and `spring.datasource.password` as per your MySQL installation
  
**4. Build and run the app using maven**

In terminal you write code:
```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8080>

## Explore Rest APIs
The app defines following CRUD APIs.

    GET /users
    
    GET /users/{id}
    
    GET /users/filter?item=<SEARCH_STRING>&field=<SORT_FIELD>&dir=<DIRECTION>
    
    POST /users
    
    PUT /users/{id}
    
    DELETE /users/{id}

For POST and PUT methods JSON Request Body is:
    
    {
      "firstName": "<FIRST_NAME>",
      "lastName": "<LAST_NAME>",
      "dateBirth": "<YYYY-MM-DD>",
      "phoneNumber": "<PHONE_NUMBER>",
      "emailAddress": "<EMAIL_ADDRESS>"
    }
These HTTP methods can be tested using Postman.
