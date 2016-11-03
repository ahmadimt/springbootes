# Spring Boot Elasticsearch Demo Application
![Build Status](https://travis-ci.org/ahmadimt/springbootes.svg?branch=master)

In this, we are going to see how to configure Elasticsearch with Spring Boot application. We will be using Spring Boot 1.3.2.Release. It comes with Elasticsearch 1.5.2. If you want to use another version, you can do it by defining following in your build.gradle. 

Caution: Be aware Spring Boot 1.3.2.Release is compatible with Elasticsearch 1.5.2. If you use another version, it may cause compatibility issues. [more details here](http://docs.spring.io/spring-boot/docs/current/reference/html/howto-build.html#howto-customize-dependency-versions).

```
  buildscript {
    ......
  	ext['elasticsearch.version'] = '1.7.4'
  	......
  }

```
Steps for running the application
======================================================

1. Start Elasticsearch.
2. Go to the root of the project and run:   ``` ./gradlew clean build ```
3. Once the build is successful,run ``` java -jar build/libs/springbootes-0.0.1-SNAPSHOT.jar ```
4. Open ```http://localhost:8080``` in browser
    
