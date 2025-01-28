package org.example.service;

public interface PaymentService {

    boolean processPayment(double sum);

    boolean supports(String paymentMethod);
}
