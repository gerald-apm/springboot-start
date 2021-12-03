package com.geraldapm.springweb.product.service;

import com.geraldapm.springweb.product.dto.input.ProductInput;
import com.geraldapm.springweb.product.dto.output.ProductOutput;

import java.util.List;

public interface ProductService {
    ProductOutput getOne(Long id);

    List<ProductOutput> getAll();

    void addOne(ProductInput input);

    void deleteOne(Long id);
}
