package com.springboot.demo.dto;

import com.springboot.demo.model.Blog;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class CommentDTO {
    private long id;
    private String content;
    private String blog;
    private String person;
}
