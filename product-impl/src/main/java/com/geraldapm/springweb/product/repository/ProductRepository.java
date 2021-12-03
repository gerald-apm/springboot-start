package com.geraldapm.springweb.product.repository;

import com.geraldapm.springweb.product.data.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
