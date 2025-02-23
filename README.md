# kafka_producer_jmx
Simple project for demonstrating JMX agent installation in a Kafka client.

## Prerequire
1. Fill up .env file instructed like .env.example
2. mvn clean package
3. put the JAR in the root folder

## Run
1. ```Docker compose up --build```

## Stay tuned
1. Confluent JMX exporter metrics rules for Kafka clients:
https://github.com/confluentinc/jmx-monitoring-stacks/blob/main/shared-assets/jmx-exporter/kafka_client.yml