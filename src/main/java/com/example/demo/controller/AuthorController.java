package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Author;
import com.example.demo.service.AuthorService;

@RestController
@RequestMapping("/api/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("/{name}")
    public Author getAuthorByName(@PathVariable String name) {
        return authorService.getAuthorByName(name);
    }

    @PostMapping("/save")
    public Author saveAuthor(@RequestBody Author author) {
        return authorService.saveAuthor(author);
    }
}
