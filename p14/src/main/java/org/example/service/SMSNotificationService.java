package org.example.service;

import org.example.model.Customer;

public class SMSNotificationService implements NotificationService {
    @Override
    public boolean sendNotification(Customer customer, String text) {
        System.out.println("Сообщение: " + text + ", отправлено клиенту id: " + customer.getId() + " по номеру телефона: " + customer.getPhoneNumber());
        return true;
    }
}
