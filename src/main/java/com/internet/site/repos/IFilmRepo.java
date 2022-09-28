package com.internet.site.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internet.site.entitys.Film;

public interface IFilmRepo extends JpaRepository<Film, Long> {

}
