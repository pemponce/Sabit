package org.example.service;

import org.example.model.Customer;

public interface NotificationService {

    boolean sendNotification(Customer customer, String text);
}
