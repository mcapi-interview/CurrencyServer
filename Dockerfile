FROM maven:3-jdk-8-onbuild as builder

FROM openjdk:8-jdk-alpine
COPY --from=builder /usr/src/app/target/AppServer-*.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
