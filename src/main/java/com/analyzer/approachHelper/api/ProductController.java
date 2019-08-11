package com.analyzer.approachHelper.api;

import com.analyzer.approachHelper.dto.ProductResponse;
import com.analyzer.approachHelper.service.ProductService;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    private ProjectionFactory projectionFactory;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ProductResponse getProduct(@PathVariable("id") String id) {
        var product = productService.getProduct(id);
        return new ProductResponse(product.getId());
    }
}
