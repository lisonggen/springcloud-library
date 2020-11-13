package com.lisg.book.controller;

import com.lisg.book.service.BookService;
import common.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springcloud-library
 * @description:
 * @author: Reagan Li
 * @create: 2020-11-12 21:48
 **/

@Slf4j
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/book/get")
    public ResponseEntity<Book> getBooks(@RequestParam(value = "bookId", required = false) Long bookId,
                                   @RequestParam(value = "title", required = false) String title,
                                   @RequestParam(value = "author", required = false) String author) {
        Book book = bookService.getBookById(bookId);
        return new ResponseEntity(book, HttpStatus.OK);
    }

}
