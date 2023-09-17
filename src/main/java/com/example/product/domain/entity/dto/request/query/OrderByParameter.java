package com.example.product.domain.entity.dto.request.query;

import com.example.product.exception.InvalidOrderTypeException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum OrderByParameter {

    POPULAR("wishCount", "인기순"),
    REVIEW("reviewCount", "리뷰순"),
    SALES_COUNT("salesCount", "판매순"),
    REVIEW_AVG("reviewAvg", "평점순"),
    RECENT("createdAt", "최신순"),
    MIN_PRICE("originalPrice", "낮은 가격순"),
    MAX_PRICE("originalPrice", "높은 가격순");

    private final String orderBy;
    private final String description;

    public static OrderByParameter of(String value) {;
        return Arrays.stream(OrderByParameter.values())
                .filter(orderByParameter -> orderByParameter.name().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(InvalidOrderTypeException::new);
    }

}
