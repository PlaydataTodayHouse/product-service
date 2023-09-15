package com.example.product.config;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor @NoArgsConstructor
@Builder @Getter
public class TokenInfo {
    private UUID id;
    private String userId;
    private String name;
    private String phoneNumber;
    private String email;
    private LocalDate birth;
    private String role;
}
