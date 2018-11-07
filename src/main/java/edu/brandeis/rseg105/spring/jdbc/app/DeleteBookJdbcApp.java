/**
 * @author Louis LeBlanc
 */
package edu.brandeis.rseg105.spring.jdbc.app;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.brandeis.rseg105.spring.jdbc.config.AppConfig;
import edu.brandeis.rseg105.spring.jdbc.dao.BookDao;
import edu.brandeis.rseg105.spring.jdbc.domain.Book;
import edu.brandeis.rseg105.spring.jdbc.domain.Category;

/**
 * @author leblanc
 *
 */
public class DeleteBookJdbcApp {
	private static Logger logger = LoggerFactory.getLogger(DeleteBookJdbcApp.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {

        logger.info("================ Testing delete book Start ================");

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        BookDao bookDao = ctx.getBean("bookDao", BookDao.class); 

        bookDao.deleteBook(8L);

        List<Book> books = bookDao.findBooks();
        logger.info("---------------- Listing Books Start ----------------");
        books.forEach(book -> { logger.info(book.toString()); });
        logger.info("----------------- Listing Books End -----------------");

        ctx.close();

        logger.info("================= Testing delete book End =================");
	}

}
