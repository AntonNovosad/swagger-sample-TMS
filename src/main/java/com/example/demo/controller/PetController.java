package com.example.demo.controller;

import com.example.demo.model.Pet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {
    private List<Pet> petList = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Pet> addANewPetToTheStore(@RequestBody Pet pet) {
        if (petList.add(pet)) {
            return new ResponseEntity<>(pet, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(pet, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<Pet> update(int id, String name) {
        Pet pet = petList.get(id);
        pet.setName(name);
        return new ResponseEntity<>(pet, HttpStatus.ACCEPTED);
    }

//    @DeleteMapping
//    public ResponseEntity<Pet>
}
