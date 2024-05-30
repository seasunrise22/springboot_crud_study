INSERT INTO article(title, content) VALUES('가가가가', '1111');
INSERT INTO article(title, content) VALUES('나나나나', '2222');
INSERT INTO article(title, content) VALUES('다다다다', '3333');

INSERT INTO article(title, content) VALUES('알리 사세 가라아게 공구 ㄱ', 'ㄱㄱ'); -- 4
INSERT INTO article(title, content) VALUES('이거 뭐냐?', '뭐임?'); -- 5
INSERT INTO article(title, content) VALUES('책 팝니다.', '얼마 안 봤어요.'); -- 6

-- article_id, nickname, body
-- 4번 게시글 댓글
INSERT INTO comment(article_id, nickname, body) VALUES(4, 'ㅇㅇ', '탑승 완료');
INSERT INTO comment(article_id, nickname, body) VALUES(4, '행인', '탑승 완료2');
INSERT INTO comment(article_id, nickname, body) VALUES(4, '히히', '탑승 완료3');

-- 5번 게시글 댓글
INSERT INTO comment(article_id, nickname, body) VALUES(5, '하이', '고슴도치 같은데');
INSERT INTO comment(article_id, nickname, body) VALUES(5, '미국', '미국 오리너구리 아님?');
INSERT INTO comment(article_id, nickname, body) VALUES(5, '영국', '영국 토끼인 듯');

-- 6번 게시글 댓글
INSERT INTO comment(article_id, nickname, body) VALUES(6, '중고인', '얼만가요?');
INSERT INTO comment(article_id, nickname, body) VALUES(6, '사랑', '사랑으로 삽니다.');
INSERT INTO comment(article_id, nickname, body) VALUES(6, '대망', '탐스럽군요');

INSERT INTO member(email, password) VALUES('aa@naver.com', '1111');
INSERT INTO member(email, password) VALUES('bb@gmail.com', '2222');
INSERT INTO member(email, password) VALUES('cc@daum.net', '3333');

INSERT INTO coffee(name, price) VALUES('아메리카노', '4500');
INSERT INTO coffee(name, price) VALUES('라떼', '5000');
INSERT INTO coffee(name, price) VALUES('카페 모카', '5500');
