# PRICING API

<!-- TOC -->
* [PRICING API](#pricing-api)
  * [Introduction](#introduction)
    * [How to install project](#how-to-install-project)
    * [Spring Profiles](#spring-profiles)
    * [Swagger and Open Api doc](#swagger-and-open-api-doc)
    * [Postman collection](#postman-collection)
    * [Logs](#logs)
    * [CI/CD](#cicd)
<!-- TOC -->

## Introduction
README for Pricing API. This file will help how to install the API and all dependencies, and all features added.

### How to install project
Project created and build with Maven. There is a maven wrapped client in the root folder of the project.

``` shell
mvn clean install
```

### Spring Profiles
This project allows more than one profile, so in case that is required to use in more than one environment it's already added.
Now there is only two profiles: dev and local, in order to use them for different environments. And there is a third one (springdoc)
created to add custom swagger config.

In order to add more profiles, it should be added in `application.yml` in section:

```
  profiles:
    group:
      local: local, springdoc
      dev: dev, springdoc
```

And then later in the new profile active that profile with the property.

```
spring:
  config:
    activate:
      on-profile: dev
```

Finally, to change the profile when deploy the api in different environments it's required to specify the profile with the
next command:

```
-Dspring.profiles.active=local
```

### Swagger and Open Api doc

API Documentation is created with Swagger and Open Api new standard, and all info are accessible in next endpoint:

To access using *local* profile: 
http://localhost:8081/pricing-api/swagger-ui/index.html

### Postman collection

Added Postman collection in order to test the endpoint and add all cases.

[pricing-api.postman_collection.json](src/main/resources/pricing-api.postman_collection.json)

### Logs

Added different logs configuration in order to allow more than one configuration for different environments, because log level 
will be different between a production environment than dev environment. However in case that is needed to change for a specific deploy
if can be defined an environment variable `LOG_LEVEL=ERROR` to change log level.

### CI/CD
To be defined...
