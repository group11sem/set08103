FROM openjdk:latest
COPY ./target/Group_11_Project-0.1.0.1-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "Group_11_Project-0.1.0.1-jar-with-dependencies.jar"]