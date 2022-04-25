SELECT * FROM attach;

-- 게시글처럼 한개의 글에 다수개의 첨부파일이 딸려 있는 경우
-- JOIN 문으로 게시글과 딸린 첨부파일을 한꺼번에 가져와서 보여줘야 한다.
-- 이 때 딸린 첨부파일의 갯수만큼 게시글이 중복되어 여러 행으로 표시된다
-- 각 게시글이 중복되지 않도록 하고 첨부파일은 한행의 한 컬럼에 모아서 가져오면
-- 한 컬럼 값에 모여 있는 값을 split 을 사용하여 쪼개서 사용하면 해결된다.

DESC board;
DESC attach;

SELECT *
FROM board b LEFT OUTER JOIN attach a
ON b.num = a.board_num;

SELECT title, GROUP_CONCAT(a.filename SEPARATOR '|') fnames
FROM board b LEFT OUTER JOIN attach a
ON b.num = a.board_num
GROUP BY b.num;

-- 'mysql-connector-java-8.0.28.jar|jstl-1.2(1).jar'
-- BoardSVC.java
-- String fnames = 'mysql-connector-java-8.0.28.jar|jstl-1.2(1).jar';
-- String[] fn = fnames.split("\\|");
-- fn[0]
-- fn[1]