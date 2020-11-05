package com.example.demo.dao;

import com.example.demo.entity.Salary;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

@Component
public class SalaryDaoImpl implements SalaryDao {

    @Autowired
    private EntityManager entityManager;


    @Override
    public List<Salary> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        /*
        TypedQuery<Salary> query = currentSession.createNamedQuery("Salary.findAll",Salary.class);
        List<Salary> results = query.getResultList();
        return  results;
        1st way*/

        Query query = currentSession.createNamedQuery("Salary.findAll",Salary.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void createOrUpdateSalary(Salary salary) {
       Session currentSession = entityManager.unwrap(Session.class);
       currentSession.saveOrUpdate(salary);
    }

    @Override
    @Transactional
    public Float findMaxSalary() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createNamedQuery("Salary.findMaxSalary", Float.class);
        return null;
    }

    @Override
    @Transactional
    public Salary findSalaryByActorId(Integer id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createNamedQuery("Salary.findSalaryByActorId",Salary.class);
        query.setParameter("actor_id",id);
        return (Salary) query.getSingleResult();
    }
}
