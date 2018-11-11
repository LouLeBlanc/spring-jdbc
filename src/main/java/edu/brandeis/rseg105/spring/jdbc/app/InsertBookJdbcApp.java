package edu.brandeis.rseg105.spring.jdbc.app;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.brandeis.rseg105.spring.jdbc.config.AppConfig;
import edu.brandeis.rseg105.spring.jdbc.dao.BookDao;
import edu.brandeis.rseg105.spring.jdbc.dao.JdbcBookDao;
import edu.brandeis.rseg105.spring.jdbc.domain.Book;
import edu.brandeis.rseg105.spring.jdbc.domain.Category;

/**
 * @author Louis LeBlanc
 * For Homework Assignment 1
 * Expert Software Development in Java
 * Brandeis University
 * Instructed by Vitaly Yurik
 */
public class InsertBookJdbcApp {
	private static Logger logger = LoggerFactory.getLogger(InsertBookJdbcApp.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// INSERT INTO book (id, category_id, isbn, title, price) VALUES (8, 4, '9780979107276', 'Life of Fred: Dogs', 12.99);
		logger.info("================ Testing insert new book Start ================");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		BookDao bookDao = ctx.getBean("bookDao", JdbcBookDao.class); 

		// Add a new book to the db
		Book newBook = new Book();
		newBook.setId(8L);
		newBook.setCategory_id(4L);
		newBook.setIsbn("9780979107276");
		newBook.setTitle("Life of Fred: Dogs");
		newBook.setPrice(10.99f);

		bookDao.insertWithCategory(newBook);

		List<Book> books = bookDao.findBooks();
		logger.info("---------------- Listing Books Start ----------------");
		books.forEach(book -> {
			if (book.getId() == newBook.getId())
				logger.info(book.toString());
			});
		logger.info("----------------- Listing Books End -----------------");

		ctx.close();

		logger.info("================= Testing insert new book End =================");
	}
}
