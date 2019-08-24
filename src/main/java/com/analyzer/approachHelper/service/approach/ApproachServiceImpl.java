package com.analyzer.approachHelper.service.approach;

import com.analyzer.approachHelper.domain.Approach;
import com.analyzer.approachHelper.exception.ApproachNotFoundException;
import com.analyzer.approachHelper.repository.ApproachRepository;
import org.springframework.stereotype.Service;

@Service
public class ApproachServiceImpl implements ApproachService {

    private ApproachRepository approachRepository;

    public ApproachServiceImpl(ApproachRepository approachRepository) {
        this.approachRepository = approachRepository;
    }

    @Override
    public Approach getApproachByProductId(String productId) {
        return approachRepository.findByProductId(productId)
                .orElseThrow(() -> new ApproachNotFoundException(String.format("Approach not found - productId: %s", productId)));
    }
}
