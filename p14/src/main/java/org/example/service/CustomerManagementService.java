package org.example.service;

import org.example.model.Customer;
import org.example.repository.CustomerRepository;

public class CustomerManagementService {

    private final CustomerRepository customerRepository;

    public CustomerManagementService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void deleteCustomer(Customer customer) {
        boolean result = customerRepository.remove(customer);
        if (result) {
            System.out.println("пользователь с id: " + customer.getId() + " удален");
        } else {
            System.out.println("пользователь с id: " + customer.getId() + " не найден");
        }
    }

    public long registerNewCustomer(String name, String email, String phoneNumber) {
        long id = customerRepository.save(name, email, phoneNumber);
        if (id >= 0) {
            System.out.println("добавлен новый пользователь, email: " + email + ", id: " + id);
        } else {
            System.out.println("невозможно добавить пользователя, email: " + email);
        }
        return id;
    }

    public Customer getCustomerById(Long customerId) {
        return customerRepository.getCustomerById(customerId).orElse(null);
    }
}
