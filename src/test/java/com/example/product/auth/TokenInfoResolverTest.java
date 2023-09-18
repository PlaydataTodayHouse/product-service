package com.example.product.auth;

import com.example.product.config.JwtService;
import com.example.product.config.TokenInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.context.request.ServletWebRequest;

import java.time.LocalDate;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class TokenInfoResolverTest {

    private TokenInfoResolver tokenInfoResolver;
    private JwtService jwtService;

    @BeforeEach
    void setUp() {
        jwtService = mock(JwtService.class);
        tokenInfoResolver = new TokenInfoResolver(jwtService);
    }

    @Test
    void resolveArgument_ValidToken_ReturnsUserTokenInfo() throws Exception {
        // given
        String validToken = "valid_token_here"; // 유효한 JWT 토큰
        TokenInfo expectedTokenInfo = TokenInfo.builder()
                .id(UUID.randomUUID())
                .userId("user123")
                .name("John Doe")
                .phoneNumber("123-456-7890")
                .email("john@example.com")
                .birth(LocalDate.of(1990, 1, 1))
                .role("USER")
                .build();

        // when
        // Mock JWT 토큰 파싱 로직
        when(jwtService.parseToken(validToken)).thenReturn(expectedTokenInfo);

        // Mock HTTP 요청 및 응답 객체 생성
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        // 헤더에 유효한 JWT 토큰 설정
        request.addHeader("Authorization", "Bearer " + validToken);

        // ServletWebRequest 객체 생성
        ServletWebRequest webRequest = new ServletWebRequest(request, response);

        TokenInfo resolvedTokenInfo = (TokenInfo) tokenInfoResolver.resolveArgument(
                null, null, webRequest, null);

        // then
        assertThat(resolvedTokenInfo).isNotNull();
        assertThat(resolvedTokenInfo.getId()).isEqualTo(expectedTokenInfo.getId());
        assertThat(resolvedTokenInfo.getUserId()).isEqualTo(expectedTokenInfo.getUserId());
        assertThat(resolvedTokenInfo.getName()).isEqualTo(expectedTokenInfo.getName());
        assertThat(resolvedTokenInfo.getPhoneNumber()).isEqualTo(expectedTokenInfo.getPhoneNumber());
        assertThat(resolvedTokenInfo.getEmail()).isEqualTo(expectedTokenInfo.getEmail());
        assertThat(resolvedTokenInfo.getBirth()).isEqualTo(expectedTokenInfo.getBirth());
        assertThat(resolvedTokenInfo.getRole()).isEqualTo(expectedTokenInfo.getRole());
    }

}