FROM openjdk:11
ADD target/MyTestAutomation-1.0.2.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]