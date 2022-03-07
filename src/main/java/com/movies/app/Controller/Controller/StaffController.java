package com.movies.app.Controller.Controller;

import com.movies.app.Controller.Repository.StaffRepo;
import com.movies.app.Controller.exception.ResourceNotFoundException;

//import com.movies.app.Controller.model.Language;
import com.movies.app.Controller.model.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/")
public class StaffController {
    @Autowired
    private StaffRepo staffRepo;

    // get all staff
    @GetMapping(value = "/staff")
    public List<Staff> getAllLanguage(){
        return staffRepo.findAll();

    }


    //create staff Rest API
    @PostMapping("/staff")
    public Staff createFilm(@RequestBody Staff film){
        return staffRepo.save(film);
    }

    //get staff by id
    @GetMapping(value = "/staff/{id}")
    public ResponseEntity<Staff> getFilmById(@PathVariable int id){
        Staff film=staffRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Staff not exist with id:" + id));
        return ResponseEntity.ok(film);
    }

    // update staff Rest API
    @PutMapping(value = "/staff/{id}")
    public ResponseEntity<Staff> updateFilms(@PathVariable int id,@RequestBody Staff filmDetails){
        Staff film=staffRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Staff not exist with id:" + id));
        filmDetails.setPaymentId(film.getPaymentId());
        film.setFirstName(film.getFirstName());
        film.setLastName(film.getLastName());
        film.setEmail(film.getEmail());
        film.setUsername(film.getUsername());
        film.setPassword(film.getPassword());
        film.setLastUpdated(film.getLastUpdated());
        film.setPictureUrl(film.getPictureUrl());
//        customer.setActive(customer.getActive());
        staffRepo.save(filmDetails);
        return ResponseEntity.ok(film);
    }

    // delete staff from rest API
    @DeleteMapping(value = "/staff/{id}")
    public  ResponseEntity<HttpStatus> deleteFilms(@PathVariable int id){
        Staff film=staffRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Staff not exist with id:" + id));
        staffRepo.delete(film);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
