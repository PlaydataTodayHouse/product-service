package com.example.product.service;

import com.example.product.config.TokenInfo;
import com.example.product.domain.entity.Brand;
import com.example.product.domain.entity.Category;
import com.example.product.domain.entity.Delivery;
import com.example.product.domain.entity.Product;
import com.example.product.domain.entity.dto.request.product.ProductCreateRequest;
import com.example.product.domain.entity.dto.request.query.QueryParameter;
import com.example.product.domain.entity.dto.response.ProductResponses;
import com.example.product.exception.NoSuchBrandFoundException;
import com.example.product.repository.BrandRepository;
import com.example.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;

    @Transactional
    public void save(ProductCreateRequest request, TokenInfo tokenInfo) {
        Brand brand = validateBrand(request);

        Product product = Product.builder()
                .categoryId(Category.of(request.getCategory()).getId())
                .productImageUrl(request.getProductImageUrl())
                .productName(request.getProductName())
                .productContent(request.getProductContent())
                .company(request.getCompany())
                .companyRegistrationNumber(request.getCompanyRegistrationNumber())
                .originalPrice(Integer.parseInt(request.getOriginalPrice()))
                .totalQuantity(Integer.parseInt(request.getTotalQuantity()))
                .delivery(Delivery.of(request.getDeliveryType()))
                .brand(brand)
                .build();

        productRepository.save(product);
    }

    public ProductResponses products(QueryParameter queryParameter, TokenInfo tokenInfo) {
        String categoryId = queryParameter.getCategory().getId();
        PageRequest pageRequest = queryParameter.getPageRequest();

        Page<Product> products = productRepository.findProductsByCategoryAndOrderByCondition(categoryId, pageRequest);

        return ProductResponses.of(products);
    }

    private Brand validateBrand(ProductCreateRequest request) {
        return brandRepository.findById(request.getBrandId())
                .orElseThrow(NoSuchBrandFoundException::new);
    }
}
