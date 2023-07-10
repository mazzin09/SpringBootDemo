package com.springboot.demo.dto;

import org.springframework.stereotype.Service;

@Service
 public class PersonDTO{
    private String name;

    public String getName(String name) {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
