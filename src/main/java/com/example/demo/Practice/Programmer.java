package com.example.demo.Practice;

public class Programmer extends Employee{
    private double extraTds;


    public Programmer(double totalSalary, double bonus, double extraTds) {
        super(totalSalary, bonus);
        this.extraTds = extraTds;
    }

    public double getExtraTds() {
        return extraTds;
    }

    public void setExtraTds(double extraTds) {
        this.extraTds = extraTds;
    }

    @Override
    protected double calculateTotalSalary() {
        return (this.getTotalSalary()+this.getBonus()) - 0.1*this.getTotalSalary() - calculateExtraTds();
    }


    private double calculateExtraTds() {
        return (this.getExtraTds()/100)*this.getTotalSalary();
    }
}
