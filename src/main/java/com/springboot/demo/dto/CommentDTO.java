package com.springboot.demo.dto;

import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class CommentDTO {
    private long id;
    private String content;
}
