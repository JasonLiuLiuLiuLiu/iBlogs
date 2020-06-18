FROM maven:3.6.3-jdk-8-slim AS build
RUN mkdir -p /workspace
WORKDIR /workspace
COPY pom.xml /workspace
COPY blog-common /workspace/blog-common
COPY blog-mbg /workspace/blog-mbg
COPY blog-portal /workspace/blog-portal
RUN mvn -B -f pom.xml clean package -DskipTests 
FROM openjdk:8-jdk-slim
COPY --from=build /workspace/blog-portal/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]