package com.springboot.demo.service;

import com.springboot.demo.model.Comment;
import com.springboot.demo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getComments(){
        List<Comment> comments = new ArrayList<>();
        commentRepository.findAll()
                .forEach(comments::add);
        return comments;
    }

    public Optional<Comment> getComment(long id){
        return commentRepository.findById(id);
    }

    public void addComment(Comment comment){
        commentRepository.save(comment);
    }

    public void updateComment(long id, Comment comment){
        Optional<Comment> commentOptional = commentRepository.findById(id);
        if(commentOptional.isEmpty()){
            ResponseEntity.notFound().build();
        }
        else{
            comment.setId(id);
            commentRepository.save(comment);
        }
    }

    public void deleteComment(long id){
        commentRepository.deleteById(id);
    }

}
