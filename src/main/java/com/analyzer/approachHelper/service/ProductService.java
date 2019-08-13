package com.analyzer.approachHelper.service;

import com.analyzer.approachHelper.domain.Product;

public interface ProductService {

    Product getProduct(String id);

    Product createProduct(String description);
}
