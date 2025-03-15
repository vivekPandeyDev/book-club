package com.bookhive.dto.book;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChapterResponseDto {
    private Long chapterId;
    private String title;
    private String contentUrl;
}
