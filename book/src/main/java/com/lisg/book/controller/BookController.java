package com.lisg.book.controller;

import com.lisg.book.service.BookService;
import com.lisg.service.BookApiService;
import common.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: springcloud-library
 * @description:
 * @author: Reagan Li
 * @create: 2020-11-12 21:48
 **/

@Slf4j
@RestController
public class BookController implements BookApiService {

    @Autowired
    private BookService bookService;

    @Override
    public ResponseEntity<List<Book>> getBooks(@RequestParam(value = "bookId", required = false) Long bookId,
                                   @RequestParam(value = "title", required = false) String title,
                                   @RequestParam(value = "author", required = false) String author) {
        List<Book> bookList = bookService.getBook(bookId, title, author);
        return new ResponseEntity(bookList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity addBook(@RequestBody Book book) {
        bookService.saveBook(book);
        return new ResponseEntity(HttpStatus.OK);
    }

}
