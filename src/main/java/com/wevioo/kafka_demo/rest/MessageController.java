package com.wevioo.kafka_demo.rest;

import com.wevioo.kafka_demo.payload.Student;
import com.wevioo.kafka_demo.producer.KafkaJsonProducer;
import com.wevioo.kafka_demo.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/msg")

public class MessageController {
    private  final KafkaProducer kafkaProducer;
    private final KafkaJsonProducer kafkaJsonProducer;

    // Constructeur explicite
    public MessageController(KafkaProducer kafkaProducer, KafkaJsonProducer kafkaJsonProducer) {
        this.kafkaProducer = kafkaProducer;
        this.kafkaJsonProducer = kafkaJsonProducer;
    }

    @PostMapping
    public ResponseEntity<String> sendMessage(
            @RequestBody String message)
    {
      kafkaProducer.sendMessage(message);
      return  ResponseEntity.ok("Message queued successfully");
    }

    @PostMapping("/json")
    public ResponseEntity<String> sendJsonMessage(
            @RequestBody Student message
    ) {
        kafkaJsonProducer.sendMessage(message);
        return ResponseEntity.ok("Message queued successfully as JSON");
    }
}


