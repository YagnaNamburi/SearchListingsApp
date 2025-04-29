FROM openjdk:17
EXPOSE 8080
ADD target/SearchListingsApp-1.0-SNAPSHOT.jar SearchListingsApp.jar
ENTRYPOINT ["java","-jar","/SearchListingsApp.jar"]