package org.example.rsp;

import java.util.HashMap;
import java.util.Map;

public class OrderManager {
    private final Map<String, Integer> orderStatistics = new HashMap<>();

    public void addOrder(String user, int amount) {
        orderStatistics.put(user, orderStatistics.getOrDefault(user, 0) + amount);
    }

    public Map<String, Integer> getOrderStatistics() {
        return orderStatistics;
    }
}
