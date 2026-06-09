package com.ETYProject.Mini.Repository;

import com.ETYProject.Mini.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
