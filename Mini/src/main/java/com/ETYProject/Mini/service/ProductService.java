package com.ETYProject.Mini.service;

import com.ETYProject.Mini.Repository.ProductRepository;
import com.ETYProject.Mini.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product createProduct(String name, Long price, Long stock){
        Product product = new Product(name, price, stock);
        return productRepository.save(product);
    }

    public Product findProductById(Long id){
        return productRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("상품이 없습니다."));
    }

    public List<Product> findAllProduct(){
        return productRepository.findAll();
    }

    public Product updateProduct(Long id, String name, Long price, Long stock){
        Product product = productRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("수정하려는 상품이 없습니다."));

        product.setName(name);
        product.setPrice(price);
        product.setStock(stock);

        return product;
    }

    public Product deleteProduct(Long id){
        Product product = productRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("삭제하려는 상품이 없습니다."));

        productRepository.deleteById(id);
        return product;
    }

}
