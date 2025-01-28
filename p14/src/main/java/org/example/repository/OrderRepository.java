package org.example.repository;

import org.example.model.Customer;
import org.example.model.Order;
import org.example.model.Product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderRepository {

    private final List<Order> orders = new ArrayList<>();

    private long orderId = 0;

    public long createOrder(List<Product> products, Customer customer) {
        double totalPrice = products.stream().mapToDouble(Product::getPrice).sum();
        long id = orderId;
        orderId += 1;
        orders.add(new Order(
                id,
                customer.getId(),
                LocalDateTime.now(),
                products,
                Order.Status.PAID,
                totalPrice
        ));

        return id;
    }

    public boolean changeStatus(long orderId, Order.Status newStatus) {
        Optional<Order> orderOp = orders.stream().filter(order1 -> order1.getId() == orderId).findFirst();

        if (orderOp.isPresent()) {
            Order order = orderOp.get();
            if (newStatus.ordinal() > order.getOrderStatus().ordinal()) {
                order.setOrderStatus(newStatus);
                return true;
            }
        }
        return false;
    }

    public Optional<Order> getOrderById(long orderId) {
        return orders.stream().filter(order -> order.getId() == orderId).findFirst();

    }
}
