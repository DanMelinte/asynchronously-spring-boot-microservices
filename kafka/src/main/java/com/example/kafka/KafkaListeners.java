package com.example.kafka;

import com.example.kafka.entity.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

//    @KafkaListener(
//            topics = "newtopic1",
//            groupId = "fooGroupID1"
//    )
//    void listener(String data) {
//        System.out.println("Listener recieved: " + data);
//    }

    @KafkaListener(
            topics = "newtopic1",
            groupId = "fooGroupID1",
            containerFactory = "messageFactory"
    )
    void listener(Message data) {
        System.out.println("Listener recieved: " + data);
    }
}
