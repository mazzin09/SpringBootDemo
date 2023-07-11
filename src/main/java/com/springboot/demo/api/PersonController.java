package com.springboot.demo.api;

import com.springboot.demo.dto.PersonDTO;
import com.springboot.demo.mapper.PersonDTOMapper;
import com.springboot.demo.model.Person;
import com.springboot.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personJpaService;

    @Autowired
    public PersonController(PersonService personJpaService){
        this.personJpaService = personJpaService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person){
        personJpaService.addPerson(person);
    }

    @GetMapping
    public List<PersonDTO> getAllPeople(){
        List<Person> persons = personJpaService.getAllPersons();
        return persons
                .stream()
                .map(PersonDTOMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "{id}")
    public List<PersonDTO> getPersonById(@PathVariable("id")  long id){
        Optional<Person> person = personJpaService.getPerson(id);
        return person.stream().map(PersonDTOMapper::toDto).collect(Collectors.toList());
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") long id){
        personJpaService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePersonById(@PathVariable("id") long id, @RequestBody Person updatePerson){
         personJpaService.updatePerson(id, updatePerson);
    }

}
