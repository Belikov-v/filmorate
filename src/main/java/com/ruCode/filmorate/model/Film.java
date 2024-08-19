package com.ruCode.filmorate.model;

import com.ruCode.filmorate.anotation.ReleaseTime;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;


@Data
@Builder
public class Film {
    private long id;
    @NotBlank
    private String name;
    @NotBlank
    @Size(min = 1, max = 200)
    private String description;
    @ReleaseTime
    private LocalDate releaseDate;
    @Positive
    private int duration;
}
