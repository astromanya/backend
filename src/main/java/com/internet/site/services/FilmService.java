package com.internet.site.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.internet.site.entitys.Film;
import com.internet.site.repos.IFilmRepo;


@Service
public class FilmService {
    IFilmRepo ifilmRepo;

    public FilmService(IFilmRepo ifilmRepo) {
        this.ifilmRepo = ifilmRepo;
    }

    public List<Film> getAllFilms() {
        return ifilmRepo.findAll();
    }

    public Film saveOneFilm(Film newFilm) {
        return ifilmRepo.save(newFilm);
    }

    public Film getOneFilm (Long filmId) {

        return ifilmRepo.findById(filmId).orElse(null);
    }

    public Film updateFilm(Long filmId, Film newFilm) {
        Optional<Film> film = ifilmRepo.findById(filmId);
        if(film.isPresent()) {
            Film foundFilm = film.get();
            foundFilm.setText(newFilm.getText());
            foundFilm.setTitle(newFilm.getTitle());
            ifilmRepo.save(foundFilm);
            return foundFilm;
        }else
            return null;
    }

    public void deleteById(Long FilmId) {
        ifilmRepo.deleteById(FilmId);

    }

}
