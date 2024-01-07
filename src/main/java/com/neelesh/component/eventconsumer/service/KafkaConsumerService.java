package com.neelesh.component.eventconsumer.service;

import com.neelesh.component.eventconsumer.models.TransactionMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumerService {

    @KafkaListener(topics = {"transaction-topic"}, groupId = "group-id")
    public void consume(TransactionMessage transactionMessage){
        log.info(String.format("Entering consume method with received id %s and transactionMessage %s",
                transactionMessage.getTransactionId().toString(), transactionMessage.toString()));

        log.info(String.format("The status of received transactionMessage is %s", transactionMessage.getStatus()));
    }
}
