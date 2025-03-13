package com.bookhive.dto.user;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDto {

    private Long userId;
    private String username;
    private String email;
    private String role;
    private String avatar;
    private String bio;
    private List<FollowDto> followers;
    private List<FollowDto> following;
    private List<AchievementDto> achievements;
    private List<ReviewDto> reviews;
    private List<RecommendationDto> recommendations;
}
