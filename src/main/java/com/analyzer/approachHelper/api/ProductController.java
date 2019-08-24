package com.analyzer.approachHelper.api;

import com.analyzer.approachHelper.dto.CreateProductRequest;
import com.analyzer.approachHelper.dto.ProductResponse;
import com.analyzer.approachHelper.service.product.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ProductResponse getProduct(@PathVariable("id") String id) {
        var product = productService.getProduct(id);

        return new ProductResponse(product.getId(), product.getDescription());
    }

    @PostMapping
    public ProductResponse createProduct(@RequestBody CreateProductRequest createProductRequest) {
        var product = productService.createProduct(createProductRequest.getDescription());

        return new ProductResponse(product.getId(), product.getDescription());
    }
}
