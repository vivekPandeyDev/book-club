package com.bookhive.util;

import java.util.stream.Collectors;

import com.bookhive.dto.user.AchievementDto;
import com.bookhive.dto.user.FollowDto;
import com.bookhive.dto.user.RecommendationDto;
import com.bookhive.dto.user.ReviewDto;
import com.bookhive.dto.user.UserResponseDto;
import com.bookhive.entity.User;

public class UserMapper {

    public static UserResponseDto toDto(User user) {
        if (user == null) {
            return null;
        }

        UserResponseDto dto = new UserResponseDto();
        dto.setUserId(user.getUserId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        dto.setAvatar(user.getAvatar());
        dto.setBio(user.getBio());

        // Convert followers
        dto.setFollowers(user.getFollowers().stream()
                .map(follow -> new FollowDto(
                        follow.getId(),
                        follow.getFollower() != null ? follow.getFollower().getUsername() : null,
                        follow.getFollowing() != null ? follow.getFollowing().getUsername() : null))
                .collect(Collectors.toList()));

        // Convert following
        dto.setFollowing(user.getFollwings().stream()
                .map(follow -> new FollowDto(
                        follow.getId(),
                        follow.getFollower() != null ? follow.getFollower().getUsername() : null,
                        follow.getFollowing() != null ? follow.getFollowing().getUsername() : null))
                .collect(Collectors.toList()));

        // Convert achievements
        dto.setAchievements(user.getAchievements().stream()
                .map(achievement -> {
                    AchievementDto achievementDto = new AchievementDto();
                    achievementDto.setId(achievement.getId());
                    achievementDto.setTitle(achievement.getTitle());
                    achievementDto.setDescription(achievement.getDescription());
                    achievementDto.setUsername(achievement.getUser().getUsername());
                    return achievementDto;
                })
                .collect(Collectors.toList()));

        // Convert reviews
        dto.setReviews(user.getReviews().stream()
                .map(review -> {
                    ReviewDto reviewDto = new ReviewDto();
                    reviewDto.setId(review.getReviewId());
                    reviewDto.setContent(review.getContent());
                    reviewDto.setRating(review.getRating());
                    reviewDto.setBookTitle(review.getBook().getTitle());
                    reviewDto.setUsername(review.getUser().getUsername());
                    return reviewDto;
                })
                .collect(Collectors.toList()));

        // Convert recommendations
        dto.setRecommendations(user.getRecommendations().stream()
                .map(recommendation -> {
                    RecommendationDto recommendationDto = new RecommendationDto();
                    recommendationDto.setId(recommendation.getRecommendationId());
                    recommendationDto.setUsername(recommendation.getUser().getUsername());
                    recommendationDto.setBookName(recommendation.getBook().getTitle());
                    recommendationDto.setScore(recommendation.getScore());
                    return recommendationDto;
                })
                .collect(Collectors.toList()));

        return dto;
    }
}
