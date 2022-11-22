String Generator Application
===

This is a project for an app that generates a file of unique 
Strings with data provided by user.



## Built with
* [Spring-boot](https://spring.io/projects/spring-boot/) The web framework
* [Maven](https://maven.apache.org/) - Dependency Management

## URL requests example:
* POST for creating new file with unique Strings and adding them to database : 
 localhost:8080/new?=13&charsToUse=abcdefg&stringsToGenerate=1000&numberOfTasks=1
* GET for getting all created unique streams : 
  localhost:8080/all

