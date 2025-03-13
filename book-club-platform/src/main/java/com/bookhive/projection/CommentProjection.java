package com.bookhive.projection;

import java.time.LocalDateTime;

public interface CommentProjection {
    Long getId();
    String getText();
    LocalDateTime getCreatedAt();
}
