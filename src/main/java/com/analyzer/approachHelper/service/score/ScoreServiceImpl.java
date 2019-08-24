package com.analyzer.approachHelper.service.score;

import com.analyzer.approachHelper.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    private List<Evaluator> evaluators;

    public ScoreServiceImpl(List<Evaluator> evaluators) {
        this.evaluators = evaluators;
    }

    @Override
    public Double calculateScore(Product product) {
        return null;
    }
}
