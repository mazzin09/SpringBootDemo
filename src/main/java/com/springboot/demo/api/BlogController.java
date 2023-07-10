package com.springboot.demo.api;

import com.springboot.demo.model.Blog;
import com.springboot.demo.model.Person;
import com.springboot.demo.repository.BlogRepository;
import com.springboot.demo.repository.PersonRepository;
import com.springboot.demo.service.BlogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/blogs")
@RestController
public class BlogController {
    private final BlogService blogJpaService;

    private final PersonRepository personRepository;
    private final BlogRepository blogRepository;



    public BlogController(BlogService blogJpaService, PersonRepository personRepository, BlogRepository blogRepository) {
        this.blogJpaService = blogJpaService;
        this.personRepository = personRepository;
        this.blogRepository = blogRepository;
    }

    @GetMapping
    public List<Blog> getAllBlog(){
        return blogJpaService.getBlogs();
    }

    @PostMapping
    public void addBlog(@RequestBody Blog blog){
        long personId = blog.getPerson().getId();
        Person person = personRepository.findById(personId).get();
        blog.setPerson(person);
        blogJpaService.addBlog(blog);
    }

    @GetMapping(path = "{id}")
    public Optional<Blog> getBlogById(@PathVariable("id")  long id){
        return blogJpaService.getBlog(id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteBlogById(@PathVariable("id") long id){
        blogJpaService.deleteBlog(id);
    }

    @PutMapping(path = "{id}")
    public void updateBlogById(@PathVariable("id") long id, @RequestBody Blog updateBlog){
        long personId = updateBlog.getPerson().getId();
        Person person = personRepository.findById(personId).get();
        updateBlog.setPerson(person);
        blogJpaService.updateBlog(id, updateBlog);
    }
}
