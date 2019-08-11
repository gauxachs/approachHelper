package com.analyzer.approachHelper.service;

import com.analyzer.approachHelper.domain.Product;
import com.analyzer.approachHelper.exception.ProductNotFoundException;
import com.analyzer.approachHelper.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {

    private static final String PRODUCT_ID = "PRODUCT_ID";

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository;

    @Test
    public void testGetProduct() {
        var product = new Product(PRODUCT_ID);
        when(productRepository.findById(eq(PRODUCT_ID))).thenReturn(Optional.of(product));

        var productFound = productService.getProduct(PRODUCT_ID);

        assertThat(productFound.getId()).isEqualTo(PRODUCT_ID);
    }

    @Test(expected = ProductNotFoundException.class)
    public void testProductNotFoundException() {
        productService.getProduct(PRODUCT_ID);
    }
}