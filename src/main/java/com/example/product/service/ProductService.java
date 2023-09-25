package com.example.product.service;

import com.example.product.config.TokenInfo;
import com.example.product.domain.entity.*;
import com.example.product.domain.entity.dto.request.product.ProductCreateRequest;
import com.example.product.domain.entity.dto.response.ProductResponse;
import com.example.product.domain.entity.dto.request.query.QueryParameter;
import com.example.product.domain.entity.dto.response.ProductDetailResponse;
import com.example.product.domain.entity.dto.response.ProductResponses;
import com.example.product.exception.NoSuchBrandFoundException;
import com.example.product.exception.NoSuchProductFoundException;
import com.example.product.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    private final OptionRepository optionRepository;
    private final OptionDetailRepository optionDetailRepository;
    private final ReviewRepository reviewRepository;

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

    public ProductDetailResponse productDetail(Long productId, TokenInfo tokenInfo) {
        Product product = productRepository.findProductById(productId)
                .orElseThrow(NoSuchProductFoundException::new);

        List<Review> reviews = reviewRepository.findByProductId(product.getId());

        return ProductDetailResponse.of(product, reviews);
    }

    private static List<Long> extractOptionIds(Product product) {
        return product.getOptions().stream()
                .map(Option::getId)
                .toList();
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
