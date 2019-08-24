package com.analyzer.approachHelper.service.score;

import com.analyzer.approachHelper.domain.Product;

public interface Evaluator {

    Double evaluate(Product product);
}
