package com.example.library;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {
    private final BookRepository repo;

    public BookService(BookRepository repo) { this.repo = repo; }

    public List<Book> all() { return repo.findAll(); }
    public Book save(Book b) { return repo.save(b); }
    public List<Book> available() { return repo.findByAvailableTrue(); }
}
