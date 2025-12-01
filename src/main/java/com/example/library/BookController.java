package com.example.library;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService service;

    public BookController(BookService service) { this.service = service; }

    @GetMapping
    public List<Book> all() { return service.all(); }

    @GetMapping("/available")
    public List<Book> available() { return service.available(); }

    @PostMapping
    public Book create(@RequestBody Book b) { return service.save(b); }
}
