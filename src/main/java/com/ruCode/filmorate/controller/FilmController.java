package com.ruCode.filmorate.controller;


import com.ruCode.filmorate.model.Film;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/films")
public class FilmController {
    private static Long id = 1L;
    private final Map<Long, Film> films = new HashMap<>();

    @GetMapping
    public List<Film> getFilms(){
        return List.copyOf(films.values());
    }

    @PostMapping
    public Film post(@RequestBody @Valid Film film){
        log.debug("POST film");
        film.setId(id++);
        films.put(film.getId(),film);
        return film;
    }

    @PutMapping
    public Film updateFilm(@RequestBody @Valid Film film){
        log.debug("Put film");
        films.put(film.getId(), film);
        return film;
    }


}
