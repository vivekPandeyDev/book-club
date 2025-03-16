package com.bookhive.dto.book;

import jakarta.validation.constraints.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRequestDto {

    @NotBlank(message = "Title is required")
    @Size(max = 1000, message = "Title length should not exceed 1000 characters")
    private String title;

    @NotBlank(message = "Author is required")
    @Size(max = 255, message = "Author length should not exceed 255 characters")
    private String author;

    @NotBlank(message = "Genre is required")
    @Size(max = 100, message = "Genre length should not exceed 100 characters")
    private String genre;

    @NotBlank(message = "Language is required")
    @Size(max = 100, message = "Language length should not exceed 100 characters")
    private String language;

    @NotNull(message = "Published year is required")
    @Min(value = 1000, message = "Published year should not be earlier than 1000")
    @Max(value = 2100, message = "Published year should not exceed 2100")
    private Integer publishedYear;

    @NotNull(message = "Rating is required")
    @DecimalMin(value = "0.0", inclusive = true, message = "Rating should be at least 0.0")
    @DecimalMax(value = "5.0", inclusive = true, message = "Rating should not exceed 5.0")
    private Double rating;
}
