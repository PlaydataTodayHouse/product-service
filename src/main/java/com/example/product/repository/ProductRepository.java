package com.example.product.repository;

import com.example.product.domain.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // 카테고리, 베스트(실시간, 역대), 오늘의 딜(할인율 순)

    // 카테고리별 상품 리스트: 최신순, 판매순(salesCount), 인기순(wishCount), 낮은 가격순, 높은 가격순, 많은 리뷰순(viewCount), 평점 높은순(reviewAvg) - (메인 화면)
    @Query("select p from Product p " +
            "left join fetch p.brand b " +
            "where p.categoryId = :category_id")
    Page<Product> findProductsByCategoryAndOrderByCondition(@Param("category_id") String categoryId, Pageable pageable);

    // 상품 디테일
//    @Query("select p from Product p " +
//            "left join fetch p.brand b " +
//            "left join fetch p.options o " +
//            "left join fetch o.optionDetails od " +
//            "where p.id = :product_id")
//    Product findProductBrandOptionsById(@Param("product_id") Long productId);

    // 상품 검색

}
