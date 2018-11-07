package edu.brandeis.rseg105.spring.jdbc.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.brandeis.rseg105.spring.jdbc.crud.DeleteBookJdbc;
import edu.brandeis.rseg105.spring.jdbc.crud.FindBooksJdbc;
import edu.brandeis.rseg105.spring.jdbc.crud.FindCategoriesJdbc;
import edu.brandeis.rseg105.spring.jdbc.crud.InsertBookJdbc;
import edu.brandeis.rseg105.spring.jdbc.crud.UpdateBookJdbc;
import edu.brandeis.rseg105.spring.jdbc.domain.Book;
import edu.brandeis.rseg105.spring.jdbc.domain.Category;

/**
 * @author Louis LeBlanc
 * For Homework Assignment 1
 * Expert Software Development in Java
 * Brandeis University
 * Instructed by Vitaly Yurik
 */
@Repository("bookDao")
public class JdbcBookDao implements BookDao {
	private static Logger logger = LoggerFactory.getLogger(JdbcBookDao.class);
	private DataSource dataSource;
	private FindCategoriesJdbc selectCategories;
	private FindBooksJdbc selectBooks;
	private UpdateBookJdbc updateBook;
	private DeleteBookJdbc deleteBook;
	private InsertBookJdbc insertBook;

	@Override
 	public List<Book> findBooksByCategory(String catName) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		String sqlStr = "SELECT category.id, category.name, book.id, book.category_id, " +
				"book.isbn, book.title, book.price FROM category " +
				"LEFT JOIN book ON category.id = book.category_id " +
				"ORDER BY category.id";
		List<Book> bookList = new ArrayList<Book>();

		return jdbcTemplate.query(sqlStr, rs -> {
			// we've got results (rs), now pull the ones with the right name ...
			while (rs.next()) {
				String categoryName = rs.getString("name");
				if (categoryName.equals(catName)) {
					Book oneBook = new Book();
					oneBook.setId(rs.getLong("id"));
					oneBook.setCategory_id(rs.getLong("category_id"));
					oneBook.setIsbn(rs.getString("isbn"));
					oneBook.setTitle(rs.getString("title"));
					oneBook.setPrice(rs.getFloat("price"));
					bookList.add(oneBook);
				}
			}
			return bookList;
		});
	}

	@Override
	public List<Category> findCategories() {
		return selectCategories.execute();
	}

	@Override
	public List<Book> findBooks() {
		return selectBooks.execute();
	}

	@Override
	public void updateBook(Book book) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("category_id", book.getCategory_id());
		paramMap.put("isbn", book.getIsbn());
		paramMap.put("price", book.getPrice());
		paramMap.put("title", book.getTitle());
		paramMap.put("id",  book.getId());

		updateBook.updateByNamedParam(paramMap);
		logger.info("Existing book updated with id: " + book.getId());
	}

	@Override
	public void deleteBook(Long bookId) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", bookId);
		logger.info("deleteBook() id = " + bookId);
		deleteBook.updateByNamedParam(paramMap);
		logger.info("Deleted book with id: " + bookId);
	}

	@Override
	public void insertWithCategory(Book book) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("category_id", book.getCategory_id());
		paramMap.put("isbn", book.getIsbn());
		paramMap.put("title", book.getTitle());
		paramMap.put("price", book.getPrice());
		paramMap.put("id", book.getId());
		insertBook.updateByNamedParam(paramMap);
		logger.info("New book inserted with id: " + book.getId());
	}

	@Resource(name="dataSource")
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.selectCategories = new FindCategoriesJdbc(dataSource);
		this.selectBooks = new FindBooksJdbc(dataSource);
		this.updateBook = new UpdateBookJdbc(dataSource);
		this.deleteBook = new DeleteBookJdbc(dataSource);
		this.insertBook = new InsertBookJdbc(dataSource);
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}
}
