package com.springboot.demo.service;

import com.springboot.demo.model.Person;
import com.springboot.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    public PersonRepository personRepository;

    public List<Person> getAllPersons() {

        List<Person> persons = new ArrayList<>();
        personRepository.findAll()
                .forEach(persons::add);

        return persons;
    }

    public void addPerson(Person person){
        personRepository.save(person);
    }

    public Optional<Person> getPerson(long id) {
        return personRepository.findById(id);
    }

    public void updatePerson(long id, Person person) {
        Optional<Person> personOptional = personRepository.findById(id);
        if (personOptional.isEmpty()){
            ResponseEntity.notFound().build();
        }
        else{
            person.setId(id);
            personRepository.save(person);
        }
    }

    public void deletePerson(long id) {
        Optional<Person> personOptional = personRepository.findById(id);
        if (personOptional.isEmpty()){
            ResponseEntity.notFound().build();
        }
        else{
            personRepository.deleteById(id);
        }
    }


}
