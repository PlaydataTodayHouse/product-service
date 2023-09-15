package com.example.product.domain.entity.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import java.util.List;

import static com.example.product.domain.entity.dto.ValidatorMessage.*;

@Getter
@NoArgsConstructor
public class ProductCreateRequest {

    @NotBlank(message = EMPTY_MESSAGE)
    private String category;

    @NotBlank(message = EMPTY_MESSAGE)
    @URL(message = INVALID_URL_MESSAGE)
    private String productImageUrl;

    @NotBlank(message = EMPTY_MESSAGE)
    @Length(max = MAX_PRODUCT_NAME_LENGTH, message = PRODUCT_NAME_LENGTH_MESSAGE)
    private String productName;

    @NotBlank(message = EMPTY_MESSAGE)
    private String productContent;

    @NotBlank(message = EMPTY_MESSAGE)
    private String company;

    @NotBlank(message = EMPTY_MESSAGE)
    private String companyRegistrationNumber;

    @NotBlank(message = EMPTY_MESSAGE)
    @Pattern(regexp = NUMBER_PATTERN, message = INVALID_NUM_PATTERN_MESSAGE)
    @Min(value = MIN_PRICE, message = PRICE_MESSAGE)
    private String originalPrice;

    @NotBlank(message = EMPTY_MESSAGE)
    @Pattern(regexp = NUMBER_PATTERN, message = INVALID_NUM_PATTERN_MESSAGE)
    @Min(value = MIN_QUANTITY, message = PRICE_MESSAGE)
    private String totalQuantity;

    @NotBlank(message = EMPTY_MESSAGE)
    private String deliveryType;

    @NotBlank(message = EMPTY_MESSAGE)
    private String brandId;

    List<OptionCreateRequest> options;

}
