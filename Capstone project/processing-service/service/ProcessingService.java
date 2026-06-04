package com.example.processingservice.service;

import org.springframework.stereotype.Service;

@Service
public class ProcessingService {

    public String processOrder(int quantity) {
        return (quantity <= 5) ? "APPROVED" : "REJECTED";
    }
}
