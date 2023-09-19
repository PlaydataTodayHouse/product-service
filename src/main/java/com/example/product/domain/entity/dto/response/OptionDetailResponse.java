package com.example.product.domain.entity.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class OptionDetailResponse {

    private Long optionDetailId;
    private String optionDetail;
    private Integer optionPrice;
    private Integer quantity;
    private Boolean isSoldOut;

}
