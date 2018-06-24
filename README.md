# Spring Cloud Config Basics

### Overview

This sample shows off how one can use Spring Cloud Config Server can externalize configuration of each application. It also showcases ways that one can create configurations that target different environments and overriding configuration values based on application profiles. 

### Run the Demo

. Fork https://github.com/practical-microservices/spring-cloud-config-basics-repo.git into your own Git repo on GitHub
. Import the root of the repo into your favorite Java IDE
. Edit to `config-server\src\main\resources\application.yml` to point to your fork from step 1
. Run config-server application
. Run `billboard` application
. Run `greeter` application
. 

### Things to try out 
. Access each application and check how the message is mapping to configuration value associated with every app. Examine the config repo to see how the mapping works. Notice that the name of the yml file matches the application name configured under `spring.application.name`
. Change the Spring profile of billboard application to `dev` and see how the message is affected - the new values is coming out of configuration file `billboard-dev.yml`
. Access the `/health` endpoint of each app. Notice how the configuration defined in `application.yml` applies to both applications.

 
### Resources to Learn More:
- https://cloud.spring.io/spring-cloud-config/