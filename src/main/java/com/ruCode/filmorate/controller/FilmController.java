package com.ruCode.filmorate.controller;


import com.ruCode.filmorate.model.Film;
import com.ruCode.filmorate.service.FilmService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/films")
@RequiredArgsConstructor
public class FilmController {
    private final FilmService filmService;

    @GetMapping
    public List<Film> getFilms(){
        return filmService.getFilms();
    }

    @PostMapping
    public Film post(@RequestBody @Valid Film film){
        return filmService.addFilm(film);
    }

    @GetMapping("/{id}")
    public Film getFilm(@PathVariable long id){
        return filmService.getFilm(id);
    }

    @DeleteMapping("/{id}")
    public void deleteFilm(@PathVariable long id){
        filmService.deleteFilm(id);
    }

    @PutMapping
    public Film updateFilm(@RequestBody @Valid Film film){
        return filmService.updateFilm(film);
    }

    @PutMapping("/{id}/like/{userId}")
    public void addLike(@PathVariable long id, @PathVariable long userId){
        filmService.addLike(id, userId);
    }

    @DeleteMapping("/{id}/like/{userId}")
    public void deleteLike(@PathVariable long id, @PathVariable long userId){
        filmService.deleteLike(id, userId);
    }

    @GetMapping("/popular?count={count}")
    public List<Film> getPopularFilms(@RequestParam(required = false) Integer count){
        return filmService.getPopular(count);
    }
}
