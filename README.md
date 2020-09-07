# Approach Information

### General
For the simplicity of quick development, followed the below points

* Added both microservices (Order & Order Item service) in the single source
* OrderItemService communicates with Order service using Feign Client - localhost (OrderItemController.java) 
* Exception Handling classes are present in "common" package
* Validations are enabled purely based on the basic & quick assumptions
* Only create & fetch APIs are considered for this task
* Used maven for this project

### Testing the application

### Scripts
##### To build the workspace use
### `mvn clean install` or `mvn clean package`

##### Then navigate to target folder and--
### `java -jar order-mgmt-system-1.0.jar`

The services can be tested in the port 8080
