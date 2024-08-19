package com.ruCode.filmorate.model;

import com.ruCode.filmorate.anotation.SpaceContains;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class User {
    private long id;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    @SpaceContains
    private String login;
    private String name;
    @PastOrPresent
    private LocalDate birthday;
}
