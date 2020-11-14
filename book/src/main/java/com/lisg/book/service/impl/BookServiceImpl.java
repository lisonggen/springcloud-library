package com.lisg.book.service.impl;

import com.lisg.book.mapper.BookMapper;
import com.lisg.book.service.BookService;
import common.constant.Const;
import common.entity.Book;
import common.util.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
    public List<Book> getBook(Long bookId, String title, String author) {
        return bookMapper.selectBook(bookId, title, author);
    }

    @Override
    public Integer saveBook(Book book) {
        SnowflakeIdWorker sf = new SnowflakeIdWorker();
        book.setBookId(sf.nextId());
        book.setCreateTime(new Date());
        book.setStatus(Const.BookStatus.NORMAL);
        return bookMapper.insert(book);
    }
}
