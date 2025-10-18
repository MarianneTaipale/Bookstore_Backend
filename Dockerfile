# Maven
FROM maven:3.8.6-eclipse-temurin-17-focal AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# JDK
FROM eclipse-temurin:17-jre-focal
WORKDIR /app
# JAR buildistä
COPY --from=build /app/target/StudentListSecureDB-0.0.1-SNAPSHOT.jar ./studentlistsecuredb.jar

ENV PORT 10000
EXPOSE 10000

ENTRYPOINT ["java", "-jar", "studentlistsecuredb.jar"]
