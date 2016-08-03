求一个班级数学平均分。
 select sum(math) / count(math) as 数学平均分
 from student;

 select avg(math) as 数学平均分
 from student;

 select avg(name) as XX平均分
 from student;//0

求一个班级总分平均分。
 select (sum(chinese)+sum(math)+sum(english))  /  count(*)
 from student; 
 
 select avg(chinese+math+english)
 from student;

求班级语文最高分和最低分。
select max(name),min(name)
from student;

drop table if exists teacher;
create table teacher(
   id int,
   name varchar(20),
   birthday date
);
insert into teacher(id,name,birthday) values(1,'jack','2011-1-1');
insert into teacher(id,name,birthday) values(2,'marry','2011-2-2');
insert into teacher(id,name,birthday) values(3,'sisi','2011-3-3');

select max(birthday),min(birthday)
from teacher;

对订单表中商品归类后，显示每一类商品的总价
select product as 类别名,sum(price) as 商品类别总价
from orders
group by product;

查询购买了几类商品，并且每类总价大于100的商品
select product as 类别名,sum(price) as 商品类别总价
from orders
group by product
having sum(price) > 100;
反过来会报错
where与having区别：

where主要用于行过滤器
having主要用于类别过滤器，通常有having就一定出现group by,但有group by的地方，不一定出现having。

drop table if exists teacher;
create table teacher(
   id int primary key auto_increment,
   name varchar(20) not null unique,
   birthday date
);
insert into teacher(name,birthday) values(NULL,'2011-1-1');


insert into teacher(name,birthday) values('marry','2011-2-2');
insert into teacher(id,name,birthday) values(3,'sisi','2011-3-3');

select max(birthday),min(birthday)
from teacher;

删除主键，主键在表中只有一个，要么是一列，要么是多列
alter table teacher drop primary key;

一对一关系(方案一)：
drop table if exists card;
drop table if exists person;

auto_increment自动增长，不能用在Oracle中
create table person(
 id int primary key auto_increment,
 name varchar(20) not null
);
insert into person(name) values('jack');
insert into person(name) values('marry');

constraint关键字，pid_FK给系统看的(ForeignKey)references引用
create table card(
 id int primary key auto_increment,
 location varchar(20) not null,
 pid int,
 constraint pid_FK foreign key(pid) references person(id)
);
insert into card(location,pid) values('BJ',1);
insert into card(location,pid) values('GZ',2);
insert into card(location,pid) values('CS',NULL);
insert into card(location,pid) values('NJ',3);//出错
pid的指必须来源于person或者为空

//删除person表的某记录
delete from person where name = 'jack';


一对一关系(方案二)：
drop table if exists card;
drop table if exists person;

create table person(
 id int primary key auto_increment,
 name varchar(20) not null
);
insert into person(name) values('jack');
insert into person(name) values('marry');

create table card(
 id int primary key auto_increment,
 location varchar(20) not null,
 constraint id_FK foreign key(id) references person(id)
);
insert into card(location) values('BJ');
insert into card(location) values('GZ');
insert into card(location) values('CS');//出错
insert into card(location) values(NULL);

一对多/多对一关系：
drop table if exists employee;
drop table if exists department;

create table department(
 id int primary key auto_increment,
 name varchar(20) not null
);
insert into department(name) values('软件部');
insert into department(name) values('销售部');

create table employee(
 id int primary key auto_increment,
 name varchar(20) not null,
 did int,
 constraint did_FK foreign key(did) references department(id)
);
insert into employee(name,did) values('jack',1);
insert into employee(name,did) values('marry',1);

问题？查询"软件部"的所有员工（组合式）
select d.name as 部门名,e.name as 员工名
from department as d,employee as e
where d.name = '软件部';

思考：还有没有其它方法？

分解：
(1)select id from department where name='软件部';
(2)select name from employee where did = 1;
(总)嵌入式SQL
 
  select name as 员工 
  from employee 
  where did = (
	select id 
	from department 
	where name='软件部'
  );


多对多关系：
drop table if exists middle;
drop table if exists student;
drop table if exists teacher;

create table if not exists student(
 id int primary key auto_increment,
 name varchar(20) not null
);
insert into student(name) values('jack');
insert into student(name) values('marry');

create table if not exists teacher(
 id int primary key auto_increment,
 name varchar(20) not null
);
insert into teacher(name) values('赵');
insert into teacher(name) values('蔡');

create table if not exists middle(
 sid int,
 tid int,
 constraint sid_FK foreign key(sid) references student(id),
 constraint tid_FK foreign key(tid) references teacher(id),
 primary key(sid,tid)          --组合主键
);

