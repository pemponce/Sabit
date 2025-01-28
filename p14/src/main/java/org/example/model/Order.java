package org.example.model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {

    private long id;

    private long customerId;

    private LocalDateTime orderDate;

    private List<Product> products;

    private Status orderStatus;

    private double totalPrice;

    public enum Status {
        PAID,
        COLLECTED,
        SENT,
        DELIVERED
    }

    public Order(long id, long customerId, LocalDateTime orderDate, List<Product> products, Status orderStatus, double totalPrice) {
        this.id = id;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.products = products;
        this.orderStatus = orderStatus;
        this.totalPrice = totalPrice;
    }

    public long getId() {
        return id;
    }


    public long getCustomerId() {
        return customerId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Status getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Status orderStatus) {
        this.orderStatus = orderStatus;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
