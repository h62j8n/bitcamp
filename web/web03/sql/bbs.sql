drop table bbs01;
drop sequence bbs01_seq;

create table bbs01(
num number primary key,
sub varchar2(30),
id varchar2(10),
content varchar2(2000),
nalja date,
cnt number
);

create sequence bbs01_seq;
--dummy
insert into bbs01 values(bbs01_seq.nextval,'test1','teser','aaaa',sysdate,0);
insert into bbs01 values(bbs01_seq.nextval,'test2','teser','bbbb',sysdate,0);
insert into bbs01 values(bbs01_seq.nextval,'test3','teser','cccc',sysdate,0);
insert into bbs01 values(bbs01_seq.nextval,'test4','teser','dddd',sysdate,0);
insert into bbs01 values(bbs01_seq.nextval,'test5','teser','eeee',sysdate,0);
commit;
