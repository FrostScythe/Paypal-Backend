package com.paypal.reward_service.config;

import com.paypal.reward_service.entity.Transaction;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumer {

    @Bean
    public ConsumerFactory<String, Transaction> consumerFactory(){
        JsonDeserializer<Transaction> deserializer = new JsonDeserializer<>(Transaction.class);
        deserializer.setRemoveTypeHeaders((false));
        deserializer.setUseTypeMapperForKey(true);
        // Trust both the transaction-service and reward-service packages (producer may be in transaction-service)
        deserializer.addTrustedPackages("com.paypal.transaction_service.entity,com.paypal.reward_service.entity");

        Map<String, Object> props = new HashMap<>();

        // Remove the accidental space after ':' and ensure correct broker address format
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "reward-group");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        // Use the JsonDeserializer class for the config; we still pass the configured instance to the factory below
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), deserializer);

    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Transaction> kafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, Transaction> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return  factory;
    }

}