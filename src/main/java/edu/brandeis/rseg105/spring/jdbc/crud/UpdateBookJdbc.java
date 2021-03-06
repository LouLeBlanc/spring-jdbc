package edu.brandeis.rseg105.spring.jdbc.crud;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

public class UpdateBookJdbc extends SqlUpdate {
	private static final String SQL_UPDATE_BOOK = 
			"UPDATE book SET category_id=:category_id, isbn=:isbn, " +
			"price=:price, title=:title WHERE id=:id";

	public UpdateBookJdbc(DataSource dataSource) {
		super(dataSource, SQL_UPDATE_BOOK);
		super.declareParameter(new SqlParameter("category_id", Types.INTEGER));
		super.declareParameter(new SqlParameter("isbn", Types.VARCHAR));
		super.declareParameter(new SqlParameter("price", Types.FLOAT));
		super.declareParameter(new SqlParameter("title", Types.VARCHAR));
		super.declareParameter(new SqlParameter("id", Types.INTEGER));
	}
}
