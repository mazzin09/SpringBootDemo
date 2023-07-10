package com.springboot.demo.api;

import com.springboot.demo.model.Blog;
import com.springboot.demo.model.Comment;
import com.springboot.demo.model.Person;
import com.springboot.demo.repository.BlogRepository;
import com.springboot.demo.repository.PersonRepository;
import com.springboot.demo.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/comments")
@RestController
public class CommentController {
    private final CommentService commentService;
    private final PersonRepository personRepository;
    private final BlogRepository blogRepository;

    public CommentController(CommentService commentService, PersonRepository personRepository, BlogRepository blogRepository) {
        this.commentService = commentService;
        this.personRepository = personRepository;
        this.blogRepository = blogRepository;
    }

    @GetMapping
    public List<Comment> getAllComments(){
        return commentService.getComments();
    }

    @PostMapping
    public void addComment(@RequestBody Comment comment){
        long personId = comment.getPerson().getId();
        Person person = personRepository.findById(personId).get();
        long blogId = comment.getBlog().getId();
        Blog blog = blogRepository.findById(blogId).get();
        comment.setPerson(person);
        comment.setBlog(blog);
        commentService.addComment(comment);
    }

    @GetMapping(path = "{id}")
    public Optional<Comment> getCommentById(@PathVariable("id") long id){
        return commentService.getComment(id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteCommentById(@PathVariable long id){
        commentService.deleteComment(id);
    }

    @PutMapping(path = "{id}")
    public void updateCommentById(@PathVariable long id,@RequestBody Comment updateComment){
        long updatePersonId = updateComment.getPerson().getId();
        Person person = personRepository.findById(updatePersonId).get();
        long updateBlogId = updateComment.getBlog().getId();
        Blog blog = blogRepository.findById(updateBlogId).get();
        updateComment.setPerson(person);
        updateComment.setBlog(blog);
        commentService.updateComment(id, updateComment);
    }
}
