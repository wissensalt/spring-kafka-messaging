package com.wissensalt.springkafkamessaging.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wissensalt.springkafkamessaging.data.Employee;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created on 3/30/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class Consumer {

    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "${topic.one}", groupId = "${groupId.one}")
    public void consumerTopicOneGroupOne(String message) {
        log.info("Received Message Topic One From Group Id One {}", message);
    }

    @KafkaListener(topics = "${topic.one}", groupId = "${groupId.two}")
    public void consumerTopicOneGroupTwo(String message) {
        log.info("Received Message Topic One From Group Id Two {}", message);
    }

    @KafkaListener(topics = "${topic.two}", groupId = "${groupId.one}")
    public void consumerTopicTwoGroupOne(String message) {
        log.info("Received Message Topic Two From Group Id One {}", message);
    }

    @KafkaListener(topics = "${topic.two}", groupId = "${groupId.two}")
    public void consumerTopicTwoGroupTwo(String message) {
        log.info("Received Message Topic Two From Group Id Two {}", message);
    }

    @KafkaListener(topics = "${topic.one}", groupId = "${groupId.three}")
    public void consumerJsonTopicOneGroupOne(String message) throws IOException {
        log.info("Received Json Message Topic One From Group Id One {}", message);
        final Employee employee = objectMapper.readValue(message, Employee.class);

        log.info("Converter Message to Object: {}", employee.toString());
    }
}
