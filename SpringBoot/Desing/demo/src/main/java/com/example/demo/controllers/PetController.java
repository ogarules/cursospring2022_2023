package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Pet;

@RestController
@RequestMapping("/pets")
public class PetController {
    
    @GetMapping
    public List<Pet> getAllPets(){

        List<Pet> pets = new ArrayList<>();
        Pet pet = new Pet();
        pets.add(pet);
        pet.setId(1L);
        pet.setName("Fido");
        pet.setTag("ABC-123");
        pet.setSpecies("Dog");

        return pets;
    }

    @PostMapping
    public Pet addPet(@RequestBody Pet pet){
        pet.setId(1L);
        return pet;
    }

    @GetMapping("/{id}")
    public Pet getPet(@PathVariable Long id){
        Pet pet = new Pet();
        pet.setId(id);
        pet.setName("Fido");
        pet.setTag("ABC-123");
        pet.setSpecies("Dog");

        return pet;
    }

    @PutMapping("/{id}")
    public Pet updatePet(@PathVariable Long id, @RequestBody Pet entity){
        return entity;
    }

    @DeleteMapping("/{id}")
    public void deletePet(@PathVariable Long id){
        
    }
}
