package ru.maslov.kafkaclient.listeners;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaAnswerListener {

    @KafkaListener(topics="answers")
    public void msgListener(ConsumerRecord<Long, String> record){
        System.out.println("getting answer for user with id " + record.key());
        System.out.println("answer is " + record.value());
    }
}
