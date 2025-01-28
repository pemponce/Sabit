package org.example.god_object;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GodObject {
    private List<String> users = new ArrayList<>();
    private Map<String, Integer> orderStatistics = new HashMap<>();
    private String reportTemplate;

    // работа с пользователями
    public void addUser(String user) {
        users.add(user);
    }

    public void removeUser(String user) {
        users.remove(user);
    }

    public List<String> getUsers() {
        return users;
    }

    // работа с заказами
    public void addOrder(String user, int amount) {
        orderStatistics.put(user, orderStatistics.getOrDefault(user, 0) + amount);
    }

    public Map<String, Integer> getOrderStatistics() {
        return orderStatistics;
    }

    // работа с репортами
    public void setReportTemplate(String template) {
        this.reportTemplate = template;
    }

    public String generateReport() {
        StringBuilder report = new StringBuilder("User Report:\n");
        for (Map.Entry<String, Integer> entry : orderStatistics.entrySet()) {
            report.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return reportTemplate == null ? report.toString() : reportTemplate + report;
    }
}
