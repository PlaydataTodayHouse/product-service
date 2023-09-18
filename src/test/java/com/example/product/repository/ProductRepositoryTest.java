package com.example.product.repository;

import com.example.product.RepositoryTest;
import com.example.product.domain.entity.Option;
import com.example.product.domain.entity.Product;
import com.example.product.domain.entity.dto.request.query.QueryParameter;
import org.hibernate.Hibernate;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.*;


class ProductRepositoryTest extends RepositoryTest {

    @Test
    void findProductsByCategoryAndOrderByCondition_orderBy_reviewCount_desc() {
        // given
        QueryParameter queryParameter = QueryParameter.of(
                "",
                "11000000",
                "REVIEW",
                "0",
                "20"
        );

        // when
        Page<Product> products = productRepository.findProductsByCategoryAndOrderByCondition(queryParameter.getCategory().getId(), queryParameter.getPageRequest());

        // then
        assertThat(products).isNotNull();

        // orderBy가 "REVIEW"인지 확인
        assertThat(Objects.requireNonNull(products.getSort().getOrderFor("reviewCount")).getProperty()).isEqualTo("reviewCount");
        assertThat(Objects.requireNonNull(products.getSort().getOrderFor("reviewCount")).getDirection()).isEqualTo(Sort.Direction.DESC);

        // fetch join을 사용하여 연관 관계 엔티티에 대한 추가 쿼리가 발생하지 않는지 확인
        assertThat(products.stream().allMatch(p -> p.getBrand() != null)).isTrue();
    }

    @Test
    void findProductsByCategoryAndOrderByCondition_orderBy_wishCount_desc() {
        // given
        QueryParameter queryParameter = QueryParameter.of(
                "",
                "11000000",
                "POPULAR",
                "0",
                "20"
        );

        // when
        Page<Product> products = productRepository.findProductsByCategoryAndOrderByCondition(queryParameter.getCategory().getId(), queryParameter.getPageRequest());

        // then
        assertThat(products).isNotNull();

        // orderBy가 "REVIEW"인지 확인
        assertThat(Objects.requireNonNull(products.getSort().getOrderFor("wishCount")).getProperty()).isEqualTo("wishCount");
        assertThat(Objects.requireNonNull(products.getSort().getOrderFor("wishCount")).getDirection()).isEqualTo(Sort.Direction.DESC);

        // fetch join을 사용하여 연관 관계 엔티티에 대한 추가 쿼리가 발생하지 않는지 확인
        assertThat(products.stream().allMatch(p -> p.getBrand() != null)).isTrue();
    }

    @Test
    void findProductsByCategoryAndOrderByCondition_orderBy_reviewAvg_desc() {
        // given
        QueryParameter queryParameter = QueryParameter.of(
                "",
                "11000000",
                "REVIEW_AVG",
                "0",
                "20"
        );

        // when
        Page<Product> products = productRepository.findProductsByCategoryAndOrderByCondition(queryParameter.getCategory().getId(), queryParameter.getPageRequest());

        // then
        assertThat(products).isNotNull();

        // orderBy가 "REVIEW"인지 확인
        assertThat(Objects.requireNonNull(products.getSort().getOrderFor("reviewAvg")).getProperty()).isEqualTo("reviewAvg");
        assertThat(Objects.requireNonNull(products.getSort().getOrderFor("reviewAvg")).getDirection()).isEqualTo(Sort.Direction.DESC);

        // fetch join을 사용하여 연관 관계 엔티티에 대한 추가 쿼리가 발생하지 않는지 확인
        assertThat(products.stream().allMatch(p -> p.getBrand() != null)).isTrue();
    }

    @Test
    void findProductsByCategoryAndOrderByCondition_orderBy_createdAt_desc() {
        // given
        QueryParameter queryParameter = QueryParameter.of(
                "",
                "11000000",
                "RECENT",
                "0",
                "20"
        );

        // when
        Page<Product> products = productRepository.findProductsByCategoryAndOrderByCondition(queryParameter.getCategory().getId(), queryParameter.getPageRequest());

        // then
        assertThat(products).isNotNull();

        // orderBy가 "REVIEW"인지 확인
        assertThat(Objects.requireNonNull(products.getSort().getOrderFor("createdAt")).getProperty()).isEqualTo("createdAt");
        assertThat(Objects.requireNonNull(products.getSort().getOrderFor("createdAt")).getDirection()).isEqualTo(Sort.Direction.DESC);

        // fetch join을 사용하여 연관 관계 엔티티에 대한 추가 쿼리가 발생하지 않는지 확인
        assertThat(products.stream().allMatch(p -> p.getBrand() != null)).isTrue();
    }

    @Test
    void findProductById() {
        // given
        Long productId = 1L;

        // when
        Product product = productRepository.findProductById(productId);

        // then
        assertThat(product).isNotNull();
        assertThat(product.getBrand()).isNotNull();
        assertThat(product.getOptions()).isNotNull();

        assertThat(Hibernate.isInitialized(product.getBrand())).isTrue();
        assertThat(Hibernate.isInitialized(product.getOptions())).isTrue();

        System.out.println("==================");
        System.out.println(product.getId());
        System.out.println(product.getBrand().getId());
        List<Option> options = product.getOptions();
        System.out.println(options.size());
        System.out.println("==================");
    }

}