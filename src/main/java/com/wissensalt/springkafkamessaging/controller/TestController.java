package com.wissensalt.springkafkamessaging.controller;

import com.wissensalt.springkafkamessaging.data.Employee;
import com.wissensalt.springkafkamessaging.producer.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 3/30/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RequiredArgsConstructor
@RestController
public class TestController {

    private final Producer producer;

    @GetMapping("/one/{message}")
    public String sendMessageOne(@PathVariable("message") String message) {
        producer.sendToTopicOne(message);

        return message;
    }

    @GetMapping("/two/{message}")
    public String sendMessageTwo(@PathVariable("message") String message) {
        producer.sendToTopicTwo(message);

        return message;
    }

    @PostMapping("/one")
    public Employee sendPostMessageTwo(@RequestBody Employee employee) {
        producer.sendToTopicTwo(employee);

        return employee;
    }
}
