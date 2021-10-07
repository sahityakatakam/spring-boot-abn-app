Spring Boot Application to maintain the favourite food recipes

## Swagger document is available for the Recipes REST API under Design section.
## Data is persisted in in-built database.

1. This application validates the user details before allowing them to access any of the Recipes REST API's.
2. Validated user will return a JWT token to perform any actions on the Recipes REST API's.
3. Without a valid token, Recipes REST API can't be accessable.


Below are the steps to be followed to access the application:

1. Run the application using mvn spring-boot:run command.
   
2. The below set of actions can be performed in Postman
    A. 
   
POST http://localhost:8080/api/auth/signup
   
{
"username":"sahitya",
"email":"sahitya.katakam@gmail.com",
"password":"123456"
}
   
    B. 

POST http://localhost:8080/api/auth/signin
{
"username":"sahitya",
"password":"123456"
}

    C.

POST http://localhost:8080/api/food/recipe

{
"typeOfDish":"veg",
"servedfor":10,
"ingredients":"milk,sugar",
"instructions":"boil the milk before adding sugar"
}

    D.

GET http://localhost:8080/api/food/recipes

    E.

PUT http://localhost:8080/api/food/recipe/{id}

{
"typeOfDish":"veg",
"servedfor":10,
"ingredients":"milk,sugar",
"instructions":"boil the milk before adding sugar"
}

    F.

DELETE http://localhost:8080/api/food/recipe/{id}