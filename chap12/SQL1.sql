# 계층구조 
CREATE TABLE employee (
   empno INT PRIMARY KEY AUTO_INCREMENT,
    ename VARCHAR(20) NOT NULL,
    mgr INT DEFAULT 0 REFERENCES empno,
    hiredate DATE
);

DESC employee;

INSERT INTO employee VALUES 
   (NULL, 'jone',0,'2000-01-03'),
   (NULL, 'adam',0,'2003-09-11'),
	(NULL, 'lora',1,'2005-07-07'),
    (NULL, 'smith',0,'2001-05-15'),
    (NULL, 'karl',1,'2009-03-17'),
    (NULL, 'david',2,'2004-08-09'),
    (NULL, 'jane',2,'2007-02-13'),
    (NULL, 'blake',3,'2008-04-15'),
    (NULL, 'julia',8,'2006-06-05'),
    (NULL, 'tim',1,'2005-11-13');

SELECT * FROM employee;

SELECT * FROM employee;
-- 모든 행에 임시컬럼 pnum을 추가하고 각 행의 최상위 부모 행의 번호를 할당하고 pnum을 기준으로 정렬
-- 하고 차수(level)를 이용하여 2차 정렬을 한다. 차수가 동일할 수도 있으므로 날짜를 기준으로 3차 정렬
WITH RECURSIVE cte AS (
  SELECT     empno,                          -- # Non-Recursive query 가 필수로 있어야 함
             CAST(ename AS CHAR(100)) ename, -- 이름 왼쪽에 들여쓰기 공백을 추가하기 위함
             mgr,
             hiredate,
             1 AS lvl,                       -- 최상위 부모 행으로부터의 차수(1부터 시작)
             @rn:=(@rn+1) AS pnum            -- 최상위 부모 행들의 행번호(1부터 증가함)
  FROM        (
            SELECT * FROM employee ORDER BY hiredate DESC -- 최신글 순으로 부모 행 정렬
          )t1, (SELECT @rn:=0)t2          -- 행번호로 사용할 변수(@rn) 선언
  WHERE      mgr = 0                         -- 최상위 행만을 선택함
  UNION                                      -- 아래는 바깥에 선언된 cte를 참조하는 커리(필수)
  SELECT     e.empno,
             CONCAT(REPEAT(' ', p.lvl*4), e.ename) ename,   -- 차수를 이용한 들여쓰기
             e.mgr,
             e.hiredate,
             p.lvl+1 AS lvl,                 -- 부모글의 차수에 1을 증가하여 자식 글의 차수 설정
             p.pnum AS pnum                  -- 자식 글에는 최상위 부모 글의 번호를 설정
  FROM       employee e
  INNER JOIN cte p
          ON p.empno = e.mgr
)
SELECT * FROM cte ORDER BY pnum, lvl, hiredate DESC;

-- UNION 위의 절이 실행되면 최상위 부모 아이템들만 선택되어 cte 를 구성한다
-- 위의 문장 중에서 매우 정교하게 해석이 필요한 부분은 UNION 이하의 문장이다.
-- UNION 아래의 문장이 수행하는 작업의 내용은 ...
-- 앞서 생성된 cte 임시 테이블과의 INNER JOIN 을 수행하여 결과를 생성하여 cte 테이블 하단에 추가한다
-- cte 테이블의 상단부터 한 행씩 방문하면서 각 아이템의 자식 아이템을 찾아 cte 하단에 추가하는 것이다
-- 이 때 계층구조 정렬을 준비하기 위해 추가되는 각 행에 임시컬럼으로 lvl(차수), pnum(최상위부모번호)을 추가한다
-- 현재 추가된 행은 cte 의 일부가 되므로 작업이 진행됨에 따라 결국 차후에 현재행의 자식행이 검색되어 추가된다.
-- 최종적으로 완성된 cte 테이블을 대상으로 pnum, lvl, hiredate 순으로 정렬하면 계층구조정렬이 완성된다