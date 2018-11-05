package edu.brandeis.rseg105.spring_jdbc.crud;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import edu.brandeis.rseg105.spring_jdbc.domain.Category;
import org.springframework.jdbc.object.MappingSqlQuery;

public class FindCategoriesJdbc extends MappingSqlQuery<Category> {
	private static final String SQL_SELECT_ALL_CATEGORIES = 
			"select id, name from category";

	public FindCategoriesJdbc (DataSource dataSource) {
		super(dataSource, SQL_SELECT_ALL_CATEGORIES);
	}

	@Override
	protected Category mapRow(ResultSet rs, int rowNum) throws SQLException {
		Category category = new Category();
		
		category.setId(rs.getLong("id"));
		category.setName(rs.getString("name"));

		return category;
	}

}