insert into middle(sid,tid) values(1,1);
insert into middle(sid,tid) values(1,2);
insert into middle(sid,tid) values(2,1);
insert into middle(sid,tid) values(2,2);

问题？查询"赵"所教过的所有学员
select t.name as 老师, s.name as 学员
from teacher as t,student as s,middle as m
where t.name = '赵'and m.sid=s.id and m.tid=t.id;

此时middle就是关联表，组合主键。里面存储id，先删除中间表

模式：
select 列出需要显示的字段
from 列出所涉及到的所有表，建议写别名
where 业务条件 and 表关联条件

使用MySQL特有函数：
到年底还有几少天？
select datediff('2011-12-31',now()); 

截取字符串
select substring('mysql',1,2); //从1开始,截取2个

保留小数点后2位(四舍五入)
select format(3.1415926535657989,2);  

向下取整(截取)
select floor(3.14);
select floor(-3.14);
select floor(3.54);
select floor(-3.54);

取随机值
select format(rand(),2);

取1-6之间的随机整数值
select floor(rand()*6) + 1;
 
MySQL扩展知识：

查MySQL文档，利用MySQL的函数：随机产生'a'-'z'之间的随机字符。

随机产生'a'-'z'之间的随机字符
(1)查询'a'-'z'对应的Unicode值
   select ascii('a');//97
   select ascii('z');//122

(2)产生97-122之间的随机整数
   select floor(rand()*26)+97;

(3)产生97-122对应的字符
   select char(floor(rand()*26)+97);

查MySQL文档，利用MySQL的函数：对密码'123456'进行MD5加密。
select md5('123456');

drop table user;
create table user(
 id int primary key auto_increment,
 name varchar(20),
 gender varchar(6),
 salary float
);
insert into user(name,gender,salary) values('jack','male',4000);
insert into user(name,gender,salary) values('marry','female',5000);
insert into user(name,gender,salary) values('jim','male',6000);
insert into user(name,gender,salary) values('tom','male',7000);
insert into user(name,gender,salary) values('soso','female',NULL);
insert into user(name,gender,salary) values('haha','female',3500);
insert into user(name,gender,salary) values('hehe','female',4500);
select * from user;

MySQL特有流程控制函数：
1) if(value,第一值,第二值);
value为真，取第一值，否则取第二值
将5000元（含）以上的员工标识为"高薪"，否则标识为"起薪"
类似于Java中的三目运算符

select if(salary>=5000,'高薪','起薪')
from user;

2) ifnull(value1,value2)
value1为NULL，用value2替代
将薪水为NULL的员工标识为"无薪"

select name as 员工,ifnull(salary,'无薪') as 薪水情况
from user;

3) case when [value] then [result1] else [result2] end;
当value表达式的值为true时，取result1的值，否则取result2的值(if...else...)
将5000元（含）以上的员工标识为"高薪"，否则标识为"起薪"

select 
	case when salary>=5000 then '高薪'
        else '起薪' end
from user; 

4) case [express] when [value1] then [result1] when [value2] then [result2] else [result3] end;
当express满足value1时，取result1的值，满足value2时，取result2的值，否则取result3的值(switch...case..)
将7000元的员工标识为"高薪"，6000元的员工标识为"中薪",5000元则标识为"起薪"，否则标识为"低薪"

select 
	case salary 
		when 7000 then '高薪'
		when 6000 then '中薪'
		when 5000 then '起薪'
		else '低薪' end
from user;

课堂练习：

	1)查询相同性别的员工总人数>2的工资总和，并按工资总和降序排列
		select count(*) as 员人数,gender as 性别,sum(salary) as 工资和
		from user
                group by gender
		having count(*)>2
 		order by sum(salary) desc;
 		
	2)将性别为男的员工工资-1000，性别为女的员工工资+1000,在一条SQL上完成	
		select if(gender='female',salary+1000,salary-1000) as 工资 from user; 

1 JDBC程序的开发步骤快速入门

2 JDBC程序的重构

3 使用JDBC进行无参/有参CURD操作



























  课后练习：

	1)写一个用于创建表和删除表的JDBC应用程序
		create table 
		drop table
		Statement.execute():boolean	
	提示：
	  JdbcUtil
      		public void createTable(String tableName){...} 
	        public void dropTable(String tableName){...}



4 Statement引入的SQL注入问题(' or true or ')

  思考：如何解决上述问题。

5 使用PreparedStatement重构CURD操作

6 DAO单例工厂设计模式+属性文件配置 

7 用户登录[Jsp+Servlet+JavaBean+Jdbc+Mysql]

