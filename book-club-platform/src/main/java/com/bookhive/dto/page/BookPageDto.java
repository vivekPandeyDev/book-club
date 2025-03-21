package com.bookhive.dto.page;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookPageDto {
    private Long id;
    private Integer pageNumber;
    private String pageTitle;
    private String pageUrl;
    private Long bookId;
    private String bookName;
    @JsonIgnore
    private String content;
}
