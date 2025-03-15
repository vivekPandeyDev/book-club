package com.bookhive.dto.book;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecommendationResponseDto {
    private Long recommendationId;
    private String recommendedBookTitle; // Replace Book object with book title
}
