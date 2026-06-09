package com.ETYProject.Mini.Repository;

import com.ETYProject.Mini.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
