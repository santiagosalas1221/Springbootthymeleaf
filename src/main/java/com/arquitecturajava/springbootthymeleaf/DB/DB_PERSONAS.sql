CREATE database springboot;

USE springboot;

CREATE TABLE personas (
id			INT		(3)	 AUTO_INCREMENT		PRIMARY KEY,
nombre		VARCHAR (30) NOT NULL,
apellidos	VARCHAR (30),
edad		INT         NOT NULL
);


INSERT INTO personas VALUES ("Santiago", "Salas", 23);
