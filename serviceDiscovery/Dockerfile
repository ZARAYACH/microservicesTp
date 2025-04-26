FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/serviceDiscovery-*.jar serviceDiscovery.jar
ENTRYPOINT ["java", "-jar", "serviceDiscovery.jar"]