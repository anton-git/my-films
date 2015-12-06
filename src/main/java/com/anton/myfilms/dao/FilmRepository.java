package com.anton.myfilms.dao;

import com.anton.myfilms.model.Film;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FilmRepository extends CrudRepository<Film, Long> {

    List<Film> findByName(String name);
}
