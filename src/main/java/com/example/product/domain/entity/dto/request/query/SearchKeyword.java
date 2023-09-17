package com.example.product.domain.entity.dto.request.query;

import lombok.Getter;

@Getter
public class SearchKeyword {

    private static final int KEYWORD_MIN_LENGTH = 1;
    private static final int KEYWORD_MAX_LENGTH = 30;

    private final String value;

    private SearchKeyword(String value) {
        this.value = value;
    }

    public static SearchKeyword of(String keyword) {
        return new SearchKeyword(keyword);
    }

}
