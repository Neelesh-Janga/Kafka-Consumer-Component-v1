package com.neelesh.component.eventconsumer.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import com.neelesh.component.eventconsumer.utils.*;

@Entity
@Setter
@Getter
@ToString
public class TransactionMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    private Event event;
    private Double amount;
    private Status status;
}
