package org.example.rsp;

import java.util.Map;

public class ReportGenerator {
    private String reportTemplate;

    public void setReportTemplate(String template) {
        this.reportTemplate = template;
    }

    public String generateReport(Map<String, Integer> orderStatistics) {
        StringBuilder report = new StringBuilder("User Report:\n");
        for (Map.Entry<String, Integer> entry : orderStatistics.entrySet()) {
            report.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return reportTemplate == null ? report.toString() : reportTemplate + report;
    }
}