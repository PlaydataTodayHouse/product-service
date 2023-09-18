package com.example.product.repository;

import com.example.product.domain.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Map;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // 카테고리, 베스트(실시간, 역대), 오늘의 딜(할인율 순)

    // 카테고리별 상품 리스트: 최신순, 판매순(salesCount), 인기순(wishCount), 낮은 가격순, 높은 가격순, 많은 리뷰순(viewCount), 평점 높은순(reviewAvg) - (메인 화면)
    @Query("select p from Product p " +
            "left join fetch p.brand b " +
            "where p.categoryId = :category_id")
    Page<Product> findProductsByCategoryAndOrderByCondition(@Param("category_id") String categoryId, Pageable pageable);

    // 상품 디테일
    @Query(value = "select p.id, " +
            "group_concat(distinct p.category_id) as category_ids, " +
            "group_concat(distinct p.product_image_url) as product_image_urls, " +
            "group_concat(distinct p.product_name) as product_names, " +
            "group_concat(distinct p.product_content) as product_contents, " +
            "group_concat(distinct p.original_price) as original_prices, " +
            "group_concat(distinct p.discount_rate) as discount_rates, " +
            "group_concat(distinct p.review_avg) as review_avgs, " +
            "group_concat(distinct p.review_count) as review_counts, " +
            "group_concat(distinct p.sales_count) as sales_counts, " +
            "group_concat(distinct p.total_quantity) as total_quantities, " +
            "group_concat(distinct p.wish_count) as wish_counts, " +
            "group_concat(distinct p.company) as companies, " +
            "group_concat(distinct p.company_registration_number) as company_registration_numbers, " +
            "group_concat(distinct p.delivery) as deliveries, " +
            "group_concat(distinct p.is_selling) as is_sellings, " +
            "group_concat(distinct p.is_sold_out) as is_sold_outs, " +
            "group_concat(distinct p.created_at) as created_ats, " +
            "group_concat(distinct b.id) as brand_ids, " +
            "group_concat(distinct b.brand_name) as brand_names, " +
            "group_concat(distinct o.id) as option_ids, " +
            "group_concat(distinct o.option_name) as option_names, " +
            "group_concat(distinct o.is_required) as option_required, " +
            "group_concat(distinct od.id) as option_detail_ids, " +
            "group_concat(distinct od.option_detail) as option_details, " +
            "group_concat(distinct od.option_price) as option_prices, " +
            "group_concat(distinct od.quantity) as option_quantities, " +
            "group_concat(distinct od.is_sold_out) as option_sold_outs, " +
            "group_concat(distinct r.id) as review_ids, " +
            "group_concat(distinct r.review_content) as review_contents, " +
            "group_concat(distinct r.review_image_url) as review_image_urls, " +
            "group_concat(distinct r.product_option_name) as review_product_option_names, " +
            "group_concat(distinct r.star_grade) as review_star_grades, " +
            "group_concat(distinct r.created_at) as review_created_ats " +
            "from products p " +
            "left join brands b on p.brand_id = b.id " +
            "left join options o on p.id = o.product_id " +
            "left join option_details od on o.id = od.option_id " +
            "left join reviews r on p.id = r.product_id " +
            "where p.id = :product_id " +
            "group by p.id", nativeQuery = true)
    Map<String, String> findProductBrandOptionsById(@Param("product_id") Long productId);

    // 상품 검색

}
