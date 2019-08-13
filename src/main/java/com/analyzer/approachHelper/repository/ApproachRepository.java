package com.analyzer.approachHelper.repository;

import com.analyzer.approachHelper.domain.Approach;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApproachRepository extends PagingAndSortingRepository<Approach, String> {

    Optional<Approach> findByProductId(@Param("productId") String productId);
}
