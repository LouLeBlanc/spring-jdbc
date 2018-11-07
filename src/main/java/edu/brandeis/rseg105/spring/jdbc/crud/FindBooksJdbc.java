package edu.brandeis.rseg105.spring.jdbc.crud;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.object.MappingSqlQuery;

import edu.brandeis.rseg105.spring.jdbc.domain.Book;

public class FindBooksJdbc extends MappingSqlQuery<Book> {
	private static final String SQL_SELECT_ALL_BOOKS =
			"select id, category_id, isbn, title, price from book";

	public FindBooksJdbc(DataSource dataSource) {
		super(dataSource, SQL_SELECT_ALL_BOOKS);
	}

	@Override
	protected Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		Book book = new Book();

		book.setId(rs.getLong("id"));
		book.setCategory_id(rs.getLong("category_id"));
		book.setIsbn(rs.getString("isbn"));
		book.setTitle(rs.getString("title"));
		book.setPrice(rs.getFloat("price"));
		
		return book;
	}

}
