package com.analyzer.approachHelper.repository;

import com.analyzer.approachHelper.domain.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, String> {

}
