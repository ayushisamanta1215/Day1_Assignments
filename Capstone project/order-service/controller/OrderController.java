package com.example.orderservice.controller;

import com.example.orderservice.kafka.OrderProducer;
import com.example.orderservice.model.OrderEvent;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderProducer producer;

    public OrderController(OrderProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public OrderEvent createOrder(@RequestBody OrderEvent order) {

        order.setOrderId(Math.abs(new Random().nextLong()));
        order.setStatus("CREATED");

        producer.send(order);
        return order;
    }
}
