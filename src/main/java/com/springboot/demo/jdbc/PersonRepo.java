package com.springboot.demo.jdbc;

import com.springboot.demo.model.Person;

import java.util.List;

public interface PersonRepo {
    int save(Person person);

    int update(Person person);

    Person findById(Long id);

    int deleteById(Long id);

    List<Person> findAll();

    List<Person> findByTitleContaining(String name);
}
