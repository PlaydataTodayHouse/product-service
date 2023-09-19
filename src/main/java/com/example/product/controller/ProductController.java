package com.example.product.controller;

import com.example.product.auth.UserTokenInfo;
import com.example.product.config.TokenInfo;
import com.example.product.domain.entity.dto.request.product.ProductCreateRequest;
import com.example.product.domain.entity.dto.request.query.QueryParameter;
import com.example.product.domain.entity.dto.request.query.QueryParams;
import com.example.product.domain.entity.dto.response.ProductResponses;
import com.example.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
@Validated
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public void save(
            @Valid @RequestBody ProductCreateRequest request,
            @UserTokenInfo TokenInfo tokenInfo
    ) {
        productService.save(request, tokenInfo);
    }

    @GetMapping
    public ResponseEntity<ProductResponses> products(
            @QueryParams QueryParameter queryParameter,
            @UserTokenInfo TokenInfo tokenInfo
    ) {
        return ResponseEntity.ok(productService.products(queryParameter, tokenInfo));
    }

}
