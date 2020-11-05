package com.example.demo.dao;

import com.example.demo.entity.Salary;

import java.util.List;

public interface SalaryDao {
    public List<Salary> findAll();

    public void createOrUpdateSalary(Salary salary);

    public Float findMaxSalary();

    public Salary findSalaryByActorId(Integer id);
}
