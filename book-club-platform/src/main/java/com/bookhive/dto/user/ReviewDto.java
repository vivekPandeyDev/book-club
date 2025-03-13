package com.bookhive.dto.user;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ReviewDto {

    private Long id;
    private String username;
    private String bookTitle;
    private String content;
    private Double rating;
    private LocalDateTime createdAt; 
}
