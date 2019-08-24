package com.analyzer.approachHelper.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue(generator = "UUID", strategy = GenerationType.AUTO)
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "CHAR(36)")
    private String id;

    @OneToMany(mappedBy = "product")
    private Set<Approach> approaches;

    @OneToMany(mappedBy = "product")
    private Set<Review> reviews;

    private String description;

    public Product() {
        //empty constructor
    }

    public Product(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Set<Approach> getApproaches() {
        return approaches;
    }

    public Set<Review> getReviews() {
        return reviews;
    }
}
