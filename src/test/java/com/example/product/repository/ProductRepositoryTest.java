package com.example.product.repository;

import com.example.product.RepositoryTest;
import com.example.product.domain.entity.Product;
import com.example.product.domain.entity.dto.request.query.QueryParameter;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

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

}