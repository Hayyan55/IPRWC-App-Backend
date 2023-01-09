FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ./out/artifacts/IPRWC_App_jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
