# User-Role-Rest-service

## Overview
Backend part for simple Restful Web application. Custom validation is performed for create and update requests.

## Main Technologies
 - Java
 - Spring Boot
 - Hibernate

## Usage
Use the following urls to see the interactions with the database
* List all:

        GET => http://localhost:8080/user/

* Get one:

        GET => http://localhost:8080/user/{id}

* Delete:

        DELETE => http://localhost:8080/user/{id}

* Create:

        POST => http://localhost:8080/user
        {"name":"James","login":"agent007","password":"Ves737","roles":[1,3]}

* Edit:

        PUT => http://localhost:8080/user/{id}
	    {"name":"John","login":"agent007","password":"Ves737","roles":[1,3]}
