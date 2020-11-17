package com.lisg.service;

import common.entity.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/book")
public interface BookApiService {

    @GetMapping("/get")
    public ResponseEntity<List<Book>> getBooks(@RequestParam(value = "bookId", required = false) Long bookId,
                                               @RequestParam(value = "title", required = false) String title,
                                               @RequestParam(value = "author", required = false) String author);

    @PostMapping("/add")
    public ResponseEntity addBook(@RequestBody Book book);
}
