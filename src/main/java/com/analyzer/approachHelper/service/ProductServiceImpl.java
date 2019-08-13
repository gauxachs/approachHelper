package com.analyzer.approachHelper.service;

import com.analyzer.approachHelper.domain.Product;
import com.analyzer.approachHelper.exception.ProductNotFoundException;
import com.analyzer.approachHelper.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getProduct(String id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(String.format("Product not found - product ID: %s)", id)));
    }

    @Override
    public Product createProduct(String description) {
        return productRepository.save(new Product(description));
    }
}
