package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Author {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    private Long id ;
    private String name;
    @OneToMany(mappedBy = "author")
    private List<Book> books = new ArrayList<Book>();

    public List<Book> getBooks() {
        return books;
    }

    public String getName(){
        return name;
    }

    public Long getId(){
        return id;
    }
}