# Compile and run
- gradle build
- gradle run

# Database
- *[localhost](http://localhost:8080/h2-console)*
- Driver class: org.h2.Driver
- JDBC URL: jdbc:h2:mem:testdb
- User Name: sa
- Password: password

# Docker
- Use "gradle dockerBuild" to build the image
- Use "gradle dockerRun" to run the image

**The create image is feladat:latest, and created container is feladat.**

# Endpoints

- ## /szavazasok/szavazas (POST)
  - Handles the saving of the given szavazas
- ## /szavazasok/szavazat?szavazas=<szavazas>&kepviselo=<kepviselo> (GET)
  - Returns the Szavazat of the given Kepviselo on the given Szavazas
- ## /szavazasok/eredmeny?szavazas=<szavazas> (GET)
  - Returns the result of the Szavazas
- ## /szavazasok/napi-szavazasok?nap=<yyyy-MM-dd> (GET)
  - Returns all the information about the szavazas
- ## /szavazasok/kepviselo-reszvetel-atlag?start=<yyyy-MM-ddThh:mm:ss>&end=<yyyy-MM-ddThh:mm:ss> (GET)
  - Returns the average participation of a Kepviselo in Szavazas
  - I inerpreted the task as the number of Kepviselo should be the constant 200


### If you don't have gradle installed a gradle wrapper was included with this project. You can use it with the following command  "./gradlew"

