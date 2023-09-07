package com.example.product.domain.enums;

import com.example.product.domain.enums.ParentCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ChildCategory {
    TV(ParentCategory.ELECTRONICS, "1001", "TV"),
    REFRIGERATOR(ParentCategory.ELECTRONICS, "1002", "냉장고"),
    COMPUTER(ParentCategory.ELECTRONICS, "1003", "컴퓨터"),
    BED(ParentCategory.FURNITURE, "2001", "침대"),
    CHAIR(ParentCategory.FURNITURE, "2002", "의자"),
    SOFA(ParentCategory.FURNITURE, "2003", "소파"),
    BLANKET(ParentCategory.FABRIC, "3001", "이불"),
    PILLOW(ParentCategory.FABRIC, "3002", "배게"),
    CURTAIN(ParentCategory.FABRIC, "3003", "커튼");

    private final ParentCategory parentCategory;
    private final String code;
    private final String description;
}