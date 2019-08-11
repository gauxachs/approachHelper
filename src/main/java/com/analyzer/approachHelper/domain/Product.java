package com.analyzer.approachHelper.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(generator = "UUID", strategy = GenerationType.AUTO)
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "CHAR(36)")
    private String id;

    public Product() {
        //empty constructor
    }

    public Product(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                '}';
    }
}
