package edu.brandeis.rseg105.spring.jdbc.app;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.brandeis.rseg105.spring.jdbc.config.AppConfig;
import edu.brandeis.rseg105.spring.jdbc.dao.BookDao;
import edu.brandeis.rseg105.spring.jdbc.dao.JdbcBookDao;
import edu.brandeis.rseg105.spring.jdbc.domain.Book;

/**
 * @author Louis LeBlanc
 * For Homework Assignment 1
 * Expert Software Development in Java
 * Brandeis University
 * Instructed by Vitaly Yurik
 */

public class FindAllBooksJdbcApp {
	private static Logger logger = LoggerFactory.getLogger(FindAllBooksJdbcApp.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		logger.info("================ Start of Find All Books ================");

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		BookDao bookDao = ctx.getBean("bookDao", JdbcBookDao.class); 

		List<Book> books = bookDao.findBooks();
		logger.info("---------------- Listing Books Start ----------------");
		books.forEach(book -> { logger.info(book.toString()); });
		logger.info("----------------- Listing Books End -----------------");

		ctx.close();

		logger.info("================= End of Find All Books =================");

	}
}
