package com.naresh.demospringjdbc.service;

import java.util.List;

import com.naresh.demospringjdbc.model.Book;

public interface IBookService {

	void insert(Book book);

	void update(Book book);

	void delete(int bookId);

	Integer count();

	List<Book> list();

	Book findBook(int bookId);
	
	void updateTitle(Integer bookId, String bookTitle);

}