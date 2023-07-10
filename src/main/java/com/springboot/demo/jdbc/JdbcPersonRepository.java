package com.springboot.demo.jdbc;

import com.springboot.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class JdbcPersonRepository implements PersonRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public int save(Person person) {
        return jdbcTemplate.update("INSERT INTO person (name, address) VALUES(?,?)",
                new Object[] { person.getName(), person.getAddress() });
    }

    @Override
    public int update(Person person) {
        return jdbcTemplate.update("UPDATE person SET name=?, address=? WHERE id=?",
                new Object[] { person.getName(), person.getAddress(), person.getId() });
    }

    @Override
    public Person findById(Long id) {
        return null;
    }

    @Override
    public int deleteById(Long id) {
        return 0;
    }

    @Override
    public List<Person> findAll() {
        return jdbcTemplate.query("SELECT * from person", BeanPropertyRowMapper.newInstance(Person.class));
    }

    @Override
    public List<Person> findByTitleContaining(String name) {
        String q = "SELECT * from person WHERE name ILIKE '%" + name + "%'";
        return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(Person.class));
    }
}
