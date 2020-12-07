package com.lisg.user.fallback;

import com.lisg.user.api.BookClient;
import common.entity.Book;
import feign.hystrix.FallbackFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: springcloud-library
 * @description:
 * @author: Reagan Li
 * @create: 2020-12-06 12:29
 **/
@Component
public class BookServiceFallback implements FallbackFactory<BookClient> {

    @Override
    public BookClient create(Throwable throwable) {

        return new BookClient() {
            @Override
            public ResponseEntity<List<Book>> getBooks(Long bookId, String title, String author) {
                List<Book> bookList = new ArrayList<>();
                return new ResponseEntity(bookList, HttpStatus.OK);
            }
        };
    }
}
