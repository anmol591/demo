package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "actors")
@Data
public class Actors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('m','f')")
    private Sex sex;

    @Column(name = "last_update",updatable = false,insertable = false)
    private Date lastUpdate;
}
