package com.kafkaexample;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
		return args -> {
			for (int i = 0; i < 100; i++) {
				kafkaTemplate.send("KafkaExampleTopic", "Women Who Code " + i);
			}

		};
	}
}

//Start Kafka Local server :
// Terminal 1 - Zookeeper cmd : bin/zookeeper-server-start.sh config/zookeeper.properties
// Terminal 2 - Start Kafka service cmd : bin/kafka-server-start.sh config/server.properties
// Terminal 3 - Consumer Who listens to the topic cmd : bin/kafka-console-consumer.sh --topic KafkaExampleTopic --from-beginning --bootstrap-server localhost:9092
