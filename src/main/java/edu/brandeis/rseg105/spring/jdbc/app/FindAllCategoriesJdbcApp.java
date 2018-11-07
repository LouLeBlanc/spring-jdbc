package edu.brandeis.rseg105.spring.jdbc.app;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.brandeis.rseg105.spring.jdbc.config.AppConfig;
import edu.brandeis.rseg105.spring.jdbc.dao.BookDao;
import edu.brandeis.rseg105.spring.jdbc.dao.JdbcBookDao;
import edu.brandeis.rseg105.spring.jdbc.domain.Category;

/**
 * @author Louis LeBlanc
 * For Homework Assignment 1
 * Expert Software Development in Java
 * Brandeis University
 * Instructed by Vitaly Yurik
 */

public class FindAllCategoriesJdbcApp {
	private static Logger logger = LoggerFactory.getLogger(FindAllCategoriesJdbcApp.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {

        logger.info("================ Start of Find All Categories ================");
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        BookDao bookDao = ctx.getBean("bookDao", JdbcBookDao.class); 

        List<Category> categories = bookDao.findCategories();
        logger.info("---------------- Listing Categories Start ----------------");
        categories.forEach(category -> { logger.info(category.toString()); });
        logger.info("----------------- Listing Categories End -----------------");

        ctx.close();

        logger.info("================= End of Find All Categories =================");
	}
}
