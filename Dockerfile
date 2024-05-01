FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean install -DskipTests

FROM openjdk:17-jdk-alpine
COPY --from=build /target/jira-1.0.jar jira.jar
COPY ./localhost.env localhost.env
COPY ./resources /resources
EXPOSE 8080
ENTRYPOINT ["java","-jar","jira.jar"]