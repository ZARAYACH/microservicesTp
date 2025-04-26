FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/confServer-*.jar confserver.jar
ENTRYPOINT ["java", "-jar", "confserver.jar"]