package com.example;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import java.util.Properties;


public class KafkaProducerApp {
    private static final String BOOTSTRAP_SERVERS = System.getenv("BOOTSTRAP_SERVERS");
    private static final String API_KEY = System.getenv("API_KEY");
    private static final String API_SECRET = System.getenv("API_SECRET");
    private static final String TOPIC = System.getenv("TOPIC");

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", BOOTSTRAP_SERVERS);
        props.put("key.serializer", StringSerializer.class.getName());
        props.put("value.serializer", StringSerializer.class.getName());
        props.put("acks", "all");
        props.put("security.protocol", "SASL_SSL");
        props.put("sasl.mechanism", "PLAIN");
        props.put("sasl.jaas.config", "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"" + API_KEY + "\" password=\"" + API_SECRET + "\";");
        props.put("metric.reporters","org.apache.kafka.common.metrics.JmxReporter");

        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        for (int i = 0; i < 1000; i++) {
            String key = "key" + i;
            String value = "value" + i;
            try {
                Thread.sleep(1000);
                producer.send(new ProducerRecord<>(TOPIC, key, value), (metadata, exception) -> {
                    if (exception != null) {
                        exception.printStackTrace();
                    } else {
                        System.out.println("Message sent to topic " + metadata.topic() + " with offset " + metadata.offset());
                    }
                });
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }

        producer.close();
    }
}
