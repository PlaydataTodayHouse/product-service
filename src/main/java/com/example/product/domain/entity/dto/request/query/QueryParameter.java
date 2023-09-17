package com.example.product.domain.entity.dto.request.query;

import com.example.product.domain.entity.Category;
import com.example.product.exception.InvalidPageSizeException;
import com.example.product.exception.InvalidPageStartException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class QueryParameter {

    private static final int MIN_START_PAGE = 0;
    private static final int MIN_PAGE_SIZE = 20;
    private static final int MAX_PAGE_SIZE = 50;

    private SearchKeyword searchKeyword;
    private Category category;
    private OrderByParameter orderByParameter;
    private int start;
    private int size;

    public static QueryParameter of(String keyword, String category, String orderBy, String start, String size) {
        return new QueryParameter(
                SearchKeyword.of(keyword),
                Category.of(category),
                OrderByParameter.of(orderBy),
                initializeStart(start),
                initializeSize(size)
        );
    }

    public PageRequest getPageRequest() {
        return PageRequest.of(start, size);
    }

    private static int initializeStart(String start) {
        try {
            int value = Integer.parseInt(start);
            if (value < MIN_START_PAGE) {
                throw new InvalidPageStartException();
            }

            return value;
        } catch (NumberFormatException e) {
            return MIN_START_PAGE;
        }
    }

    private static int initializeSize(String size) {
        try {
            int value = Integer.parseInt(size);
            if (value < MIN_PAGE_SIZE || value > MAX_PAGE_SIZE) {
                throw new InvalidPageSizeException();
            }

            return value;
        } catch (NumberFormatException e) {
            return MIN_PAGE_SIZE;
        }
    }

}
