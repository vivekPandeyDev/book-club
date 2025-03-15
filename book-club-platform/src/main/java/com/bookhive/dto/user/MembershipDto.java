package com.bookhive.dto.user;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MembershipDto {
    private Long id;
    private String bookClubName;
    private String username;
    private LocalDateTime joinedAt;
}
