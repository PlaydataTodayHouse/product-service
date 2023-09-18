package com.example.product.controller;

import com.example.product.auth.UserTokenInfo;
import com.example.product.config.TokenInfo;
import com.example.product.domain.entity.dto.request.product.ProductCreateRequest;
import com.example.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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

}
