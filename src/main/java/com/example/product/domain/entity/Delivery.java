package com.example.product.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum Delivery {

    EXPRESS("express", 2500, "평균 1일 이내 배송"),
    NORMAL("normal", 0, "평균 2~3일 이내 배송");

    private final String type;
    private final Integer fee;
    private final String deliveryPeriod;

    public static Delivery of(String type) {
        return Arrays.stream(values())
                .filter(delivery -> delivery.getType().equals(type.toLowerCase()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 배송 타입이 존재하지 않습니다."));
    }

}
