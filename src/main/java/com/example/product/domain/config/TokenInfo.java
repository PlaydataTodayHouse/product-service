package com.example.product.domain.config;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
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
