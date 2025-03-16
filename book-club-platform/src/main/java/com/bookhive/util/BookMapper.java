package com.bookhive.util;

import java.util.stream.Collectors;

import com.bookhive.dto.book.BookResponseDto;
import com.bookhive.dto.book.DiscussionResponseDto;
import com.bookhive.dto.book.RecommendationResponseDto;
import com.bookhive.dto.book.ReviewResponseDto;
import com.bookhive.entity.Book;

public class BookMapper {
    public static BookResponseDto toDto(Book book) {
        BookResponseDto response = new BookResponseDto();
        response.setBookId(book.getBookId());
        response.setTitle(book.getTitle());
        response.setAuthor(book.getAuthor());
        response.setGenre(book.getGenre());
        response.setLanguage(book.getLanguage());
        response.setRating(book.getRating());
        response.setPublishedYear(book.getPublishedYear());
        response.setCoverImageUrl(book.getCoverImageUrl());
        response.setBookUrl(book.getBookUrl());
        // Map Discussions
        response.setDiscussions(book.getDiscussions().stream()
                .map(discussion -> {
                    DiscussionResponseDto dto = new DiscussionResponseDto();
                    dto.setDiscussionId(discussion.getDiscussionId());
                    dto.setContent(discussion.getContent());
                    dto.setUsername(discussion.getUser().getUsername());
                    return dto;
                })
                .collect(Collectors.toList()));

        // Map Reviews
        response.setReviews(book.getReviews().stream()
                .map(review -> {
                    ReviewResponseDto dto = new ReviewResponseDto();
                    dto.setReviewId(review.getReviewId());
                    dto.setContent(review.getContent());
                    dto.setUsername(review.getUser().getUsername());
                    return dto;
                })
                .collect(Collectors.toList()));

        // Map Recommendations
        response.setRecommendations(book.getRecommendations().stream()
                .map(recommendation -> {
                    RecommendationResponseDto dto = new RecommendationResponseDto();
                    dto.setRecommendationId(recommendation.getRecommendationId());
                    dto.setRecommendedBookTitle(recommendation.getBook().getTitle());
                    return dto;
                })
                .collect(Collectors.toList()));
        return response;
    }
}
