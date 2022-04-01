package com.example.kafkatest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    KafkaTemplate<String,SimpleObject> kafkaTemplate;

    @GetMapping("/send/{message}")
    public String sendMessage(@PathVariable String message){
     kafkaTemplate.send("first_topic",new SimpleObject(message,"desc"));
     return "Message: "+ message+"Successfully sent!";
    }

    @KafkaListener(topics = "first_topic", groupId = "foo",containerFactory = "kafkaListenerContainerFactory")
    public void listenGroupFoo(SimpleObject message) {
        System.out.println("Received Message in group foo: " + message);
    }
}
