drop table bbs02;
drop sequence bbs02_seq;

create table bbs02 (
	num number,
	id varchar2(10),
	sub varchar2(2000),
	content varchar2(2000),
	nalja date,
	num_ref number,			-- 어느 글에 대한 답변글인지 체크하기 위해 현재 글번호(시퀀스)를 다시 한번 저장
	num_no number default 0,	-- 답변글의 글번호 (기본값 : 답변글이 아닐 경우 0)
	num_lev number default 0	-- 답변글의 뎁스와 그에 따른 들여쓰기 처리
	-- (게시물의 답변글, 답변글의 답변글, 답변글의 답변글의 답변글, ..)
);

create sequence bbs02_seq;

-- dummy
insert into bbs02 (num, id, sub, content, nalja, num_ref) values (bbs02_seq.nextval, 'guest', 'test1', 'test', sysdate, bbs02_seq.currval);
-- num과 num_ref의 값을 동일하게 부여
insert into bbs02 (num, id, sub, content, nalja, num_ref) values (bbs02_seq.nextval, 'guest', 'test2', 'test', sysdate, bbs02_seq.currval);
insert into bbs02 (num, id, sub, content, nalja, num_ref) values (bbs02_seq.nextval, 'guest', 'test3', 'test', sysdate, bbs02_seq.currval);
insert into bbs02 (num, id, sub, content, nalja, num_ref) values (bbs02_seq.nextval, 'guest', 'test1', 'test', sysdate, bbs02_seq.currval);

commit;