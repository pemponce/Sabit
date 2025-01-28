package org.example.repository;

import org.example.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerRepository {

    private List<Customer> customers = new ArrayList<>();

    private long customerId = 0;

    public long save(String name, String email, String phoneNumber) {
        Optional<Customer> customerWithEmailOp = customers.stream().filter(user -> user.getEmail().equals(email)).findFirst();

        if (customerWithEmailOp.isPresent()) {
            return -1;
        }

        Customer customer = new Customer(
                customerId,
                name,
                email,
                phoneNumber
        );
        customerId += 1;

        customers.add(customer);
        return customerId - 1;
    }

    public boolean remove(Customer customer) {
        return customers.remove(customer);
    }

    public Optional<Customer> getCustomerById(long customerId) {
        return customers.stream().filter(customer -> customer.getId() == customerId).findFirst();
    }
}
