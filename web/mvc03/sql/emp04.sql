drop table emp04;
create table emp04(
	sabun number primary key,
	name varchar2(15),
	nalja varchar2(50),
	pay number,
	etc varchar2(15)
);
--
drop sequence emp04_seq;
create sequence emp04_seq start with 202001;
-- dummy;
insert into emp04 values (emp04_seq.nextval
					,'테스터1','20/01/09',1000,'test');
insert into emp04 values (emp04_seq.nextval
					,'테스터2','20/01/09',2000,'test');
insert into emp04 values (emp04_seq.nextval
					,'테스터3','20/01/09',3000,'test');
insert into emp04 values (emp04_seq.nextval
					,'테스터4','20/01/09',4000,'test');
insert into emp04 values (emp04_seq.nextval
					,'테스터5','20/01/09',5000,'test');
commit;
select * from emp04;









