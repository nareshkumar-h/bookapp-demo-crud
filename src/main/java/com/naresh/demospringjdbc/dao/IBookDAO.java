package com.naresh.demospringjdbc.dao;

import java.util.List;

import com.naresh.demospringjdbc.model.Book;

public interface IBookDAO {

	void insert(Book book);

	List<Book> list();

	Book findOne(Integer id);

	void update(Book book);

	void delete(int bookId);

	Integer count();

	void updateTitle(Book book);

}