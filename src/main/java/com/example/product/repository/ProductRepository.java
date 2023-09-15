package com.example.product.repository;

import com.example.product.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // 카테고리별 상품 리스트: 최신순, 판매순, 인기순, 낮은 가격순, 높은 가격순, 많은 리뷰순, 평점 높은순

    // 상품 디테일

    // 상품 검색

}
