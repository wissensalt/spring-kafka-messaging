package com.wissensalt.springkafkamessaging.endpoint;

import com.wissensalt.springkafkamessaging.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created on 3/30/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
@RequestMapping("/kafka")
public class KafkaEndPoint {

    @Autowired
    private Producer producer;

    @GetMapping("/publish")
    public void sendMessage(@RequestParam("message") String p_Message) {
        this.producer.sendMessage(p_Message);
    }
}
