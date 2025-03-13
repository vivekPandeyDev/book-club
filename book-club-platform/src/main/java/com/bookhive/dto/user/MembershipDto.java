package com.bookhive.dto.user;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MembershipDto {
    private Long id;
    private String bookClubName;
    private String username;
    private LocalDateTime joinedAt;
}
