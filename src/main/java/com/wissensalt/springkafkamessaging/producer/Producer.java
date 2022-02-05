package com.wissensalt.springkafkamessaging.producer;

import com.wissensalt.springkafkamessaging.data.Employee;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Created on 3/30/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class Producer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${topic.one}")
    private String topicOne;

    @Value("${topic.two}")
    private String topicTwo;

    public void sendToTopicOne(String message) {
        log.info("Sending Message To Topic One : {}", message);
        kafkaTemplate.send(topicOne, message);
    }

    public void sendToTopicTwo(String message) {
        log.info("Sending Message To Topic Two : {}", message);
        kafkaTemplate.send(topicTwo, message);
    }

    public void sendToTopicTwo(Employee employee) {
        log.info("Sending Message To Topic Two : {}", employee);
        kafkaTemplate.send(topicTwo, employee);
    }
}
