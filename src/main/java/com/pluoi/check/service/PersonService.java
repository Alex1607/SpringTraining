package com.pluoi.check.service;

import com.pluoi.check.dao.PersonDao;
import com.pluoi.check.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    /*
    In dem Service wird die Logik eingebaut.
    */

    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("FakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public List<Person> getAllPersons() {
        return personDao.getAllPersons();
    }

    public Optional<Person> getPersonByID(UUID id) {
        return personDao.getAllPersons()
                .stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    public void addNewPerson(Person person) {
        personDao.addPerson(person);
    }

    public void updatePerson(UUID id, Person person) {
        personDao.updatePerson(id, person);
    }
}
