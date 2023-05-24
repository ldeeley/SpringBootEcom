# Spring Boot - Ecommerce Application

### Areas covered

For further reference, please consider the following sections:
#### Web
* _Spring Boot Starter Web_
* Lombok
* Web Layer - REST endpoints, HTTP methods
* Web Layer Testing - @WebMVCTest(AlbumController.class) / MockMVC
* _Spring Boot Starter Validation_
* Validation of **AlbumRequestDTO** at REST endpoints
* Custom Validation aswell as Spring out-of-the-box validations

#### Exception Handling
* Add an Exception Handler _@RestControllerAdvice_
* Bespoke ServiceResponse (instead of ResponseEntity) to improve Response to User

#### Data Layer

The following guides illustrate how to use some features concretely:

* Spring Boot Starter JPA (using H2 database initially)
* application.properties - enable H2 console
* Add DTO, DAO - Album CRUD Repository, Entity to isolate txfer data between layers

#### Testing
* Web Layer Testing - testing endpoints - CRUD operations
* Using @WebMvcTest and MockMVC
* Test raising and handling exceptions _@RestControllerAdvice_