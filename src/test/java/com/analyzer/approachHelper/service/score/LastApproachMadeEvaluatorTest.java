package com.analyzer.approachHelper.service.score;

import com.analyzer.approachHelper.domain.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class LastApproachMadeEvaluatorTest {

    @InjectMocks
    private LastApproachMadeEvaluator evaluator;

    @Before
    public void setUp() {
    }

    @Test
    public void testEvaluate() {
        var product = mock(Product.class);
        evaluator.evaluate(product);
    }
}