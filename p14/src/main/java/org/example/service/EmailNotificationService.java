package org.example.service;

import org.example.model.Customer;

public class EmailNotificationService implements NotificationService {

    @Override
    public boolean sendNotification(Customer customer, String text) {
        System.out.println("Сообщение: " + text + ", отправлено клиенту id: " + customer.getId() + " на почту: " + customer.getEmail());
        return true;
    }
}
