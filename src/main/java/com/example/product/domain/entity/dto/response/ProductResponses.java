package com.example.product.domain.entity.dto.response;

import com.example.product.domain.entity.Product;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ProductResponses {

    private List<ProductResponse> products;
    private PageInfo pageInfo;

    public static ProductResponses of(Page<Product> products) {
        List<Product> content = products.getContent();

        List<ProductResponse> productResponses = content.stream()
                .map(ProductResponse::of)
                .toList();

        return new ProductResponses(productResponses, PageInfo.of(products));
    }

}
