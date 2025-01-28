package org.example.service;

import org.example.model.Customer;
import org.example.model.Order;
import org.example.model.Product;
import org.example.repository.OrderRepository;

import java.util.List;

public class OrderManagementService {

    private final OrderRepository orderRepository;

    private final CustomerManagementService customerManagementService;

    private final ShoppingCartService cartService;

    private final List<PaymentService> paymentServices;

    private final List<NotificationService> notificationServices;

    public OrderManagementService(OrderRepository orderRepository, CustomerManagementService customerManagementService, ShoppingCartService cartService, List<PaymentService> paymentServices, List<NotificationService> notificationServices) {
        this.orderRepository = orderRepository;
        this.customerManagementService = customerManagementService;
        this.cartService = cartService;
        this.paymentServices = paymentServices;
        this.notificationServices = notificationServices;
    }

    public long createOrder(Customer customer, String paymentMethod) {
        List<Product> products = cartService.getCustomerCart(customer);
        if (products == null) {
            return -1;
        }

        PaymentService selectedPaymentService = paymentServices.stream()
                .filter(service -> service.supports(paymentMethod))
                .findFirst()
                .orElse(null);

        if (selectedPaymentService == null) {
            System.out.println("Некорректный метод оплаты: " + paymentMethod);
            return -1; // Не найден подходящий метод оплаты
        }

        double totalSum = products.stream().mapToDouble(Product::getPrice).sum();
        boolean paid = selectedPaymentService.processPayment(totalSum);
        if (!paid) {
            return -1;
        }

        long orderId = orderRepository.createOrder(products, customer);

        for (NotificationService notificationService : notificationServices) {
            notificationService.sendNotification(customer, "Заказ с номером " + orderId + " оформлен");
        }
        return orderId;
    }

    public void setNewOrderState(long orderId, Order.Status state) {
        boolean isChanged = orderRepository.changeStatus(orderId, state);
        if (isChanged) {
            Order order = orderRepository.getOrderById(orderId).orElse(null);
            if (order == null) {
                return;
            }
            Customer customer = customerManagementService.getCustomerById(order.getCustomerId());
            String messageText = changeStatusMessage(orderId, state);
            for (NotificationService notificationService : notificationServices) {
                notificationService.sendNotification(customer, messageText);
            }
        }
    }

    private String changeStatusMessage(long orderId, Order.Status status) {
        String statusMessage = "";
        if (status == Order.Status.COLLECTED) {
           statusMessage = "Ваш заказ собирается.";
        } else if (status == Order.Status.SENT) {
            statusMessage = "Ваш заказ отправлен.";
        } else if (status == Order.Status.DELIVERED) {
            statusMessage = "Ваш заказ доставлен.";
        }
        return "У заказа " + orderId + " изменился статус. " + statusMessage;

    }
}
