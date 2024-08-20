package com.ruCode.filmorate.service;

import com.ruCode.filmorate.model.Film;

import java.util.List;

public interface FilmService {
    Film addFilm(Film film);
    Film getFilm(long id);
    List<Film> getFilms();
    void deleteFilm(long id);
    void clear();
    Film updateFilm(Film film);
    void addLike(long id, long userId);
    void deleteLike(long id, long userId);
    List<Film> getPopular(Integer count);
}
