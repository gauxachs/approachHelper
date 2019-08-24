package com.analyzer.approachHelper.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue(generator = "UUID", strategy = GenerationType.AUTO)
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "CHAR(36)")
    private String id;

    private String score;

    @ManyToOne
    private Product product;

    public Review() {
        //empty constructor
    }

    public Review(String score, Product product) {
        this.score = score;
        this.product = product;
    }

    public String getId() {
        return id;
    }

    public String getScore() {
        return score;
    }

    public Product getProduct() {
        return product;
    }
}
