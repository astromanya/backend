package com.internet.site.controllers;

import com.internet.site.entitys.Film;
import com.internet.site.entitys.Film;
import org.springframework.web.bind.annotation.*;

import com.internet.site.services.FilmService;

import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmController {

	private FilmService filmService;

	public FilmController(FilmService filmService) {
		this.filmService = filmService;
	}
	@GetMapping
	public List<Film> getAllFilms(){
		return filmService.getAllFilms();
	}
	@GetMapping("/{filmId}")
	public Film getOneFilm(@PathVariable Long filmId) {
		return filmService.getOneFilm(filmId);
	}
	@PostMapping
	public Film createFilm(@RequestBody Film newFilm) {
		return filmService.saveOneFilm(newFilm);
	}
	@PutMapping("/{filmId}")
	public Film updateOneFilm(@PathVariable Long filmId,@RequestBody Film newFilm) {
		return filmService.updateFilm(filmId, newFilm);
	}
	@DeleteMapping("/{filmId}")
	public void deleteOneFilm(@PathVariable Long filmId) {
		filmService.deleteById(filmId);

	}


}