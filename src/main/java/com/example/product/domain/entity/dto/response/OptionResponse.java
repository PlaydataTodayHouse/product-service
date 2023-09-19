package com.example.product.domain.entity.dto.response;

import com.example.product.domain.entity.OptionDetail;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class OptionResponse {

    private Long optionId;
    private String optionName;
    private Boolean isRequired;

    private List<OptionDetail> optionDetails;

}
