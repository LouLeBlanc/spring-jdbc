CREATE USER IF NOT EXISTS 'prospring5' IDENTIFIED BY 'prospring5';

DROP DATABASE publishing;

CREATE SCHEMA publishing;

GRANT ALL PRIVILEGES ON publishing.* TO 'prospring5';
FLUSH PRIVILEGES;

/* Clarify timezone in case of java.sql.SQLException */
SET GLOBAL time_zone = '+5:00';


