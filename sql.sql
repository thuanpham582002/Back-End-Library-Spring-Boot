CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `role` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

ALTER TABLE user MODIFY password VARCHAR(100);

INSERT INTO user (username, password, email, role) VALUES
('nguyenvanA', 'passwordA', 'nguyenvanA@example.com', 'user'),
('tranvanB', 'passwordB', 'tranvanB@example.com', 'user'),
('lethiC', 'passwordC', 'lethiC@example.com', 'user'),
('phamthuD', 'passwordD', 'phamthuD@example.com', 'admin'),
('nguyenquangE', 'passwordE', 'nguyenquangE@example.com', 'user'),
('hoanghuyF', 'passwordF', 'hoanghuyF@example.com', 'user'),
('trinhngocG', 'passwordG', 'trinhngocG@example.com', 'user'),
('dangthiH', 'passwordH', 'dangthiH@example.com', 'user'),
('vodoanI', 'passwordI', 'vodoanI@example.com', 'admin'),
('phamxuanJ', 'passwordJ', 'phamxuanJ@example.com', 'user');

CREATE TABLE book (
  id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  author VARCHAR(255) NOT NULL,
  description TEXT,
  release_date DATE,
  num_pages INT,
  genre VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO book (title, author, description, release_date, num_pages, genre) VALUES
('Book A', 'Author A', 'This is book A', '2021-01-01', 200, 'Fiction'),
('Book B', 'Author B', 'This is book B', '2022-03-15', 320, 'Mystery'),
('Book C', 'Author C', 'This is book C', '2020-07-10', 150, 'Romance'),
('Book D', 'Author D', 'This is book D', '2023-02-28', 400, 'Fantasy'),
('Book E', 'Author E', 'This is book E', '2019-05-20', 280, 'Science Fiction'),
('Book F', 'Author F', 'This is book F', '2022-11-12', 180, 'Thriller'),
('Book G', 'Author G', 'This is book G', '2021-06-05', 250, 'Mystery'),
('Book H', 'Author H', 'This is book H', '2020-09-30', 300, 'Romance'),
('Book I', 'Author I', 'This is book I', '2023-04-18', 350, 'Fantasy'),
('Book J', 'Author J', 'This is book J', '2018-12-25', 220, 'Science Fiction');

INSERT INTO `order` (user_id, book_id, quantity, status) VALUES
(1, 5, 2, 'pending'),
(2, 1, 1, 'completed'),
(3, 7, 3, 'pending'),
(1, 3, 1, 'completed'),
(4, 10, 2, 'pending'),
(5, 2, 1, 'completed'),
(6, 6, 3, 'pending'),
(2, 8, 1, 'completed'),
(7, 4, 2, 'pending'),
(1, 9, 1, 'completed');

CREATE TABLE `order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `book_id` int NOT NULL,
  `quantity` int NOT NULL,
  `status` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `user`(`id`),
  FOREIGN KEY (`book_id`) REFERENCES `book`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



CREATE TABLE `review` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `book_id` int NOT NULL,
  `rating` int NOT NULL,
  `comment` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `user`(`id`),
  FOREIGN KEY (`book_id`) REFERENCES `book`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO review (user_id, book_id, rating, comment) VALUES
(1, 5, 4, 'This book is amazing!'),
(2, 1, 5, 'Highly recommended.'),
(3, 7, 3, 'Its an okay book.'),
(1, 3, 4, 'Loved the storyline.'),
(4, 10, 2, 'Not what I expected.'),
(5, 2, 4, 'Great plot twists.'),
(6, 6, 3, 'Decent read.'),
(2, 8, 5, 'One of my favorites!'),
(7, 4, 3, 'Enjoyable book.'),
(1, 9, 4, 'Couldnt put it down!');

