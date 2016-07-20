select * from member;
create table member(
	id varchar2(20) primary key,
	pw varchar2(20),
	name varchar2(20),
	reg_date varchar2(20),
	ssn varchar2(10),	
	email varchar2(30),
	profile_img varchar2(100)
);
-- CREATE

insert into member(id,pw,name,reg_date,ssn)
values('lee','1','이순신','2016-07-01','800101-1','lee@test.com', 'lee.jpg');
insert into member(id,pw,name,reg_date,ssn)
values('hong','1','홍길동','2015-07-01','100701-1','hong@test.com','hong.jpg');
insert into member(id,pw,name,reg_date,ssn)
values('you','1','유관순','2014-07-01','010701-4','you@test.com', 'you.jpg');

-- READ 
select * from member; -- list
select * from member where id = 'lee'; -- findByPK
select * from member where gender = '남'; -- findByNotPK
select count(*) as count from member; -- count

-- UPDATE
update member set pw = '2', email='hong2@test.com' where id ='hong';
update member set email = id || '@test.com';
update member set pw = '1' where id = 'hong';
where id = 'you';
update member set profile_img = id || '.jpg' where profile_img is NULL;
update member set name = '최경환' where name='홍길동3';
alter table member add email varchar2(30);
alter table member add profile_img varchar2(100);
-- DELETE
delete from member where id = 'coffe';
drop table member;