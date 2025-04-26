FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/products-*.jar products.jar
ENTRYPOINT ["java", "-jar", "products.jar"]