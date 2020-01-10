drop table emp06;
create table emp06(
	sabun number primary key,
	name varchar2(15),
	cnt number unique
);

drop sequence emp06_seq;
create sequence emp06_seq;

insert into emp06 values (emp06_seq.nextval, 'test1', 1);
insert into emp06 values (emp06_seq.nextval, 'test2', 2);
insert into emp06 values (emp06_seq.nextval, 'test3', 3);
insert into emp06 values (emp06_seq.nextval, 'test4', 4);