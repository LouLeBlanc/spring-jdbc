package edu.brandeis.rseg105.spring_jdbc.dao;

import java.util.List;

import edu.brandeis.rseg105.spring_jdbc.domain.Book;
import edu.brandeis.rseg105.spring_jdbc.domain.Category;

/**
 * @author Louis LeBlanc
 * For Homework Assignment 1
 * Expert Software Development in Java
 * Brandeis University
 * Instructed by Vitaly Yurik
 *
 */
public interface BookDao {
	List<Book> findBooksByCategory(String catName);
	public List<Category> findCategories();
	public List<Book> findBooks();
	public void updateBook(Book book);
	public void deleteBook(Long bookId);
	public void insertWithCategory(Book book);
}
