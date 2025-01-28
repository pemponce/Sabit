package org.example;

import org.example.model.Customer;
import org.example.model.Order;
import org.example.model.Product;
import org.example.repository.CustomerRepository;
import org.example.repository.OrderRepository;
import org.example.service.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        NotificationService emailNotification = new EmailNotificationService();
        NotificationService SMSNotification = new SMSNotificationService();

        PaymentService payPal = new PayPalPayment();
        PaymentService creditCard = new CreditCardPayment();

        CustomerRepository customerRepository  = new CustomerRepository();
        OrderRepository orderRepository = new OrderRepository();
        ShoppingCartService shoppingCartService = new ShoppingCartService();
        CustomerManagementService customerManagementService = new CustomerManagementService(customerRepository);

        OrderManagementService orderManagementService = new OrderManagementService(
                orderRepository,
                customerManagementService,
                shoppingCartService,
                List.of(payPal, creditCard),
                List.of(emailNotification, SMSNotification)
        );

        Product product1 = new Product(1L, "Shirt", 100.25);
        Product product2 = new Product(2L, "Bag", 12.5);

        customerManagementService.registerNewCustomer("pemponce", "pimponceoff@gmail.com", "89372907817");
        Customer customer = customerManagementService.getCustomerById(0L);
        shoppingCartService.putToCart(customer, product1);
        shoppingCartService.putToCart(customer, product2);

        long orderID = orderManagementService.createOrder(customer, "PAY_PAL");

        orderManagementService.setNewOrderState(orderID, Order.Status.COLLECTED);
        orderManagementService.setNewOrderState(orderID, Order.Status.SENT);
        orderManagementService.setNewOrderState(orderID, Order.Status.DELIVERED);
        orderManagementService.setNewOrderState(orderID, Order.Status.PAID);
    }
}