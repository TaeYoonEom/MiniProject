package com.ETYProject.Mini.service;

import com.ETYProject.Mini.Repository.OrderRepository;
import com.ETYProject.Mini.Repository.ProductRepository;
import com.ETYProject.Mini.entity.Order;
import com.ETYProject.Mini.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository){
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public Order createOrder(Long product_id, Long orderCount){
        Product product = productRepository.findById(product_id).orElseThrow(()
                -> new IllegalArgumentException("구매하고자 하는 상품이 없습니다."));

        if(product.getStock() < orderCount){
            throw new IllegalArgumentException("현재 상품재고 수량보다 주문 수량이 더 많습니다.");
        }
        Order order = new Order();
        // Order order = new Order(product, orderCount) // @Setter을 안썼다면 이렇게 대입
        order.setProduct(product);
        order.setOrderCount(orderCount);

        product.setStock(product.getStock() - orderCount);

        return orderRepository.save(order);
    }

    public Order getOrder(Long id){
        return orderRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("해당 주문을 조회할 수 없습니다."));
    }
}
