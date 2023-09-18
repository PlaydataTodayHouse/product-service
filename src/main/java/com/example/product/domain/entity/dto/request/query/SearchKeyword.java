package com.example.product.domain.entity.dto.request.query;

import com.example.product.exception.LongSearchKeywordException;
import lombok.Getter;

@Getter
public class SearchKeyword {

    private static final int KEYWORD_MAX_LENGTH = 30;

    private final String value;

    private SearchKeyword(String value) {
        this.value = value;
    }

    public static SearchKeyword of(String keyword) {
        validateLength(keyword);
        return new SearchKeyword(keyword);
    }

    private static void validateLength(String keyword) {
        if (keyword.length() > KEYWORD_MAX_LENGTH) {
            throw new LongSearchKeywordException();
        }
    }

}
