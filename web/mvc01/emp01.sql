drop table emp01;
create table emp01(
   sabun number primary key,
   name varchar2(15) not null,
   nalja date,
   pay number default 0,
   etc varchar2(30)
);
drop sequence emp01_seq;
create sequence emp01_seq;
--dummy
insert into emp01 values (emp01_seq.nextval, 'user1', sysdate, 1000, '이상 무');
insert into emp01 values (emp01_seq.nextval, 'user2', sysdate, 2000, '이상 무');
insert into emp01 values (emp01_seq.nextval, 'user3', sysdate, 3000, '이상 무');
insert into emp01 values (emp01_seq.nextval, 'user4', sysdate, 4000, '이상 무');
insert into emp01 values (emp01_seq.nextval, 'user5', sysdate, 5000, '이상 무');
commit;
select * from emp01;