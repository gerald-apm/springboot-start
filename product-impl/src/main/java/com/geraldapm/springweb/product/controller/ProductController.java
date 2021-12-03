package com.geraldapm.springweb.product.controller;

import com.geraldapm.springweb.base.controller.BaseController;
import com.geraldapm.springweb.base.dto.BaseResponse;
import com.geraldapm.springweb.product.dto.input.ProductInput;
import com.geraldapm.springweb.product.dto.output.ProductOutput;
import com.geraldapm.springweb.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import javax.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController extends BaseController {

    @Autowired
    @Qualifier("productServiceImpl")
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<ProductOutput>> getOne(@PathVariable Long id) {
        ProductOutput output = productService.getOne(id);
        return ResponseEntity.ok(new BaseResponse<>(output));
    }

    @GetMapping
    public ResponseEntity<List<ProductOutput>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }

    @PostMapping
    public ResponseEntity<BaseResponse<Boolean>> addOne(@Valid @RequestBody ProductInput input) {
        productService.addOne(input);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteOne(@PathVariable Long id) {
        return ResponseEntity.ok(Boolean.TRUE); // TODO
    }
}
