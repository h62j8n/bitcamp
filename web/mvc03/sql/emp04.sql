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
					,'�׽���1','20/01/09',1000,'test');
insert into emp04 values (emp04_seq.nextval
					,'�׽���2','20/01/09',2000,'test');
insert into emp04 values (emp04_seq.nextval
					,'�׽���3','20/01/09',3000,'test');
insert into emp04 values (emp04_seq.nextval
					,'�׽���4','20/01/09',4000,'test');
insert into emp04 values (emp04_seq.nextval
					,'�׽���5','20/01/09',5000,'test');
commit;
<<<<<<< HEAD
select * from emp04;









=======
select * from emp04;
>>>>>>> 0b9268d46ce442e29a716da2162ffb8bd68f1646
