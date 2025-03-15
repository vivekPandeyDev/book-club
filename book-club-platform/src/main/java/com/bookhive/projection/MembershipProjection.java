package com.bookhive.projection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MembershipProjection {
    private Long membershipId; // Only used to check if the membership exists
}
