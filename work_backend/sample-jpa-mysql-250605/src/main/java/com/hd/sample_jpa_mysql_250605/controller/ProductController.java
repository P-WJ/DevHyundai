package com.hd.sample_jpa_mysql_250605.controller;

import com.hd.sample_jpa_mysql_250605.document.Product;
import com.hd.sample_jpa_mysql_250605.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public Product create(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getOne(@PathVariable String id) {
        return productService.findById(id)
                .map(ResponseEntity::ok) // 200번과 데이터 반환
                .orElse(ResponseEntity.notFound().build()); // 404 반환
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable String id, @RequestBody Product product) {
        return productService.update(id, product);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable String id) {
        productService.delete(id);
    }
}
