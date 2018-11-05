INSERT INTO category (id, name) VALUES (1, 'Classics');
INSERT INTO category (id, name) VALUES (2, 'Novels');
INSERT INTO category (id, name) VALUES (3, 'Java');
INSERT INTO category (id, name) VALUES (4, 'Education');

INSERT INTO book (id, category_id, isbn, title, price) VALUES (1, 3, '9780134685997', 54.99, 'Effective Java');
INSERT INTO book (id, category_id, isbn, title, price) VALUES (2, 3, '9781484228074', 49.99, 'Pro Spring 5');
INSERT INTO book (id, category_id, isbn, title, price) VALUES (3, 1, '9781402712173', 5.95, 'The Adventures of Sherlock Holmes');
INSERT INTO book (id, category_id, isbn, title, price) VALUES (4, 1, '9781402726651', 4.95, 'Oliver Twist');
INSERT INTO book (id, category_id, isbn, title, price) VALUES (5, 2, '9780439023528', 8.99, 'The Hunger Games');
INSERT INTO book (id, category_id, isbn, title, price) VALUES (6, 2, '9780439023498', 17.99, 'Catching Fire');
INSERT INTO book (id, category_id, isbn, title, price) VALUES (7, 4, '9780979107269', 12.99, 'Life of Fred: Cats');

INSERT INTO book (id, category_id, isbn, title, price) VALUES (8, 4, '9780979107276', 12.99, 'Life of Fred: Dogs');
