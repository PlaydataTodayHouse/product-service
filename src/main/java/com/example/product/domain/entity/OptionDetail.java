package com.example.product.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "option_details")
public class OptionDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "option_detail", nullable = false, length = 30)
    private String optionDetail;

    @Column(name = "option_price")
    private Integer optionPrice;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "is_sold_out")
    @Builder.Default
    private Boolean isSoldOut = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "option_id", foreignKey = @ForeignKey(name = "fk_option_detail_option"), nullable = false)
    private Option option;

}
