package com.geraldapm.springweb.product.service;

import com.geraldapm.springweb.product.data.Product;
import com.geraldapm.springweb.product.dto.input.ProductInput;
import com.geraldapm.springweb.product.dto.output.ProductOutput;
import com.geraldapm.springweb.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.IterableUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    //private CategoryService categoryService;

    @Autowired
    private ModelMapper mapper;

    @Override
    public ProductOutput getOne(Long id) {
        Optional<Product> product = repository.findById(id);
        if (product.isEmpty()) {
            return null;
        }
        Product temp = product.get();
        return mapper.map(temp, ProductOutput.class);
    }

    @Override
    public List<ProductOutput> getAll() {
        Iterable<Product> products = repository.findAll();
        List<Product> productList = IterableUtils.toList(products);

        List<ProductOutput> outputs = new ArrayList<>();
        for (Product product: productList) {
            outputs.add(mapper.map(product, ProductOutput.class));
        }

        return outputs;
    }

    @Override
    public void addOne(ProductInput input) {
        Product product = mapper.map(input, Product.class);
        this.repository.save(product);
    }

    @Override
    public void deleteOne(Long id) {
        // TODO impl
    }
}
