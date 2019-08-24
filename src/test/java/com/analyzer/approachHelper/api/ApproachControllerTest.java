package com.analyzer.approachHelper.api;

import com.analyzer.approachHelper.domain.Approach;
import com.analyzer.approachHelper.domain.Product;
import com.analyzer.approachHelper.service.approach.ApproachService;
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
public class ApproachControllerTest {

    private static final String PRODUCT_ID = "PRODUCT_ID";
    private static final String CODE = "CODE";
    private static final String DESCRIPTION = "DESCRIPTION";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ApproachService approachService;

    @Before
    public void setUp() {
        var product = mock(Product.class);
        when(product.getId()).thenReturn(PRODUCT_ID);
        when(product.getDescription()).thenReturn(DESCRIPTION);
        var approach = new Approach(CODE, product);

        when(approachService.getApproachByProductId(PRODUCT_ID)).thenReturn(approach);
    }


    @Test
    public void testGetApproachByProductStatusOk() throws Exception {
        mvc.perform(get("/approaches")
                .param("productId", PRODUCT_ID))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetApproachByProductId() throws Exception {
        mvc.perform(get("/approaches")
                .param("productId", PRODUCT_ID))
                .andExpect(jsonPath("productId").value(PRODUCT_ID))
                .andExpect(jsonPath("code").value(CODE));
    }
}
