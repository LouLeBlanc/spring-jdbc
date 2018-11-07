package edu.brandeis.rseg105.spring.jdbc.crud;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

public class InsertBookJdbc extends SqlUpdate {
	private static final String SQL_INSERT_BOOK = 
			"INSERT INTO book (id, category_id, isbn, title, price) " +
			"VALUES (:id, :category_id, :isbn, :title, :price)";

	public InsertBookJdbc(DataSource dataSource) {
		super(dataSource, SQL_INSERT_BOOK);
		super.declareParameter(new SqlParameter("id", Types.INTEGER));
		super.declareParameter(new SqlParameter("category_id", Types.INTEGER));
		super.declareParameter(new SqlParameter("isbn", Types.VARCHAR));
		super.declareParameter(new SqlParameter("title", Types.VARCHAR));
		super.declareParameter(new SqlParameter("price", Types.FLOAT));
	}
}
