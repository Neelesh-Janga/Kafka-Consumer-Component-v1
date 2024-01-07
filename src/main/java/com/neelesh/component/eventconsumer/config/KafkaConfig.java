package com.neelesh.component.eventconsumer.config;

import com.neelesh.component.eventconsumer.DTO.TransactionMessageDTO;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.UUIDDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@EnableKafka
@Configuration
public class KafkaConfig {

    @Bean
    public ConsumerFactory<UUID, TransactionMessageDTO> consumerFactory(){
        Map<String, Object> consumerProps = new HashMap<>();
        consumerProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        consumerProps.put(ConsumerConfig.GROUP_ID_CONFIG, "group-id");
        consumerProps.put(ErrorHandlingDeserializer.KEY_DESERIALIZER_CLASS, UUIDDeserializer.class);
        consumerProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, UUIDDeserializer.class);
        consumerProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        consumerProps.put(ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS, JsonDeserializer.class);
        consumerProps.put(JsonDeserializer.USE_TYPE_INFO_HEADERS, false);
        consumerProps.put(
                JsonDeserializer.VALUE_DEFAULT_TYPE, "com.neelesh.component.eventconsumer.DTO.TransactionMessageDTO"
        );

        return new DefaultKafkaConsumerFactory<>(consumerProps);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<UUID, TransactionMessageDTO> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<UUID, TransactionMessageDTO>
                factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
