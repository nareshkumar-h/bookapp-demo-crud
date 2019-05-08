package com.naresh.demospringjdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naresh.demospringjdbc.model.Book;
import com.naresh.demospringjdbc.service.BookService;

@RestController
@RequestMapping("books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody Book book) {
		bookService.insert(book);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	public ResponseEntity<List<Book>> list() {
		List<Book> list = bookService.list();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Object> update(@PathVariable("id") Integer id, @RequestBody Book book) {
		bookService.update(book);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PatchMapping("{id}")
	public void updateTitle(@PathVariable("id") Integer id, @RequestBody String bookTitle) {
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Book> findOne(@PathVariable("id") int bookId) {
		Book findBook = bookService.findBook(bookId);
		return new ResponseEntity<>(findBook, HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") int bookId) {
		bookService.delete(bookId);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping("count")
	public ResponseEntity<Integer> size() {
		Integer count = bookService.count();
		return new ResponseEntity<>(count, HttpStatus.OK);
	}
}
