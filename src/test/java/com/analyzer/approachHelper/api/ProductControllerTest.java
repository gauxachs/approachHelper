package com.analyzer.approachHelper.api;

import com.analyzer.approachHelper.domain.Product;
import com.analyzer.approachHelper.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {

    private static final String PRODUCT_ID = "PRODUCT_ID";
    private static final String DESCRIPTION = "DESCRIPTION";

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProductService productService;

    @Before
    public void setUp() {
        var product = mock(Product.class);
        when(product.getId()).thenReturn(PRODUCT_ID);
        when(product.getDescription()).thenReturn(DESCRIPTION);

        when(productService.getProduct(PRODUCT_ID)).thenReturn(product);
    }

    @Test
    public void testGetProductStatusOk() throws Exception {
        mvc.perform(get("/products/{productId}", PRODUCT_ID))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetProductById() throws Exception {
        mvc.perform(get("/products/{productId}", PRODUCT_ID))
                .andExpect(jsonPath("id").value(PRODUCT_ID));
    }

    @Test
    public void testGetProductDescriptionByProductId() throws Exception {
        mvc.perform(get("/products/{productId}", PRODUCT_ID))
                .andExpect(jsonPath("description").value(DESCRIPTION));
    }

}