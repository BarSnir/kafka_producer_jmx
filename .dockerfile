FROM openjdk:17.0.1-jdk-slim

WORKDIR /app

# Expose JMX port

# Set JMX environment variables

COPY jmx_prometheus_javaagent-1.0.0.jar /app/jmx_prometheus_javaagent-1.0.0.jar
COPY kafka-producer-jmx.yml /app/kafka-producer-jmx.yml
COPY ./kafka_producer_jmx-1.0-SNAPSHOT.jar /app/kafka_producer_jmx-1.0-SNAPSHOT.jar

EXPOSE 9091


ENTRYPOINT ["java","-javaagent:/app/jmx_prometheus_javaagent-1.0.0.jar=9091:/app/kafka-producer-jmx.yml", "-jar", "kafka_producer_jmx-1.0-SNAPSHOT.jar"]
