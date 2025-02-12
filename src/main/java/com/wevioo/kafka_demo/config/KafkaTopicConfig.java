package com.wevioo.kafka_demo.config;

import com.wevioo.kafka_demo.payload.Student;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {
    @Bean
    //Cette méthode retourne un objet NewTopic qui représente un topic Kafka nommé "topicNum1".
    public NewTopic firstTopic() {
        return TopicBuilder
                .name("topicNum1")
                .partitions(5)
                .replicas(3) // Réplique chaque partition sur 3 broker
                .build();

    }



}
