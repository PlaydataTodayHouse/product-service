package com.example.product.domain.entity.dto.request.option;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import static com.example.product.domain.entity.dto.ValidatorMessage.*;

@Getter
@NoArgsConstructor
public class OptionDetailCreateRequest {

    @NotBlank(message = EMPTY_MESSAGE)
    @Length(max = MAX_OPTION_DETAIL_LENGTH, message = OPTION_DETAIL_LENGTH_MESSAGE)
    private String optionDetail;

    @NotBlank(message = EMPTY_MESSAGE)
    @Pattern(regexp = NUMBER_PATTERN, message = INVALID_NUM_PATTERN_MESSAGE)
    @Min(value = MIN_PRICE, message = PRICE_MESSAGE)
    private Integer optionPrice;

    @NotBlank(message = EMPTY_MESSAGE)
    @Pattern(regexp = NUMBER_PATTERN, message = INVALID_QUANTITY_MESSAGE)
    @Min(value = MIN_QUANTITY, message = QUANTITY_MESSAGE)
    private Integer quantity;

}
