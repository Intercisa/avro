FROM openjdk:17
ENV BOOTSTRAP_SERVERS kafka1:19092
ADD build/libs/avro-service-0.0.1-SNAPSHOT.jar avro-service.jar
ENTRYPOINT ["java", "-jar", "avro-service.jar"]