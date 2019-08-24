package com.analyzer.approachHelper.service.product;

import com.analyzer.approachHelper.domain.Product;
import com.analyzer.approachHelper.exception.ProductNotFoundException;
import com.analyzer.approachHelper.repository.ProductRepository;
import com.analyzer.approachHelper.service.product.ProductServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {

    private static final String PRODUCT_ID = "PRODUCT_ID";
    private static final String DESCRIPTION = "DESCRIPTION";

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository;

    @Test
    public void testGetProduct() {
        var product = mock(Product.class);
        when(product.getId()).thenReturn(PRODUCT_ID);
        when(product.getDescription()).thenReturn(DESCRIPTION);
        when(productRepository.findById(eq(PRODUCT_ID))).thenReturn(Optional.of(product));

        var productFound = productService.getProduct(PRODUCT_ID);

        assertThat(productFound.getId()).isEqualTo(PRODUCT_ID);
        assertThat(productFound.getDescription()).isEqualTo(DESCRIPTION);
    }

    @Test(expected = ProductNotFoundException.class)
    public void testProductNotFoundException() {
        productService.getProduct(PRODUCT_ID);
    }

    @Test
    public void testCreateProduct() {
        var product = mock(Product.class);
        when(product.getDescription()).thenReturn(DESCRIPTION);
        when(productRepository.save(any(Product.class))).thenReturn(product);

        var productSaved = productService.createProduct(DESCRIPTION);

        assertThat(productSaved.getDescription()).isEqualTo(DESCRIPTION);
        verify(productRepository).save(any(Product.class));
    }
}