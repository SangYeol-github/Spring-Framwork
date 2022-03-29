CREATE TABLE users (
	uid VARCHAR(30) NOT NULL,
	pwd VARCHAR(30) NOT NULL,
	name VARCHAR(30) NOT NULL,
	phone VARCHAR(30),
	PRIMARY KEY(uid));
    SELECT * FROM users;
    
    INSERT INTO users VALUES
	('smith', 'smithpwd', 'smith','010-0000-0000'),
    ('elise', 'elisepwd', 'elise','010-1111-1111'),
    ('blake', 'blakepwd', 'blake','010-2222-2222'),
    ('king', 'kingpwd', 'king','010-3333-3333'),
    ('queen', 'queenpwd', 'queen','010-4444-4444');
    
DROP TABLE users;