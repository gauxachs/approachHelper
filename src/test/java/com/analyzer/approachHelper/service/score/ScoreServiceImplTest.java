package com.analyzer.approachHelper.service.score;

import com.analyzer.approachHelper.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class ScoreServiceImplTest {

    @InjectMocks
    private ScoreServiceImpl scoreService;

    @Test
    public void calculateScore() {
        var product = mock(Product.class);
        scoreService.calculateScore(product);
    }
}