package com.bookhive.dto.book;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookResponseDto {
    private Long bookId;
    private String title;
    private String author;
    private String genre;
    private String language;
    private Double rating;
    private Integer publishedYear;
    private String coverImageUrl;
    private String bookUrl;
    private List<DiscussionResponseDto> discussions;
    private List<ReviewResponseDto> reviews;
    private List<RecommendationResponseDto> recommendations;
    
}
