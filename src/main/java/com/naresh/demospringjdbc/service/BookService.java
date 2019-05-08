package com.naresh.demospringjdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naresh.demospringjdbc.dao.IBookDAO;
import com.naresh.demospringjdbc.exception.BookAppException;
import com.naresh.demospringjdbc.model.Book;

@Service
public class BookService implements IBookService {

	@Autowired
	private IBookDAO bookDAO;
	
	@Override
	public void insert(Book book) {
		try {
			bookDAO.insert(book);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BookAppException(e.getMessage());
		}
	}
	
	@Override
	public void update(Book book) {
		bookDAO.update(book);
	}
	
	@Override
	public void delete (int bookId) {
		bookDAO.delete(bookId);
	}
	
	@Override
	public Integer count() {
		return bookDAO.count();
	}
	
	@Override
	public List<Book> list() {
		return bookDAO.list();
	}
	
	@Override
	public Book findBook(int bookId) {
		Book book = bookDAO.findOne(bookId);
		if(book == null) {
			throw new BookAppException("Invalid bookId");
		}
		return book;
	}
}
