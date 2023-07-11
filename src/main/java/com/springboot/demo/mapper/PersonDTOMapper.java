package com.springboot.demo.mapper;


import com.springboot.demo.dto.PersonDTO;
import com.springboot.demo.model.Person;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
@RequiredArgsConstructor

 public class PersonDTOMapper {
    public static PersonDTO toDto(Person person) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(person.getId());
        personDTO.setName(person.getName());
        return personDTO;
    }
}
