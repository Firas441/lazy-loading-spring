package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Author;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;

    @Transactional
    public Author getAuthorByName(String name) {
        return authorRepository.findByName(name);
    }

    @Transactional
    public Author saveAuthor(Author author) {
        Author savedAuthor = authorRepository.save(author);

        author.getBooks().forEach(book -> book.setAuthor(author));
        author.getBooks().forEach(book -> bookRepository.save(book));

        return savedAuthor;
    }
}
