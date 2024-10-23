INSERT INTO `board` (title, restaurant, coment, writer)
VALUES ('제목', '식당 이름', '한줄평', '작성자');

INSERT INTO `review` (food_name, food_coment, food_rating, board_id)
VALUES ('음식 메뉴 이름', '메뉴 한줄평', '5', '1');

INSERT INTO `user` (user_id, name, pass)
VALUES ('ssafy', '김싸피','1234');
