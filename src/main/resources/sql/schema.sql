DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS book;

CREATE TABLE  category(
		id INT NOT NULL,
		name VARCHAR(100) NOT NULL,
		PRIMARY key ( ID )
		);

CREATE TABLE  book(
		id INT NOT NULL,
		category_id INT NOT NULL,
		isbn VARCHAR(13) NOT NULL,
		title VARCHAR(500) NOT NULL,
		price DECIMAL(4,2) NOT NULL,
		UNIQUE uq_isbn_1 (isbn),
		PRIMARY KEY ( id ),
		CONSTRAINT fk_category FOREIGN KEY (category_id)
			REFERENCES category (id)
		);

