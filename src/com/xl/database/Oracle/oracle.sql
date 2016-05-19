select t.*, t.rowid from student t

--查询
select * from student

--根据主键查询
select * from student where id = 1

--根据姓名模糊查询
select * from student where name like '%三%'

--根据日期范围查询
select * from student where birth between  to_date('1990-1-1','yyyy-MM-dd') and  to_date('1990-12-31','yyyy-MM-dd')

--查询后的结果 根据年龄排序 降序
select * from student order by birth desc

--通过序列添加学生
insert into student values(stu_sequences.nextval,'钱七',23, to_date('1990-8-9','yyyy-MM-dd'),'13555555555','武汉市' )

--查询下一个序列
select stu_sequences.nextval from dual
--查询当前序列
select stu_sequences.currval from dual

--根据id 降序排列
select * from student order by id desc

--更新学生
update student set name='',age=,birth=to_date('1990-8-9','yyyy-MM-dd'),telphone='',address='' where id = 

--删除学生
delete student where id = 
