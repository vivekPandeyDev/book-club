package com.bookhive.dto.club;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookClubDto {

    @NotBlank(message = "{bookclub.name.notblank}")
    @Size(min=20,max = 100, message = "{bookclub.name.size}")
    private String name;

    @NotBlank(message = "{bookclub.description.notblank}")
    @Size(max = 500, message = "{bookclub.description.size}")
    private String description;

    @NotNull(message = "{bookclub.ownerid.notnull}")
    private Long ownerId;
   
}