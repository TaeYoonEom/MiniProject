package com.ETYProject.Mini.Repository;

import com.ETYProject.Mini.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "select o from Order o Join fetch o.product", // Join Fetch를 사용하여 두 테이블 데이터 한번에 가져오기
            countQuery = "select count(o) from Order o") // 몇개 가져오는지 세는 쿼리
    Page<Order> findAllWithProduct(Pageable pageable);
}