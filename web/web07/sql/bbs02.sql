drop table bbs02;
drop sequence bbs02_seq;

create table bbs02 (
	num number,
	id varchar2(10),
	sub varchar2(2000),
	content varchar2(2000),
	nalja date,
	num_ref number,			-- ��� �ۿ� ���� �亯������ üũ�ϱ� ���� ���� �۹�ȣ(������)�� �ٽ� �ѹ� ����
	num_no number default 0,	-- �亯���� �۹�ȣ (�⺻�� : �亯���� �ƴ� ��� 0)
	num_lev number default 0	-- �亯���� ������ �׿� ���� �鿩���� ó��
	-- (�Խù��� �亯��, �亯���� �亯��, �亯���� �亯���� �亯��, ..)
);

create sequence bbs02_seq;

-- dummy
insert into bbs02 (num, id, sub, content, nalja, num_ref) values (bbs02_seq.nextval, 'guest', 'test1', 'test', sysdate, bbs02_seq.currval);
-- num�� num_ref�� ���� �����ϰ� �ο�
insert into bbs02 (num, id, sub, content, nalja, num_ref) values (bbs02_seq.nextval, 'guest', 'test2', 'test', sysdate, bbs02_seq.currval);
insert into bbs02 (num, id, sub, content, nalja, num_ref) values (bbs02_seq.nextval, 'guest', 'test3', 'test', sysdate, bbs02_seq.currval);
insert into bbs02 (num, id, sub, content, nalja, num_ref) values (bbs02_seq.nextval, 'guest', 'test1', 'test', sysdate, bbs02_seq.currval);

commit;