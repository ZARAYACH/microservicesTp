FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/orders-*.jar orders.jar
ENTRYPOINT ["java", "-jar", "orders.jar"]