FROM maven:3.9.5-eclipse-temurin-21 as maven_builder
WORKDIR /app
ADD . /app
RUN ["mvn","clean","install","-DskipTests=true"]

FROM tomcat:9.0.78-jdk21-openjdk
COPY --from=maven_builder /app/target/clone-me.war /usr/local/tomcat/webapps
