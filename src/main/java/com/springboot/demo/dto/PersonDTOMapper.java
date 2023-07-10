package com.springboot.demo.dto;


import com.springboot.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
 public class PersonDTOMapper {
    private final PersonDTO personDTO;

    @Autowired
    public PersonDTOMapper(PersonDTO personDTO) {
        this.personDTO = personDTO;
    }

    public static PersonDTO toDto(Person person) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setName(person.getName());
        return personDTO;
    }
}
