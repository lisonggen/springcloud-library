package com.lisg.book.mapper;

import common.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {

    public List<Book> selectBook(@Param("bookId") Long bookId, @Param("title")String title,
                       @Param("author")String author);

    public List<Book> selectAll();

    public Integer deleteById(Long id);

    public Integer insert(Book book);

    public Integer updateById(Book book);
}
