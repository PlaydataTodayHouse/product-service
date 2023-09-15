package com.example.product.domain.entity.dto.request;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import static com.example.product.domain.entity.dto.ValidatorMessage.*;

@Getter
@NoArgsConstructor
public class BrandCreateRequest {

    @NotBlank(message = EMPTY_MESSAGE)
    @URL(message = INVALID_URL_MESSAGE)
    private String brandImageUrl;

    @NotBlank(message = EMPTY_MESSAGE)
    @Length(max = MAX_BRAND_NAME_LENGTH, message = BRAND_NAME_LENGTH_MESSAGE)
    private String brandName;

    @NotBlank(message = EMPTY_MESSAGE)
    @Length(max = MAX_BRAND_INTRODUCTION_LENGTH, message = BRAND_INTRODUCTION_LENGTH_MESSAGE)
    private String brandIntroduction;

}
