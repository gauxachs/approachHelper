package com.analyzer.approachHelper.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    private LocalDateTime date;

    public Review() {
        //empty constructor
    }

    public Review(String score, Product product) {
        this.score = score;
        this.product = product;
        this.date = LocalDateTime.now();
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

    public LocalDateTime getDate() {
        return date;
    }
}
