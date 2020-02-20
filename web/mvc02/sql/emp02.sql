drop table emp02;
drop table dept02;
drop sequence emp02_seq;
drop sequence dept02_seq;

create table dept02(
	deptno number primary key,
	dname varchar2(15),
	loc varchar2(15)
);
create sequence dept02_seq;

create table emp02(
	sabun number primary key,
	name varchar2(15),
	nalja date,
	deptno number constraint emp02_deptno_fk references dept02(deptno)
);
create sequence emp02_seq start with 1000;

insert into dept02 values (dept02_seq.nextval, '영업', '서울');
insert into dept02 values (dept02_seq.nextval, '회계', '서울');
insert into dept02 values (dept02_seq.nextval, '생산', '부산');
insert into dept02 values (dept02_seq.nextval, '마케팅', '대전');

commit;

insert into emp02 values (emp02_seq.nextval, '전정국', sysdate, 2);
insert into emp02 values (emp02_seq.nextval, '민윤기', sysdate, 3);
insert into emp02 values (emp02_seq.nextval, '정호석', sysdate, 3);
insert into emp02 values (emp02_seq.nextval, '박지민', sysdate, 1);
insert into emp02 values (emp02_seq.nextval, '김태형', sysdate, 3);

commit;

select * from emp02;
select * from dept02;