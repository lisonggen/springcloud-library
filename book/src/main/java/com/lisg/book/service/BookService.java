package com.lisg.book.service;

import common.entity.Book;

import java.util.List;

public interface BookService {

    public List<Book> getBook(Long bookId, String title, String author);

    public Integer saveBook(Book book);
}
