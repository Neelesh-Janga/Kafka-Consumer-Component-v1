package com.neelesh.component.eventconsumer.service.implementation;

import com.neelesh.component.eventconsumer.DTO.TransactionMessageDTO;
import com.neelesh.component.eventconsumer.models.TransactionMessage;
import com.neelesh.component.eventconsumer.repository.TransactionRepository;
import com.neelesh.component.eventconsumer.service.TransactionHandleService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TransactionServiceHandleImpl implements TransactionHandleService {

    private final TransactionRepository transactionRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TransactionServiceHandleImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
        modelMapper = new ModelMapper();
    }

    @Override
    public void save(TransactionMessageDTO transactionMessageDTO) {
        log.info(String.format("Entering save method with TransactionMessageDTO %s", transactionMessageDTO.toString()));
        log.info(String.format("Saved transactionMessage is %s",
                transactionRepository.save(getTransactionMessage(transactionMessageDTO))));
    }

    private TransactionMessage getTransactionMessage(TransactionMessageDTO transactionMessageDTO) {
        log.info(String.format("Entering getTransactionMessage method with transactionMessageDTO %s",
                transactionMessageDTO.toString()));
        TransactionMessage transactionMessage = new TransactionMessage();
        modelMapper.map(transactionMessageDTO, transactionMessage);
        log.info(String.format("transactionMessageDTO mapped to transactionMessage %s", transactionMessage));
        return transactionMessage;
    }
}
