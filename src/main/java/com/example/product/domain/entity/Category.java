package com.example.product.domain.entity;

import com.example.product.exception.InvalidCategoryException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum Category {

    // 범위 검색할때 유용하게 사용 가능
    ELECTRONICS("10000000", "전자제품"),
    TV("11000000", "TV"),
    REFRIGERATOR("12000000", "냉장고"),
    COMPUTER("13000000", "컴퓨터"),

    FURNITURE("20000000", "가구"),
    BED("21000000", "침대"),
    CHAIR("22000000", "의자"),
    SOFA("23000000", "소파"),

    FABRIC("30000000", "패브릭"),
    BLANKET("31000000", "이불"),
    PILLOW("32000000", "배게"),
    CURTAIN("33000000", "커튼");

    private final String id;
    private final String name;

    public static Category of(String id) {
        return Arrays.stream(values())
                .filter(category -> category.getId().equals(id))
                .findFirst()
                .orElseThrow(InvalidCategoryException::new);
    }

}