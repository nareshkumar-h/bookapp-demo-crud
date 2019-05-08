package com.naresh.demospringjdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.naresh.demospringjdbc.model.Book;

@Repository
public class BookDAO implements IBookDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insert(Book book) {
		String sql = "insert into books(title) values (?)";
		Object[] params = { book.getTitle() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("Added Book:" + rows);
	}

	@Override
	public List<Book> list() {
		String sql = "select id, title from books";
		List<Book> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
			Book b = new Book();
			b.setId(rs.getInt("id"));
			b.setTitle(rs.getString("title"));
			return b;
		});
		return list;
	}

	@Override
	public Book findOne(Integer id) {
		Book book = null;
		try {
			String sql = "select id, title from books where id = ?";
			Object[] params = { id };
			book = jdbcTemplate.queryForObject(sql, params, (rs, num) -> {
				Book b = new Book();
				b.setId(rs.getInt("id"));
				b.setTitle(rs.getString("title"));
				return b;
			});
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public void update(Book book) {
		String sql = "update books set title= ? where id = ?";
		Object[] params = { book.getTitle(), book.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated:" + rows);
	}

	@Override
	public void delete(int bookId) {
		String sql = "delete from books where id = ?";
		Object[] params = { bookId };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows deleted:" + rows);
	}

	@Override
	public Integer count() {
		String sql = "select count(*) from books";
		Integer noOfBooks = jdbcTemplate.queryForObject(sql, Integer.class);
		return noOfBooks;
	}

	@Override
	public void updateTitle(Book book) {
		String sql = "update books set title= ? where id = ?";
		Object[] params = { book.getTitle(), book.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated:" + rows);

	}
}
