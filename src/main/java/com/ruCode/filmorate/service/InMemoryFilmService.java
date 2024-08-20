package com.ruCode.filmorate.service;

import com.ruCode.filmorate.exception.NotFound;
import com.ruCode.filmorate.model.Film;
import com.ruCode.filmorate.model.User;
import com.ruCode.filmorate.storage.FilmStorage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class InMemoryFilmService implements FilmService{
    private final FilmStorage filmStorage;
    private final UserService userService;
    private static long id = 1L;

    @Override
    public Film addFilm(Film film) {
        log.debug("add film");
        film.setId(id++);
        return filmStorage.addFilm(film);
    }

    @Override
    public Film getFilm(long id) {
        Film film = filmStorage.getFilm(id);
        if(film == null){
            throw new NotFound("Film не найден");
        }
        return film;
    }

    @Override
    public List<Film> getFilms() {
        return filmStorage.getFilms();
    }

    @Override
    public void deleteFilm(long id) {
        log.debug("delete film");
        getFilm(id);
        filmStorage.deleteFilm(id);
    }

    @Override
    public void clear() {
        log.debug("clear films");
        filmStorage.clear();
    }

    @Override
    public Film updateFilm(Film film) {
        log.debug("Update film");
        Film oldFilm = getFilm(film.getId());
        Film newFilm = update(oldFilm,film);
        filmStorage.updateUser(newFilm);
        return newFilm;
    }

    @Override
    public void addLike(long id, long userId) {
        userService.getUser(userId);
        Film film = getFilm(id);
        film.addLike(userId);
        updateFilm(film);
    }

    @Override
    public void deleteLike(long id, long userId) {
        userService.getUser(userId);
        Film film = getFilm(id);
        film.deleteLike(userId);
        updateFilm(film);
    }

    @Override
    public List<Film> getPopular(Integer count) {
        if(count==null){
            count = 10;
        }
        List<Film> films = getFilms();
        films.sort(Comparator.comparingInt(x -> x.getUsersIdLikedFilm().size()));
        if(count >= films.size()){
            return films;
        }else{
            List<Film> answer = new ArrayList<>();
            for(var i = films.size()-count; i< films.size(); i++){
                answer.add(films.get(i));
            }
            return answer;
        }
    }

    private Film update(Film oldFilm, Film film){
        if(film.getName()!=null){
            oldFilm.setName(film.getName());
        }
        if(film.getDescription()!=null){
            oldFilm.setDescription(film.getDescription());
        }
        if(film.getDuration()!=0){
            oldFilm.setDuration(film.getDuration());
        }
        if(film.getReleaseDate()!=null){
            oldFilm.setReleaseDate(film.getReleaseDate());
        }
        return oldFilm;
    }
}
