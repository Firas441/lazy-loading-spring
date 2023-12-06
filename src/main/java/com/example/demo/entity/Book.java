package com.example.demo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    private Long id ;
    private String title;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn ( name = " author_id " )
    private Author author ;

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }
}