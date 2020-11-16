package com.lisg.user.controller;

import com.lisg.user.api.BookService;
import common.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: springcloud-library
 * @description:
 * @author: Reagan Li
 * @create: 2020-11-16 08:44
 **/
@RestController
public class BookApiController {

    @Autowired
    public BookService bookService;

    @GetMapping("/user/book/get")
    public ResponseEntity<List<Book>> getBooks(@RequestParam(value = "bookId", required = false) Long bookId,
                                               @RequestParam(value = "title", required = false) String title,
                                               @RequestParam(value = "author", required = false) String author) {
        ResponseEntity<List<Book>> responseEntity = bookService.getBooks(bookId, title, author);
        return responseEntity;
    }
}
