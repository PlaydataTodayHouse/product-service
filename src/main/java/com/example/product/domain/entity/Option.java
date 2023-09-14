package com.example.product.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "options")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "option_name", nullable = false, length = 20)
    private String optionName;

    @Column(name = "is_required")
    private Boolean isRequired;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "fk_option_product"), nullable = false)
    private Product product;

    @Embedded
    @Builder.Default
    private OptionDetails optionDetails = new OptionDetails();

}