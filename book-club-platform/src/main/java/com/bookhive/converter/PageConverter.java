package com.bookhive.converter;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PageConverter<T extends Serializable> {

    public Page<T> convertToPage(CachedPageDTO<T> cachedPage) {
        Pageable pageable = PageRequest.of(
            cachedPage.getPage() >= 0 ? cachedPage.getPage() : 0,
            cachedPage.getSize() > 0 ? cachedPage.getSize() : 10,
            Sort.by(cachedPage.getSortBy() != null ? cachedPage.getSortBy() : "name").ascending()
        );
        return new PageImpl<>(cachedPage.getContent(), pageable,cachedPage.getTotalElement());
    }
}