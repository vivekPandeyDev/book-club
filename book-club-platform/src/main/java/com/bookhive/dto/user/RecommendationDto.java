package com.bookhive.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecommendationDto {
    private Long id;
    private String username; 
    private String bookName;
    private Double score; 
}
