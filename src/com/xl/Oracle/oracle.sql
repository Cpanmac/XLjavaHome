select t.*, t.rowid from student t

--��ѯ
select * from student

--����������ѯ
select * from student where id = 1

--��������ģ����ѯ
select * from student where name like '%��%'

--�������ڷ�Χ��ѯ
select * from student where birth between  to_date('1990-1-1','yyyy-MM-dd') and  to_date('1990-12-31','yyyy-MM-dd')

--��ѯ��Ľ�� ������������ ����
select * from student order by birth desc

--ͨ���������ѧ��
insert into student values(stu_sequences.nextval,'Ǯ��',23, to_date('1990-8-9','yyyy-MM-dd'),'13555555555','�人��' )

--��ѯ��һ������
select stu_sequences.nextval from dual
--��ѯ��ǰ����
select stu_sequences.currval from dual

--����id ��������
select * from student order by id desc

--����ѧ��
update student set name='',age=,birth=to_date('1990-8-9','yyyy-MM-dd'),telphone='',address='' where id = 

--ɾ��ѧ��
delete student where id = 
