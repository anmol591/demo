package com.example.demo.service;

import com.example.demo.dao.SalaryDao;
import com.example.demo.entity.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    private SalaryDao salaryDao;

    @Override
    public List<Salary> findAll() {
        return salaryDao.findAll();
    }

    @Override
    public void createOrUpdateSalary(Salary salary) {
       salaryDao.createOrUpdateSalary(salary);
    }

    @Override
    public Float findMaxSalary() {
        return salaryDao.findMaxSalary();
    }

    @Override
    public Salary findSalaryByActorId(Integer id) {
        return salaryDao.findSalaryByActorId(id);
    }
}
