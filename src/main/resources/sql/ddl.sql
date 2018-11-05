CREATE USER 'prospring5'@'localhost' IDENTIFIED BY 'prospring5';

CREATE SCHEMA publishing;

GRANT ALL PRIVILEGES ON musicdb.* TO 'prospring5'@'localhost';
FLUSH PRIVILEGES;

/* Clarify timezone in case of java.sql.SQLException */
SET GLOBAL time_zone = '+5:00';


