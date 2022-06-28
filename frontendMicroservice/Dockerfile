FROM openjdk:17
EXPOSE 8083
ADD target/microservice-frontend-docker.jar microservice-frontend-docker.jar
ENTRYPOINT ["java", "-jar", "/microservice-frontend-docker.jar"]