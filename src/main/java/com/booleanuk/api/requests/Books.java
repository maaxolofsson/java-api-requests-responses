package com.booleanuk.api.requests;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("books")
public class Books {

    private List<Book> books = new ArrayList<>();

    @GetMapping
    public List<Book> getAll() {
        return this.books;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // CREATED = 201 code
    public Book create(@RequestBody Book book) {
        book.setId(Book.idManager);
        ++Book.idManager;
        this.books.add(book);
        return book;
    }

}
