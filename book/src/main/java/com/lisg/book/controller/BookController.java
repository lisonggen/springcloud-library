package com.lisg.book.controller;

import com.lisg.book.service.BookService;
import common.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

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

    @Autowired
    private DiscoveryClient client;

    @GetMapping("/book/get")
    public ResponseEntity<List<Book>> getBooks(@RequestParam(value = "bookId", required = false) Long bookId,
                                   @RequestParam(value = "title", required = false) String title,
                                   @RequestParam(value = "author", required = false) String author) {
        int sleepTime = new Random().nextInt(3000);
        List<ServiceInstance> instanceList = client.getInstances("book");
        log.info("-----sleetTime: {}", sleepTime);
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Book> bookList = bookService.getBook(bookId, title, author);
        return new ResponseEntity(bookList, HttpStatus.OK);
    }

    @PostMapping("/book/add")
    public ResponseEntity addBook(@RequestBody Book book) {
        bookService.saveBook(book);
        return new ResponseEntity(HttpStatus.OK);
    }

}
