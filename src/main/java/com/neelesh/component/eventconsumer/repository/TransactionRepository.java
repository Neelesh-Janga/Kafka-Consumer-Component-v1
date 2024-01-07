package com.neelesh.component.eventconsumer.repository;

import com.neelesh.component.eventconsumer.models.TransactionMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionMessage, Long> {

}
