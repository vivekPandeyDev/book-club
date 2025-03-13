package com.bookhive.projection;

import java.time.LocalDateTime;

public interface DiscussionProjection {
    Long getId();
    String getTitle();
    LocalDateTime getCreatedAt();
}
