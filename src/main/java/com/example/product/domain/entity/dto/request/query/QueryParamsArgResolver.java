package com.example.product.domain.entity.dto.request.query;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class QueryParamsArgResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(QueryParams.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest nativeRequest = webRequest.getNativeRequest(HttpServletRequest.class);

        Map<String, String> parameterMap = new HashMap<>();

        // keyword, category_id, start, size
        Enumeration<String> parameterNames = nativeRequest.getParameterNames();

        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            parameterMap.put(name, nativeRequest.getParameter(name));
        }

        return QueryParameter.of(
                parameterMap.getOrDefault("keyword", ""),
                parameterMap.getOrDefault("category_id", null),
                parameterMap.getOrDefault("order", "POPULAR"),
                parameterMap.getOrDefault("start", null),
                parameterMap.getOrDefault("size", null)
        );
    }

}
