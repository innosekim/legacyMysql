# sql 돌렸던 history

### 초기셋팅 참고용

15:34:14	use mysql	0 row(s) affected	0.000 sec

15:34:16	select user, host from user LIMIT 0, 1000	5 row(s) returned	0.000 sec / 0.000 sec

15:34:41	grant all privileges on nyangmung.* to 'nyangmung'@'localhost' with grant option	Error Code: 1410. You are not allowed to create a user with GRANT	0.000 sec

15:34:43	select user, host from user LIMIT 0, 1000	5 row(s) returned	0.000 sec / 0.000 sec

15:35:32	grant all privileges on nyangmung.* to 'nyangmung'@'localhost' with grant option	Error Code: 1410. You are not allowed to create a user with GRANT	0.016 sec

15:35:40	show databases	7 row(s) returned	0.000 sec / 0.000 sec

15:37:22	drop user 'nyangmung'@'%'	0 row(s) affected	0.031 sec

15:37:39	show databases	7 row(s) returned	0.016 sec / 0.000 sec

15:37:42	select user, host from user LIMIT 0, 1000	4 row(s) returned	0.000 sec / 0.000 sec

15:38:13	create user 'nyangmung'@'%' identified by 'nyangmung'	0 row(s) affected	0.016 sec

15:38:19	select user, host from user LIMIT 0, 1000	5 row(s) returned	0.000 sec / 0.000 sec

15:38:46	grant all privileges on nyangmung.* to 'nyangmung'@'%' with grant option	0 row(s) affected	0.015 sec

15:39:03	flush privileges	0 row(s) affected	0.015 sec

16:01:31	select user, host from user LIMIT 0, 1000	5 row(s) returned	0.000 sec / 0.000 sec

16:01:45	GRANT ALL PRIVILEGES ON spring_ex.* TO 'nyangmung'@'localhost' IDENTIFIED BY 'nyangmung'	Error Code: 1064. You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'IDENTIFIED BY 'nyangmung'' at line 1	0.000 sec

16:04:50	grant all privileges on *.* to 'nyangmung'@'localhost' identified by 'nyangmung' with grant option	Error Code: 1064. You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'identified by 'nyangmung' with grant option' at line 1	0.000 sec

16:11:28	grant all privileges on spring_ex.* to nyangmung@'%' with grant option	0 row(s) affected	0.016 sec

16:20:03	show databases	7 row(s) returned	0.000 sec / 0.000 sec

16:32:39	Apply changes to new_table	Changes applied

16:33:01	Apply changes to new_table	Changes applied

16:41:01	Apply changes to tbl_member	Changes applied

16:41:08	SELECT * FROM spring_ex.tbl_member LIMIT 0, 1000	0 row(s) returned	0.000 sec / 0.000 sec

16:42:41	SELECT * FROM spring_ex.tbl_member LIMIT 0, 1000	1 row(s) returned	0.000 sec / 0.000 sec









==================================================================================



CREATE SCHEMA spring_ex DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;

show databases;

use mysql;
select user, host from user;

grant all privileges on nyangmung.* to 'nyangmung'@'%' with grant option;
-- 권한부여

flush privileges;

drop user 'nyangmung'@'%';

create user 'nyangmung'@'%' identified by 'nyangmung';

--  grant all privileges on *.* to 'nyangmung'@'localhost' identified by 'nyangmung' with grant option;
-- '구버전 쿼리'

grant all privileges on spring_ex.* to nyangmung@'%' with grant option;


--   3. 명령어를 사용해 root계정의 비밀번호를 설정하고 확인한다.

--           alter user '계정입력'@'localhost' identified with mysql_native_password by '비밀번호입력';


-- 해당 유저에게 권한을 부여한다.

-- mysql> grant all privileges on javadb.* to 'javauser'@'%' with grant option;
-- Query OK, 0 rows affected (0.01 sec)