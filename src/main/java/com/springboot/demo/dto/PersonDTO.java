package com.springboot.demo.dto;

import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
 public class PersonDTO{
    private long id;
    private String name;
}
