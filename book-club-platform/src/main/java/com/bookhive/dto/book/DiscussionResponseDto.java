package com.bookhive.dto.book;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiscussionResponseDto {
    private Long discussionId;
    private String content;
    private String username; 
}
