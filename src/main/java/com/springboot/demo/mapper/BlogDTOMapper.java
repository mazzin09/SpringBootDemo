package com.springboot.demo.mapper;

import com.springboot.demo.dto.BlogDTO;
import com.springboot.demo.dto.PersonDTO;
import com.springboot.demo.model.Blog;
import com.springboot.demo.model.Person;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Data
@RequiredArgsConstructor
public class BlogDTOMapper {
    public static BlogDTO toDto(Blog blog) {
        BlogDTO blogDTO = new BlogDTO();
        blogDTO.setId(blog.getId());
        blogDTO.setTitle(blog.getTitle());
        return blogDTO;
    }
}
