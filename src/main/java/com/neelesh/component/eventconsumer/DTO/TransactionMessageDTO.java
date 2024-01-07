package com.neelesh.component.eventconsumer.DTO;

import com.neelesh.component.eventconsumer.utils.Event;
import com.neelesh.component.eventconsumer.utils.Status;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class TransactionMessageDTO {

    private Long transactionId;
    private Event event;
    private Double amount;
    private Status status;
}
