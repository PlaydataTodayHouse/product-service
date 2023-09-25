package com.example.product.controller;

import com.example.product.auth.UserTokenInfo;
import com.example.product.config.TokenInfo;
import com.example.product.domain.entity.Product;
import com.example.product.domain.entity.dto.request.product.ProductCreateRequest;
import com.example.product.domain.entity.dto.response.ProductResponse;
import com.example.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @GetMapping("/allProduct")
    public ResponseEntity<List<ProductResponse>> findAllProduct() {
        List<ProductResponse> productResponses = productService.findAllProducts();
        return ResponseEntity.ok(productResponses);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> findProductById(@PathVariable Long productId) {
        ProductResponse productResponse = productService.findProductById(productId);
        return ResponseEntity.ok(productResponse);
    }
}
