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

    @Override
    public String toString() {
        return "Product{" +
                ", description='" + description + '\'' +
                ", approaches=" + approaches +
                '}';
    }
}
