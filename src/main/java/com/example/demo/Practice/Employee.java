package com.example.demo.Practice;

public abstract class Employee {
    private double totalSalary;
    private double bonus;

    public Employee(double totalSalary, double bonus){
        this.totalSalary = totalSalary;
        this.bonus = bonus;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    protected abstract double calculateTotalSalary();

}
