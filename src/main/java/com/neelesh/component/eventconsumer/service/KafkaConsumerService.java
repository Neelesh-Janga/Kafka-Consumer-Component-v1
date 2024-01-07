package com.neelesh.component.eventconsumer.service;

import com.neelesh.component.eventconsumer.DTO.TransactionMessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumerService {

    private final TransactionHandleService transactionHandleService;

    public KafkaConsumerService(TransactionHandleService transactionHandleService) {
        this.transactionHandleService = transactionHandleService;
    }

    @KafkaListener(topics = {"transaction-topic"}, groupId = "group-id")
    public void consume(TransactionMessageDTO transactionMessageDTO){
        log.info(String.format("Entering consume method with transactionMessageDTO %s", transactionMessageDTO));
        log.info(String.format("The status of received transactionMessage is %s", transactionMessageDTO.getStatus()));

        transactionHandleService.save(transactionMessageDTO);
    }
}
