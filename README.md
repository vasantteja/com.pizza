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
   
## Websites used during this project

###Swagger
http://zarin.io/codelabs/springboot-api/#0

https://springframework.guru/spring-boot-restful-api-documentation-with-swagger-2/

https://www.dariawan.com/tutorials/spring/documenting-spring-boot-rest-api-swagger/

###Docker
https://reflectoring.io/spring-boot-docker/

https://www.javadevjournal.com/spring-boot/dockerizing-spring-boot-application/

###OAuth
https://www.devglan.com/spring-security/spring-boot-oauth2-jwt-example

https://www.toptal.com/spring/spring-boot-oauth2-jwt-rest-protection

###CircleCi
https://medium.com/faun/setup-a-circleci-pipeline-for-a-containerized-spring-boot-app-93045fa060de

###Postman
https://stackoverflow.com/questions/18738820/how-postman-rest-client-raw-json-data-is-sent-to-server-in-post-put-calls


   