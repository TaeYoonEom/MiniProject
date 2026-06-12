package com.ETYProject.Mini.Repository;

import com.ETYProject.Mini.entity.Product;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface ProductRepository extends JpaRepository<Product, Long> {
    // @Lock: 동시에 여러 요청이 들어와도 한 번에 한 명만 수정할 수 있도록 데이터 잠금 (동시성 이슈 해결)
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query(value = "select p from Product p where p.id = :id")
    Optional<Product> findWithLockById(@Param("id") Long id);
}