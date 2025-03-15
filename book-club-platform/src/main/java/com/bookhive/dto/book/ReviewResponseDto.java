package com.bookhive.dto.book;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewResponseDto {
    private Long reviewId;
    private String content;
    private String username; 
}
