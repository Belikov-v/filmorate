package com.ruCode.filmorate.model;

import com.ruCode.filmorate.anotation.ReleaseTime;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;


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
    private Set<Long> usersIdLikedFilm;

    public void addLike(long userId){
        usersIdLikedFilm.add(userId);
    }
    public void deleteLike(long userId){
        usersIdLikedFilm.remove(userId);
    }
}
