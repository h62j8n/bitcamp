drop table bbs01user;
drop sequence bbs01user_seq;

create table bbs01user(
	idx number primary key,
	id varchar2(20) not null,
	pw varchar2(20) not null,
	nick varchar2(20) default '이름없음'
);

create sequence bbs01user_seq;

-- dummy
insert into bbs01user values (bbs01user_seq.nextval, 'tester', '1234', '관리자');
insert into bbs01user values (bbs01user_seq.nextval, 'guest', '1234', '손님');
insert into bbs01user values (bbs01user_seq.nextval, 'user01', '1234', null);

commit;
