package com.example.product.domain.entity.dto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ValidatorMessage {

    public static final String NUMBER_PATTERN = "^[1-9]+$";
    public static final int MIN_PRICE = 100;
    public static final int MIN_QUANTITY = 1;
    public static final int MAX_PRODUCT_NAME_LENGTH = 50;
    public static final int MAX_OPTION_NAME_LENGTH = 20;
    public static final int MAX_OPTION_DETAIL_LENGTH = 30;

    public static final String EMPTY_MESSAGE = "비어있는 항목을 입력해주세요.";
    public static final String INVALID_URL_MESSAGE = "유효하지 않은 URL입니다.";
    public static final String PRODUCT_NAME_LENGTH_MESSAGE = "상품명은 50자를 넘을 수 없습니다.";
    public static final String INVALID_NUM_PATTERN_MESSAGE = "가격은 숫자여야 합니다.";
    public static final String PRICE_MESSAGE = "가격은 100원 이상이어야 합니다.";
    public static final String OPTION_NAME_LENGTH_MESSAGE = "옵션명은 20자를 넘을 수 없습니다.";
    public static final String OPTION_DETAIL_LENGTH_MESSAGE = "옵션 상세명은 30자를 넘을 수 없습니다.";
    public static final String INVALID_QUANTITY_MESSAGE = "수량은 숫자여야 합니다.";
    public static final String QUANTITY_MESSAGE = "수량은 1개 이상이어야 합니다.";

}
