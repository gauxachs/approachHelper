package com.analyzer.approachHelper.api;

import com.analyzer.approachHelper.dto.ApproachResponse;
import com.analyzer.approachHelper.service.approach.ApproachService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/approaches")
public class ApproachController {

    private ApproachService approachService;

    public ApproachController(ApproachService approachService) {
        this.approachService = approachService;
    }

    @GetMapping
    public ApproachResponse getApproach(@RequestParam("productId") String productId) {
        var approach = approachService.getApproachByProductId(productId);

        return new ApproachResponse(approach.getProduct().getId(), approach.getCode());
    }
}
