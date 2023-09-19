package com.example.product.domain.entity.dto.response;

import com.example.product.domain.entity.OptionDetail;
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

    public static OptionDetailResponse of(OptionDetail optionDetail) {
        return new OptionDetailResponse(
                optionDetail.getId(),
                optionDetail.getOptionDetail(),
                optionDetail.getOptionPrice(),
                optionDetail.getQuantity(),
                optionDetail.getIsSoldOut()
        );
    }

}
