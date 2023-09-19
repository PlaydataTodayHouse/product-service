package com.example.product.domain.entity.dto.response;

import com.example.product.domain.entity.Review;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ReviewResponse {

    private Long reviewId;
    private String reviewContent;
    private String reviewImageUrl;
    private String productOptionName;
    private Integer starGrade;
    private LocalDateTime createdAt;

    public static ReviewResponse of(Review review) {
        return new ReviewResponse(
                review.getId(),
                review.getReviewContent(),
                review.getReviewImageUrl(),
                review.getProductOptionName(),
                review.getStarGrade(),
                review.getCreatedAt()
        );
    }

}
