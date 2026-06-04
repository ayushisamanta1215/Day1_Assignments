package com.example.userservice.model;

public class OrderStatusEvent {

    private Long orderId;
    private String status;

    public OrderStatusEvent() {}

    public OrderStatusEvent(Long orderId, String status) {
        this.orderId = orderId;
        this.status = status;
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getStatus() {
        return status;
    }
}
