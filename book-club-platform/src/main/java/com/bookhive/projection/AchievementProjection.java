package com.bookhive.projection;

import java.time.LocalDateTime;

public interface AchievementProjection {
    Long getId();
    String getName();
    LocalDateTime getDateAwarded();
}
