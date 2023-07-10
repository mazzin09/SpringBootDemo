package com.springboot.demo.service;

import com.springboot.demo.model.Blog;
import com.springboot.demo.repository.BlogRepository;
import com.springboot.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    @Autowired
    public BlogRepository blogRepository;
    @Autowired
    private PersonRepository personRepository;

    public List<Blog> getBlogs(){
        List<Blog> blogs = new ArrayList<>();
        blogRepository.findAll()
                .forEach(blogs::add);
        return blogs;
    }

    public Optional<Blog> getBlog(long id) {
        return blogRepository.findById(id);
    }

    public void addBlog(Blog blog){
        blogRepository.save(blog);
    }

    public void updateBlog(long id, Blog blog) {
        Optional<Blog> blogOptional = blogRepository.findById(id);
        if (blogOptional.isEmpty()){
            ResponseEntity.notFound().build();
        }
        else{
            blog.setId(id);
            blogRepository.save(blog);
        }
    }

    public void deleteBlog(long id) {
        blogRepository.deleteById(id);
    }
}
