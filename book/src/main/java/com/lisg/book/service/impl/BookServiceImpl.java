package com.lisg.book.service.impl;

import com.lisg.book.mapper.BookMapper;
import com.lisg.book.service.BookService;
import common.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: springcloud-library
 * @description:
 * @author: Reagan Li
 * @create: 2020-11-13 17:51
 **/
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public Book getBookById(Long bookId) {
        return bookMapper.selectById(bookId);
    }

}
