package com.pluoi.check.controller;

import com.pluoi.check.entity.Person;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("person")
@RestController
public class PersonController {

    @GetMapping
    public List<Person> getAllPerson() {
        return Person.getPersonsList();
    }

    @GetMapping(path = "{id}")
    public Person getPerson(@PathVariable("id") UUID id) {
        return Person.getPersonsList()
                .stream()
                .filter(person -> person.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public UUID addPerson(@NonNull @Valid @RequestBody Person person) {
        return person.getId();
    }

    @PostMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id, @NonNull @Valid @RequestBody Person person) {
        Person.getPersonsList()
                .stream()
                .filter(person1 -> person1.getId().equals(id))
                .forEach(person1 -> person1 = person);
    }
}
