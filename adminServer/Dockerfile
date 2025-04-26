FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/adminServer-*.jar adminserver.jar
ENTRYPOINT ["java", "-jar", "adminserver.jar"]