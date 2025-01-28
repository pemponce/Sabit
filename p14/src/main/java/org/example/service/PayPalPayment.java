package org.example.service;

import javax.swing.plaf.PanelUI;

public class PayPalPayment implements PaymentService {

    private final String PAYMENT_METHOD_NAME = "PAY_PAL";

    @Override
    public boolean processPayment(double sum) {
        System.out.println("Оплачен заказ не сумму: " + sum);
        return true;
    }

    @Override
    public boolean supports(String paymentMethod) {
        return paymentMethod.equals(PAYMENT_METHOD_NAME);
    }
}
