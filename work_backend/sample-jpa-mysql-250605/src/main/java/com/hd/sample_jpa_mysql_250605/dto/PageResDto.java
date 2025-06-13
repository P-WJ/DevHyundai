package com.hd.sample_jpa_mysql_250605.dto;

import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter

public class PageResDto<T> {
    private final List<T> content;        // 현재 페이지의 데이터 리스트
    private final int pageNumber;         // 현재 페이지 번호 (0부터 시작)
    private final int pageSize;           // 페이지 크기
    private final long totalElements;     // 전체 데이터 개수Add commentMore actions
    private final int totalPages;         // 전체 페이지 수
    private final boolean last;           // 마지막 페이지 여부

    public PageResDto(Page<T> page) {
        this.content = page.getContent();
        this.pageNumber = page.getNumber();
        this.pageSize = page.getSize();
        this.totalElements = page.getTotalElements();
        this.totalPages = page.getTotalPages();
        this.last = page.isLast();
    }
}