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

/**
 * @author leblanc
 *
 */
public class UpdateBookJdbcApp {
	private static Logger logger = LoggerFactory.getLogger(UpdateBookJdbcApp.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {

        logger.info("================ Start of Find All Books ================");

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        BookDao bookDao = ctx.getBean("bookDao", BookDao.class); 

        List<Book> books = bookDao.findBooks();
        Book existingBook = new Book();

        for (Book book : books) {
        	if (book.getId() == 8L) {
        		existingBook.setId(book.getId());
        		existingBook.setCategory_id(book.getCategory_id());
        		existingBook.setIsbn(book.getIsbn());
        		existingBook.setTitle(book.getTitle());
        		break;
        	}
        }

        // Now set the right price: 12.99
        existingBook.setPrice((float) 12.99);
        bookDao.updateBook(existingBook);

        // Retrieve the books again ...
        books = bookDao.findBooks();
        logger.info("---------------- Listing Books Start ----------------");
        // Display only book with ID 8
        books.forEach(book -> {
        	if (book.getId() == 8L) {
        	logger.info(book.toString());
        	} });
        logger.info("----------------- Listing Books End -----------------");

        ctx.close();

        logger.info("================= End of Find All Books =================");
	}
}
