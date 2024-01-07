package com.neelesh.component.eventconsumer.service;

import com.neelesh.component.eventconsumer.DTO.TransactionMessageDTO;
import org.springframework.stereotype.Service;

@Service
public interface TransactionHandleService {

    void save(TransactionMessageDTO transactionMessageDTO);
}
