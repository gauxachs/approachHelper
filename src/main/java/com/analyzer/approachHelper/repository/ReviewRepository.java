package com.analyzer.approachHelper.repository;

import com.analyzer.approachHelper.domain.Review;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReviewRepository extends PagingAndSortingRepository<Review, String> {

    Optional<Review> findByProductId(@Param("productId") String productId);

}
