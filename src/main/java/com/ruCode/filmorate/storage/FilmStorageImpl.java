package com.ruCode.filmorate.storage;

import com.ruCode.filmorate.model.Film;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class FilmStorageImpl implements FilmStorage{
    private final Map<Long,Film> films = new HashMap<>();


    @Override
    public Film addFilm(Film film) {
        return films.put(film.getId(),film);
    }

    @Override
    public Film getFilm(long id) {
        return films.get(id);
    }

    @Override
    public List<Film> getFilms() {
        return List.copyOf(films.values());
    }

    @Override
    public void deleteFilm(long id) {
        films.remove(id);
    }

    @Override
    public void clear() {
        films.clear();
    }

    @Override
    public Film updateUser(Film film) {
        films.put(film.getId(), film);
        return film;
    }
}
