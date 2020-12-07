package com.lisg.user.api;

import com.lisg.user.fallback.BookServiceFallback;
import common.entity.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "book", fallbackFactory = BookServiceFallback.class)
public interface BookClient {

    @GetMapping("/book/get")
    public ResponseEntity<List<Book>> getBooks(@RequestParam(value = "bookId", required = false) Long bookId,
                                               @RequestParam(value = "title", required = false) String title,
                                               @RequestParam(value = "author", required = false) String author);
}
