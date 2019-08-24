package com.analyzer.approachHelper.service.product;

import com.analyzer.approachHelper.domain.Product;

public interface ProductService {

    Product getProduct(String id);

    Product createProduct(String description);
}
