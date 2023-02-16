package com.example.demo.ejercicio31;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ejercicio29.models.Person;

@RestController
@RequestMapping("/rest/persons")
public class PersonRestController {
    
    private List<Person> persons = Collections.synchronizedList(new ArrayList<Person>());

    @PostConstruct
    private void init(){
        for(int i = 0; i<3; i++){
            Person p = new Person();
            p.setId(i+2);
            p.setName("OGA " + (i + 1));
            p.setAge(29+i+1);
        }
    }

    @GetMapping
    public List<Person> getAllPersons(){
        return persons;
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable Integer id){
        return persons.get(id);
    }

    @PostMapping
    public void createPerson(@RequestBody Person person){
        persons.add(person);
    }

    @GetMapping("/getException")
    public ResponseEntity<RestResponseError> getException(){
        try{
            throw new IllegalArgumentException("Argumentos invalidos");
        }
        catch(IllegalArgumentException ex){
            String errorMessage ="Exception: " + ex.getMessage();

            RestResponseError error = new RestResponseError(HttpStatus.BAD_REQUEST, ex.getMessage(), ex.getClass().getSimpleName());

            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

        }
    }
}
