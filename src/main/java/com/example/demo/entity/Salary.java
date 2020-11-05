package com.example.demo.entity;

import lombok.Data;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;
@NamedQueries({
        @NamedQuery(name = "Salary.findAll",query = "SELECT s from Salary s"),
        @NamedQuery(name = "Salary.findMaxSalary", query = "SELECT MAX(amount) from Salary"),
        @NamedQuery(name = "Salary.findSalaryByActorId", query = "SELECT s from Salary s where actor_id=:actor_id")
})
@Data
@Entity
@Table(name = "salary")
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "amount")
    private Float amount;

    @Column(name = "rank")
    private Integer rank;

    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date created_at;

    @Column(name = "updated_at")
    @Temporal(TemporalType.DATE)
    private Date updated_at;

    @OneToOne
    @JoinColumn(name = "actor_id",referencedColumnName = "actor_id")
    private Actor actor;

}
