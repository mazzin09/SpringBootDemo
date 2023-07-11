package com.springboot.demo.dto;

import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class BlogDTO {
    private long id;
    private String title;
}
