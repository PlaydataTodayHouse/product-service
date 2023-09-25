package com.example.product.service;

import com.example.product.config.TokenInfo;
import com.example.product.domain.entity.Brand;
import com.example.product.domain.entity.Category;
import com.example.product.domain.entity.Delivery;
import com.example.product.domain.entity.Product;
import com.example.product.domain.entity.dto.request.product.ProductCreateRequest;
import com.example.product.domain.entity.dto.response.ProductResponse;
import com.example.product.exception.NoSuchBrandFoundException;
import com.example.product.repository.BrandRepository;
import com.example.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    private Brand validateBrand(ProductCreateRequest request) {
        return brandRepository.findById(request.getBrandId())
                .orElseThrow(NoSuchBrandFoundException::new);
    }

    public List<ProductResponse> findAllProducts() {
        return productRepository.findAll().stream()
                .map(product -> ProductResponse.builder()
                        .id(product.getId())
                        .categoryId(product.getCategoryId())
                        .productImageUrl(product.getProductImageUrl())
                        .productName(product.getProductName())
                        .productContent(product.getProductContent())
                        .company(product.getCompany())
                        .companyRegistrationNumber(product.getCompanyRegistrationNumber())
                        .originalPrice(product.getOriginalPrice())
                        .discountRate(product.getDiscountRate())
                        .totalQuantity(product.getTotalQuantity())
                        .salesCount(product.getSalesCount())
                        .wishCount(product.getWishCount())
                        .viewCount(product.getViewCount())
                        .reviewAvg(product.getReviewAvg())
                        .reviewCount(product.getReviewCount())
                        .isSoldOut(product.getIsSoldOut())
                        .isSelling(product.getIsSelling())
                        .deliveryType(product.getDelivery().name())
                        .brandId(product.getBrand().getId())
                        .build())
                .collect(Collectors.toList());
    }


    public ProductResponse findProductById(Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        Product product = optionalProduct.orElse(null);


        return ProductResponse.builder()
                .id(product.getId())
                .categoryId(product.getCategoryId())
                .productImageUrl(product.getProductImageUrl())
                .productName(product.getProductName())
                .productContent(product.getProductContent())
                .company(product.getCompany())
                .companyRegistrationNumber(product.getCompanyRegistrationNumber())
                .originalPrice(product.getOriginalPrice())
                .discountRate(product.getDiscountRate())
                .totalQuantity(product.getTotalQuantity())
                .salesCount(product.getSalesCount())
                .wishCount(product.getWishCount())
                .viewCount(product.getViewCount())
                .reviewAvg(product.getReviewAvg())
                .reviewCount(product.getReviewCount())
                .isSoldOut(product.getIsSoldOut())
                .isSelling(product.getIsSelling())
                .deliveryType(product.getDelivery().name())
                .brandId(product.getBrand().getId())
                .build();
    }

}
