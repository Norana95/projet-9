FROM openjdk:17
EXPOSE 8082
ADD target/microservice-patient-docker.jar microservice-patient-docker.jar
ENTRYPOINT ["java", "-jar", "/microservice-patient-docker.jar"]