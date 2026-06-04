package com.example.processingservice.model;

public class OrderEvent {

    private Long orderId;
    private int quantity;

    public OrderEvent() {}

    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
