package com.pluoi.check.dao;

import com.pluoi.check.entity.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

    void addPerson(UUID uuid, Person person);

    default void addPerson(Person person) {
        addPerson(UUID.randomUUID(), person);
    }

    void deletePerson(UUID uuid);

    void updatePerson(UUID id, Person person);

    Optional<Person> getPerson(UUID id);

    List<Person> getAllPersons();
}
