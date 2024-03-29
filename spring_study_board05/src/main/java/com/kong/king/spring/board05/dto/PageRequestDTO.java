package com.kong.king.spring.board05.dto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class PageRequestDTO {

    private int page;
    private int size;

    private String type;
    private String keyword;

    public PageRequestDTO() {
        this.page = 1;
        this.size = 10;

    }

    public PageRequest getPageable(Sort sor) {
        return PageRequest.of(page - 1, size, sor);
    }

}
