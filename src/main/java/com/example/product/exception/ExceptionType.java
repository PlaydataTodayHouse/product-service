package com.example.product.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum ExceptionType {

    UNKNOWN_EXCEPTION("000", "알 수 없는 서버 에러"),
    INVALID_CATEGORY_EXCEPTION("001", "유효하지 않은 카테고리입니다.", InvalidCategoryException.class),
    INVALID_PAGE_START_EXCEPTION("002", "유효하지 않은 시작 페이지 입니다.", InvalidPageStartException.class),
    INVALID_PAGE_SIZE_EXCEPTION("003", "유효하지 않은 페이지 크기 입니다.", InvalidPageSizeException.class),
    INVALID_ORDER_BY_EXCEPTION("004", "유효하지 않은 정렬 기준입니다.", InvalidOrderTypeException.class),
    LONG_SEARCH_KEYWORD_EXCEPTION("005", "검색어는 30글자 이하로 입력해주세요.", LongSearchKeywordException.class),
    BRAND_NOT_FOUND_EXCEPTION("006", "존재하지 않는 브랜드입니다.", NoSuchBrandFoundException.class),
    ;

    private final String errorCode;
    private final String errorMessage;
    private Class<? extends ProductException> type;

    ExceptionType(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public static ExceptionType of(Class<?> classType) {
        return Arrays.stream(values())
                .filter(eType -> Objects.nonNull(eType.type) && eType.type.equals(classType))
                .findFirst()
                .orElse(UNKNOWN_EXCEPTION);
    }

}
