package com.springboot.demo.mapper;

import com.springboot.demo.dto.CommentDTO;
import com.springboot.demo.dto.PersonDTO;
import com.springboot.demo.model.Comment;
import com.springboot.demo.model.Person;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Data
@RequiredArgsConstructor
public class CommentDTOMapper {
    public static CommentDTO toDto(Comment comment) {
        CommentDTO commentDTODTO = new CommentDTO();
        commentDTODTO.setId(comment.getId());
        commentDTODTO.setContent(comment.getContent());
        return commentDTODTO;
    }
}
