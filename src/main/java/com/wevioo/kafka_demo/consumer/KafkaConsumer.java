package com.wevioo.kafka_demo.consumer;

import com.wevioo.kafka_demo.producer.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
//@Slf4j
public class KafkaConsumer {
    private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);


    @KafkaListener(topics = "topicNum1" , groupId="myGrp")
    public  void consumeMsg(String msg)
    {
        log.info(format("consuming the msg from topic num 1 topic:: %s" , msg));

    }
}
