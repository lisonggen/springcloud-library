package com.lisg.book.mapper;

import common.entity.Book;
import java.util.List;

public interface BookMapper {

    public Book selectById(Long id);

    public List<Book> selectAll();

    public Integer deleteById(Long id);

    public Integer insertSelective(Book book);

    public Integer updateById(Book book);
}
