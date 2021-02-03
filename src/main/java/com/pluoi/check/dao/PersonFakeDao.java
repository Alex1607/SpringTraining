package com.pluoi.check.dao;

import com.pluoi.check.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("FakeDao")
public class PersonFakeDao implements PersonDao {

    /*
    DAO ist für den Database Access.
    In diesem fall ist das hier ein Fake Access da noch keine Datenbank existiert.
    */

    private final List<Person> FAKE_DB = new ArrayList<>();

    @Override
    public void addPerson(UUID uuid, Person person) {
        person.setId(uuid);
        FAKE_DB.add(person);
    }

    @Override
    public void deletePerson(UUID uuid) {
        FAKE_DB.iterator().forEachRemaining(person -> {
            if(person.getId().equals(uuid)) FAKE_DB.remove(person);
        });
    }

    //TODO: Warum wird hier die UUID geändert?
    @Override
    public void updatePerson(UUID id, Person person) {
        FAKE_DB
                .stream()
                .filter(person1 -> person1.getId().equals(id))
                .findFirst()
                .map(person1 -> {
                    int index = FAKE_DB.indexOf(person1);
                    if (index != -1) FAKE_DB.set(index, person);
                    return null;
                });
    }

    @Override
    public Optional<Person> getPerson(UUID id) {
        return FAKE_DB
                .stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Person> getAllPersons() {
        return FAKE_DB;
    }
}
