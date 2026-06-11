package com.ETYProject.Mini.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Entity -> Repository -> Service -> Controller
@Entity
@Getter
@Setter
@Table(name = "orders")
@NoArgsConstructor
public class Order extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name="orderCount", nullable = false)
    private Long orderCount;
}
