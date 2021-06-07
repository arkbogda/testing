package org.example.testing.salaryCalculator;

import java.math.BigDecimal;

public class Employee {

    private String name;
    private BigDecimal baseSalary;

    public Employee(String name, BigDecimal baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getBaseSalary() {
        return baseSalary;
    }
}
