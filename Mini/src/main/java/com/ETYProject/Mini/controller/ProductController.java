package com.ETYProject.Mini.controller;

import com.ETYProject.Mini.entity.Product;
import com.ETYProject.Mini.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// ★ /{id}를 할때는 @PathVariable을 사용해야한다!!!
// 기본은 @RequestParam
@RestController
@RequestMapping("/api")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestParam String name, @RequestParam Long price, @RequestParam Long stock){
        return productService.createProduct(name, price, stock);
    }

    @GetMapping("/products")
    public List<Product> getAllProduct(){
        return productService.findAllProduct();
    }

    @GetMapping("/products/{id}")
    public Product findProductById(@PathVariable Long id){
        return productService.findProductById(id);
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestParam String name, @RequestParam Long price, @RequestParam Long stock){
        return productService.updateProduct(id, name, price, stock);
    }

    @DeleteMapping("/products/{id}")
    public Product deleteProduct(@PathVariable Long id){
        return productService.deleteProduct(id);
    }
}
