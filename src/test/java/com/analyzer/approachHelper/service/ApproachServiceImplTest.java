package com.analyzer.approachHelper.service;

import com.analyzer.approachHelper.domain.Approach;
import com.analyzer.approachHelper.domain.Product;
import com.analyzer.approachHelper.exception.ApproachNotFoundException;
import com.analyzer.approachHelper.repository.ApproachRepository;
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
public class ApproachServiceImplTest {

    private static final String PRODUCT_ID = "PRODUCT_ID";
    private static final String APPROACH_CODE = "CODE";

    @InjectMocks
    private ApproachServiceImpl approachService;

    @Mock
    private ApproachRepository approachRepository;

    @Test
    public void testGetApproachByProductId() {
        var product = new Product(PRODUCT_ID);
        var approach = new Approach(APPROACH_CODE, product);
        when(approachRepository.findByProductId(eq(PRODUCT_ID))).thenReturn(Optional.of(approach));

        var approachFound = approachService.getApproachByProductId(PRODUCT_ID);

        assertThat(approachFound.getProduct().getId()).isEqualTo(PRODUCT_ID);
    }

    @Test(expected = ApproachNotFoundException.class)
    public void testApproachByProductIdNotFoundException() {
        approachService.getApproachByProductId(PRODUCT_ID);
    }
}