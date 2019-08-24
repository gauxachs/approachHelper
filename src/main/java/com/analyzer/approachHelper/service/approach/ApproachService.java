package com.analyzer.approachHelper.service.approach;

import com.analyzer.approachHelper.domain.Approach;

public interface ApproachService {

    Approach getApproachByProductId(String productId);
}
