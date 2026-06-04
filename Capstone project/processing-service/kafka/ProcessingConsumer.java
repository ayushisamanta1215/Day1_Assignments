package com.example.processingservice.kafka;

import com.example.processingservice.model.OrderEvent;
import com.example.processingservice.model.OrderStatusEvent;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.retrytopic.RetryableTopic;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.core.KafkaTemplate;

import org.springframework.stereotype.Component;

@Component
public class ProcessingConsumer {

    private final KafkaTemplate<String, OrderStatusEvent> kafkaTemplate;

    public ProcessingConsumer(KafkaTemplate<String, OrderStatusEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @RetryableTopic(attempts = "3")
    @KafkaListener(
            topics = "order-events",
            groupId = "processing-group"
    )
    public void consume(OrderEvent event, Acknowledgment acknowledgment) {

        String status = (event.getQuantity() <= 5) ? "APPROVED" : "REJECTED";

        OrderStatusEvent statusEvent =
                new OrderStatusEvent(event.getOrderId(), status);

        kafkaTemplate.send("order-status-events", statusEvent);

        acknowledgment.acknowledge();
    }
}
