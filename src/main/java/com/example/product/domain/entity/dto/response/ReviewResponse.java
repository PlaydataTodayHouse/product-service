package com.example.product.domain.entity.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewResponse {

    private Long reviewId;
    private String reviewContent;
    private String reviewImageUrl;
    private String productOptionName;
    private Integer starGrade;
    private LocalDateTime createdAt;

}
