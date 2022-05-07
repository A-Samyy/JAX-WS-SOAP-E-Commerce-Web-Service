# JAX-WS-SOAP-E-Commerce-Web-Service
An E-Commerce SOAP web service built using JAX-WS.


## 📃 Documentation
📧[Postman SOAP API Docs](https://documenter.getpostman.com/view/20483744/UyxdL9EF)

🧼 SOAPUI Reports

## Features
* SOAP 1.1

## Technologies used
* JAX-WS (Metro)
* JSON-B
* JAX-B
* Maven
* Tomcat
* Intellij IDEA Ultimate
* SOAP-UI
 

## Run with Maven
**Maven**

* Change the configuration of Tomcat in `pom.xml`.
* Deploy the application using the following maven command:
```
mvn clean compile tomcat7:redeploy
```
* SOAP: import the project into SOAP UI

## 🏛 Database Schema
![DataBase Schema](https://user-images.githubusercontent.com/95469600/167268988-1da0ebe0-127b-470e-ab33-62650e9d85bf.jpg)

**🐬MySQL**
* Create a database schema and provide the username and password in the persistence.xml
* Hibernate will automatically create the tables for you
* Run DatabasePopulator.java to populate the database with some test data

# 👷️ Contributors
* [Abdelrahman Samy](https://github.com/A-Samyy)
