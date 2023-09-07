package com.example.product.domain.entity;

import com.example.product.domain.enums.ParentCategory;
import com.example.product.domain.enums.ChildCategory;
import com.example.product.exception.InvalidCategoryException;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoryId;
    private String name;
    private String brand;
    private String defaultColor;
    private String deliveryType;
    private double deliveryFee;
    private int likesCount;
    private String descriptionPost;
    private int quantity;
    private String productImages;


    // 차후 service에서 물건등록 메소드가 생기면 최종적으로 setCategory 메소드를 불러서 categoryId로 넣어줘야함.
    public void setCategory(ParentCategory parentCategory, ChildCategory childCategory) {
        if (childCategory.getParentCategory() != parentCategory) {
            throw new InvalidCategoryException("카테고리가 일치하지 않습니다");
        }
        this.categoryId = parentCategory.getCode() + childCategory.getCode();
    }

}