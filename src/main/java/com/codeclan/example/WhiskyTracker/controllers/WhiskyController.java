package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/year")
    public ResponseEntity findWhiskyByYear(@RequestParam(name = "year", required = false) Integer year) {
        if (year != null) {
            return new ResponseEntity(whiskyRepository.findWhiskyByYear(year), HttpStatus.OK);
        }
        return new ResponseEntity(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getByAgeAndDistilleryName(
            @RequestParam(required = false, name = "age") Integer age,
            @RequestParam(required = false, name = "name") String name
    ){
                if ( age != null && name != null){
            return new ResponseEntity(whiskyRepository.getByAgeAndDistilleryName(age, name), HttpStatus.OK);
        }
        return new ResponseEntity(whiskyRepository.findAll(), HttpStatus.OK);

        }
    }




