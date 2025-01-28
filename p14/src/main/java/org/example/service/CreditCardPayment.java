package org.example.service;

public class CreditCardPayment implements PaymentService {

    private final String PAYMENT_METHOD_NAME = "CREDIT_CARD";

    @Override
    public boolean processPayment(double sum) {
        System.out.println("Заказ оплачен кредиткой на сумму: " + sum);
        return false;
    }

    @Override
    public boolean supports(String paymentMethod) {
        return false;
    }
}
