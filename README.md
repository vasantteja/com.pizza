# pizza-toppings-rest-api
This api intends to serve as a rest end point to retrieve, update, delete and add pizza toppings.
This project uses
1. Spring Boot 2.4.2
2. Java 11
3. MySql

## How to run this application

1. Login into docker using credentials using this command
`docker login --username myUsername --password myPassword`
2. Pull the latest image using the following command
   `docker run -it -p 8080:8080 -p 15370:15370 vasantteja/pizzatoppingapi:10 /bin/bash`
   
## Rest Endpoints

All the endpoints can be found by visiting `localhost:8080/api/swagger-ui.html` after starting the application.

## Testing the application using Postman tool

### Step 1: Retrieve the OAuth token using postman

1. Login into the Oauth website `http://localhost:8080/oauth/token`.

![alt text](https://github.com/vasantteja/com.pizza/blob/master/images/oauthurl.png)

2. In the Auth tab, select **Basic Auth** under **Type**.

3. In the Auth tab, enter the user `devglan-client` as Username and `devglan-secret` as Password.

![alt text](https://github.com/vasantteja/com.pizza/blob/master/images/Auth.png)

4. In the Body tab, choose x-www-form-urlencoded and enter the following details:

   username-Alex123
   
   password-password

   grant_type-password

![alt text](https://github.com/vasantteja/com.pizza/blob/master/images/Body.png)

5. Retrieve the access token by hitting the Send button adjacent to url. An example access token looks like below:

![alt text](https://github.com/vasantteja/com.pizza/blob/master/images/AccessToken.png)

### Step 2: Fetching All users

1. This endpoint has been designed to expose all users to the consumer.

2. We can access this endpoint by selecting GET and entering the url `http://localhost:8080/users/user/fetchallusers?access_token=accessToken`

![alt text](https://github.com/vasantteja/com.pizza/blob/master/images/fetchallusersendpointop.png)

### Step 3: Fetching All toppings

1. This endpoint has been designed to expose all toppings to the consumer. Currently, it's a static list, but it will be enhanced to read from a database.

2. We can access this endpoint by selecting GET and entering the url `http://localhost:8080/toppings/fetchalltoppings?access_token=accessToken`


   
   

## Websites used during this project

### Swagger
http://zarin.io/codelabs/springboot-api/#0

https://springframework.guru/spring-boot-restful-api-documentation-with-swagger-2/

https://www.dariawan.com/tutorials/spring/documenting-spring-boot-rest-api-swagger/

### Docker
https://reflectoring.io/spring-boot-docker/

https://www.javadevjournal.com/spring-boot/dockerizing-spring-boot-application/

### OAuth
https://www.devglan.com/spring-security/spring-boot-oauth2-jwt-example

https://www.toptal.com/spring/spring-boot-oauth2-jwt-rest-protection

### CircleCi
https://medium.com/faun/setup-a-circleci-pipeline-for-a-containerized-spring-boot-app-93045fa060de

### Postman
https://stackoverflow.com/questions/18738820/how-postman-rest-client-raw-json-data-is-sent-to-server-in-post-put-calls


   