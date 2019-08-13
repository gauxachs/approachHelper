package com.analyzer.approachHelper.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Approach {

    @Id
    @GeneratedValue(generator = "UUID", strategy = GenerationType.AUTO)
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "CHAR(36)")
    private String id;

    private String code;

    @ManyToOne
    private Product product;

    public Approach() {
    }

    public Approach(String code, Product product) {
        this.code = code;
        this.product = product;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "Approach{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", product=" + product +
                '}';
    }
}
