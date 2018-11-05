package edu.brandeis.rseg105.spring_jdbc.crud;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

public class DeleteBookJdbc extends SqlUpdate {
	private static final String SQL_DELETE_BOOK = 
			"delete from book where id = :id";

	public DeleteBookJdbc(DataSource dataSource) {
		super(dataSource, SQL_DELETE_BOOK);
		super.declareParameter(new SqlParameter("id", Types.INTEGER));
	}

}
