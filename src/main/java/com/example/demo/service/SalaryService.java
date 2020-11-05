package com.example.demo.service;

import com.example.demo.entity.Salary;

import java.util.List;

public interface SalaryService {
    public List<Salary> findAll();

    public void createOrUpdateSalary(Salary salary);

    public Float findMaxSalary();

    public Salary findSalaryByActorId(Integer id);
}
