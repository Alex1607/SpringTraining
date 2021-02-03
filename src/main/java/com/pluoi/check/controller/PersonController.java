package com.pluoi.check.controller;

import com.pluoi.check.entity.Person;
import com.pluoi.check.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("person")
@RestController
public class PersonController {

    /*
    Hier im Controller werden die Post, Put, Get usw Mappings eingtragen.
    */

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getAllPerson() {
        return personService.getAllPersons();
    }

    @GetMapping(path = "{id}") //Wird für das Mapping mit /id verwendet
    public Person getPerson(@PathVariable("id") UUID id) { //Die
        return personService.getPersonByID(id).orElse(null);
    }

    @PostMapping
    public void addPerson(@NonNull @Valid @RequestBody Person person) {
        personService.addNewPerson(person);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id, @NonNull @Valid @RequestBody Person person) {
        personService.updatePerson(id, person);
    }
}
