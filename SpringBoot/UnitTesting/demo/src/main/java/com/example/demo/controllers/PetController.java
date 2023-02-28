package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Pet;
import com.example.demo.services.IPetService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/pets")
@RestController
public class PetController {
    
    @Autowired
    private IPetService service;

    @GetMapping("/{id}")
    public Pet getPetById(@PathVariable Long id){
        log.info("Requesting pet {}", id);

        return this.service.getPatById(id);
    }

    @GetMapping
    public Iterable<Pet> getAllpets(){
        log.info("Getting all pets");

        return this.service.getAllPets();
    }

    @PostMapping
    public Pet addPet(@RequestBody Pet pet){

        return this.service.addPet(pet);
    }

    @PutMapping("/{id}")
    public Pet updatePet(@PathVariable Long id, @RequestBody Pet pet){
        return this.service.updatePet(id, pet);
    }

    @DeleteMapping("/{id}")
    public void deletePet(@PathVariable Long id){
        this.service.deletePet(id);
    }
}
