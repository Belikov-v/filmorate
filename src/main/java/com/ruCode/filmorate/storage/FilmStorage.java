package com.ruCode.filmorate.storage;

import com.ruCode.filmorate.model.Film;

import java.util.List;

public interface FilmStorage {
    Film addFilm(Film film);
    Film getFilm(long id);
    List<Film> getFilms();
    void deleteFilm(long id);
    void clear();
    Film updateUser(Film film);
}
