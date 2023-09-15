package com.example.product.domain.entity.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.List;

import static com.example.product.domain.entity.dto.ValidatorMessage.*;

@Getter
@NoArgsConstructor
public class OptionCreateRequest {

    @NotBlank(message = EMPTY_MESSAGE)
    @Length(max = MAX_OPTION_NAME_LENGTH, message = OPTION_NAME_LENGTH_MESSAGE)
    private String optionName;

    @NotBlank(message = EMPTY_MESSAGE)
    private Boolean isRequired;

    private List<OptionDetailCreateRequest> optionDetails;

}
