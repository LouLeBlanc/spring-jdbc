INSERT INTO category (id, name) VALUES (1, 'Classics');
INSERT INTO category (id, name) VALUES (2, 'Novels');
INSERT INTO category (id, name) VALUES (3, 'Java');
INSERT INTO category (id, name) VALUES (4, 'Education');

INSERT INTO book (id, category_id, isbn, title, price) VALUES (1, 3, '9780134685997', 'Effective Java', 54.99);
INSERT INTO book (id, category_id, isbn, title, price) VALUES (2, 3, '9781484228074', 'Pro Spring 5', 49.99);
INSERT INTO book (id, category_id, isbn, title, price) VALUES (3, 1, '9781402712173', 'The Adventures of Sherlock Holmes', 5.95);
INSERT INTO book (id, category_id, isbn, title, price) VALUES (4, 1, '9781402726651', 'Oliver Twist', 4.95);
INSERT INTO book (id, category_id, isbn, title, price) VALUES (5, 2, '9780439023528', 'The Hunger Games', 8.99);
INSERT INTO book (id, category_id, isbn, title, price) VALUES (6, 2, '9780439023498', 'Catching Fire', 17.99);
INSERT INTO book (id, category_id, isbn, title, price) VALUES (7, 4, '9780979107269', 'Life of Fred: Cats', 12.99);

INSERT INTO book (id, category_id, isbn, title, price) VALUES (8, 4, '9780979107276', 'Life of Fred: Dogs', 12.99);
