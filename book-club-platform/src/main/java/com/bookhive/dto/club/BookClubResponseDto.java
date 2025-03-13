package com.bookhive.dto.club;
import java.time.LocalDateTime;
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
public class BookClubResponseDto {
    private Long clubId;
    private String name;
    private String description;
    private String ownerName;
    private LocalDateTime createdAt;
    private int memberCount;
}