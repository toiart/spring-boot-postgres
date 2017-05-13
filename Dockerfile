FROM java:8

ADD ./build/libs/spring-boot-postgres-0.0.1-SNAPSHOT.jar app.jar

RUN bash -c 'touch /app.jar'

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=dev", "-Djava.security.egd=file:/dev/./urandom", "/app.jar"]