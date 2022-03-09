package com.movies.app.Controller.Service;

import com.movies.app.Controller.Exception.ResourceNotFoundException;
import com.movies.app.Controller.Model.Film;
import com.movies.app.Controller.Repository.FilmRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {
    @Autowired
    private final FilmRepo filmRepo;

    public FilmService(FilmRepo filmRepo) {
        this.filmRepo = filmRepo;
    }

    //creates a film
    public Film addFilm(Film film){
        return filmRepo.save(film);
    }

    //create a list of films

    //read a list of all the films
    public List<Film> getAllFilms(){
        return filmRepo.findAll();
    }

    //reads a film by its id
    public ResponseEntity<Film> getFilmById(int id){
        Film film=filmRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Film with id "+id+" does not exit."));
        return ResponseEntity.ok(film);
    }

    //update film
    public ResponseEntity<Film> updateCustomer(int id, Film filmInfo){
        Film film=filmRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Film with id:"+id+" does not exist."));

        film.setTitle(filmInfo.getTitle());
        film.setDescription(filmInfo.getDescription());
        film.setReleaseYear(filmInfo.getReleaseYear());
        film.setRentalDuration(filmInfo.getRentalDuration());
        film.setRentalRate(filmInfo.getRentalRate());
        film.setLength(filmInfo.getLength());
        film.setReplacementCost(filmInfo.getReplacementCost());
        film.setRating(filmInfo.getRating());
        film.setLastUpdate(filmInfo.getLastUpdate());
        film.setSpecialFeatures(filmInfo.getSpecialFeatures());
        film.setFullTxt(filmInfo.getFullTxt());

        filmRepo.save(film);
        return ResponseEntity.ok(film);
    }

    // delete film from rest API
        public  ResponseEntity<HttpStatus> deleteFilms(int id){
        Film film=filmRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Film with id: "+id+" does not exist."));
        filmRepo.delete(film);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
