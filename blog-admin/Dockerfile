FROM maven:3.6.3-jdk-8-slim AS build
RUN mkdir -p /workspace
WORKDIR /workspace
COPY pom.xml /workspace
COPY blog-admin /workspace/blog-admin
COPY blog-common /workspace/blog-common
COPY blog-mbg /workspace/blog-mbg
COPY blog-portal /workspace/blog-portal
COPY blog-search /workspace/blog-search
RUN mkdir -p /root/.m2 \
    && mkdir /root/.m2/repository
COPY settings.xml /root/.m2
RUN mvn -B -f pom.xml clean package -DskipTests 
FROM openjdk:8-jdk-slim
COPY --from=build /workspace/blog-admin/target/*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","app.jar"]