package com.example.demo.controller;

import com.example.demo.model.Pet;
import com.example.demo.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pet")
public class PetController {
    @Autowired
    PetService petService;

    @PostMapping
    public void addANewPetToTheStore(@RequestBody Pet pet) {
        petService.save(pet);
    }

    @DeleteMapping("/{petId}")
    public void delete(@PathVariable long petId) {
        petService.delete(petId);
    }

    @PutMapping
    public void update(@RequestBody Pet pet) {
        petService.update(pet);
    }

    @PostMapping("/{petId}")
    public void update(@PathVariable long petId, String name, String status) {
        petService.update(petId, name, status);
    }

    @GetMapping("/findByStatus")
    public ResponseEntity<List<Pet>> getByStatus(@RequestBody String[] status) {
        List<Pet> petList = petService.listByStatus(status);
        return new ResponseEntity<>(petList, HttpStatus.OK);
    }

    @GetMapping("/{petId}")
    public ResponseEntity<Pet> getById(@PathVariable long petId) {
        Pet pet = petService.getById(petId);
        if (pet != null) {
            return new ResponseEntity<>(pet, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
