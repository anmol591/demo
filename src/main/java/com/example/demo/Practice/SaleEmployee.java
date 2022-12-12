package com.example.demo.Practice;

public class SaleEmployee extends Employee{

    public SaleEmployee(double totalSalary, double bonus) {
        super(totalSalary, bonus);
    }

    @Override
    protected double calculateTotalSalary() {
        return this.getTotalSalary() + this.getBonus();
    }
}
