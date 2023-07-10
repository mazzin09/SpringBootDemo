package com.springboot.demo.repository;

import com.springboot.demo.model.Blog;
import com.springboot.demo.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BlogRepository extends CrudRepository<Blog, Long> {
    List<Person> findByPersonId(long id);
}
