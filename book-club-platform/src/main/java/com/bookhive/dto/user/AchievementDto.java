package com.bookhive.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AchievementDto {
    private Long id;
    private String title;
    private String description;
    private String username;
}
