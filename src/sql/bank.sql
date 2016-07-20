
----------[내부 스키마 : 물리적] ---------------
create table bank(
	id varchar2(20) ,
	account_no number constraint bank_pk primary key,
	money number,
	constraint bank_member_fk foreign key (id)
	references member(id) on delete cascade
);

select * from bank;
drop table bank;


--------------------------------------------
create view bank_member as
select
	b.account_no as account,
	b.money as money,
	m.id as id,
	m.pw as pw,
	m.name as name,
	m.reg_date as reg_date,
	m.ssn as ssn
from member m,bank b
where m.id = b.id;

select * from bank_member;

select 
account,
money,
id,
name,
ssn
from bank_member;

select * from bank;

------------------------------------
create view account_member as
select 
b.account_no as account,
	b.money as money,
	m.id as id,
	m.pw as pw,
	m.name as name,
	m.reg_date as reg_date,
	m.ssn as ssn
from
member m, account a
where m.id = a.id;
