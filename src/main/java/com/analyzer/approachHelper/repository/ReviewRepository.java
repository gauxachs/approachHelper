package com.analyzer.approachHelper.repository;

import com.analyzer.approachHelper.domain.Review;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends PagingAndSortingRepository<Review, String> {

    List<Review> findByProductId(@Param("productId") String productId);

}
