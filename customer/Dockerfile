FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/customer-*.jar customer.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "customer.jar"]