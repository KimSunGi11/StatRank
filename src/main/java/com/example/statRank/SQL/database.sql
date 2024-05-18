CREATE TABLE characterlist (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    content VARCHAR(255),
    imageFile VARCHAR(255),
    stat1 INT DEFAULT 0,
    stat2 INT DEFAULT 0,
    stat3 INT DEFAULT 0,
    stat4 INT DEFAULT 0,
    stat5 INT DEFAULT 0,
    view_count INT DEFAULT 0
);

INSERT INTO characterlist (name, imageFile)
VALUES
('손흥민', '손흥민.png'),
('박지성', '박지성.png');

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
);