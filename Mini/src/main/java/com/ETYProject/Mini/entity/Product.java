package com.ETYProject.Mini.entity;
// Entity -> Repository -> Service -> Controller
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// 엔티티에 @Setter를 추가해서 좀 쉽게 수정을 하도록 구현했는데,
// 엔터티티를 무분별하게 열어두면 데이터 오염 위험이 있어
// 실무에서는 지양한다고 하는데 Setter을 계속 사용해도 무관할까요?

@Entity
@Getter
@Setter
@Table(name="product")
@NoArgsConstructor
public class Product extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Long price;

    @Column(name = "stock", nullable = false)
    private Long stock = 0L;

    public Product(String name, Long price, Long stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

}
