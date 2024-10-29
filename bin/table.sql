DROP TABLE IF EXISTS board;
CREATE TABLE `board` (
	`board_id` INT AUTO_INCREMENT PRIMARY KEY,
    `title` varchar(40) NOT NULL,
    `restaurant` VARCHAR(45) NOT NULL,
    `coment` VARCHAR(255) ,
    `review_rating` DOUBLE(2,1) DEFAULT NULL,
    `view_cnt` INT DEFAULT 0,
    `reg_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `writer` VARCHAR(40) NOT NULL
)ENGINE=InnoDB;

DROP TABLE IF EXISTS review;
CREATE TABLE `review`(
	`review_id` INT AUTO_INCREMENT PRIMARY KEY,
    `food_name` VARCHAR(25) NOT NULL,
    `food_coment` VARCHAR(40),
    `food_rating` INT NOT NULL,
    `board_id` INT NOT NULL
) ENGINE=InnoDB;

DROP TABLE IF EXISTS user;
CREATE TABLE `user` (
  `user_id` VARCHAR(50) NOT NULL,
  `name` VARCHAR(45) UNIQUE NOT NULL,
  `pass` VARCHAR(100) NOT NULL,
  `signup_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`)
) ENGINE = InnoDB;


select * from board;
SELECT * FROM review;
SELECT * from user;