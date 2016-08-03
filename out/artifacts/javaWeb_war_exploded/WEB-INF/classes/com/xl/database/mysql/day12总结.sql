0 合计函数
  avg()
  max(),min()，当max()和min()函数位于日期类型时，分别取得最近日期和最早日期

1 表的完整性
  (1)实体完整性：每条记录有一个唯一标识符，通常用无任何业务含义的字段表示
  (2)参照完整性：一张表的某个字段必须引用另一张表的某个字段值
  (3)域完整性：域即单元数据，域中的数值必须符合一定的规则

2 键的概念
  (1)主键：只有唯一字段
  (2)组合主键：由多个字段组合起来，形成唯一字段
  (3)外键：针对多张表之间的关联

3 主键的特点
  (1)主键不能重复
  (2)主键不能为NULL
  (3)auto_increment是MySQL特有的，默认从1开始，该ID值与表同生亡
  (4)多人项目中，通常使用UUID来生成唯一的主键值，便于多个合并数据时依然保持实体完整性

4 唯一约束的特点
  (1)非NULL值不能重复
  (2)可以插入多个NULL值
  (3)'NULL'空串和NULL是不同的概念 

5 非空约束特点
  (1)不能插入NULL值
  (2)主键约束=非NULL约束+唯一约束

6 外健特点
  (1)外键值必须来源于所引用别一个表主键值，或NULL
  
*7 关联关系
  (1)一对一(外健根业务有关)  
  (2)一对多或多对一(外键放置在多方)
  (3)多对多(外健放置在关联表中，即将一个多对多拆分成二个一对多关系)
 
8 什么是JDBC？为什么使用JDBC
  1)SUN公司为使Java程序灵活的访问各种不同的关系型数据库提供的规则。
  2)为什么使用JDBC？
	a)降低Java程序操作数据库的成本
	b)使Java程序灵活移植


*9 祥解JDBC连接数据库的各个步骤
  1)注册驱动：DriverManager.registerDriver(new com.mysql.jdbc.Driver());
    java.sql.Driver(接口)-com.mysql.jdbc.Driver(实现类)
	 (首先返回true)boolean acceptsURL(String url) 
        	  查询驱动程序是否认为它可以打开到给定 URL 的连接。 
	 (然后)Connection connect(String url, Properties info) 
         	 试图创建一个到给定 URL 的数据库连接。 

    注意：上述代码会向DriverManager注册二次相同的MySQL驱动，其中一次在Driver实现类中
    项目中推荐使用以下代码间接注册数据库驱动：
	Class.forName("com.mysql.jdbc.Driver");

	优点：
		a)只注册一次
		b)无需导入与具体数据库驱动相关的包
   
  2)获取数据库连接对象：
	Connection conn = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/mydb2","root","root");	  
  
  3)关闭流
    a)依次按resul->statement->connection顺序关闭
    b)在能完成业务的情况下，尽早关闭
  

*10 JDBC的六个固定步骤
   1，注册数据库驱动[利用反射]
   2，取得数据库连接对象Connection
   3，创建SQL对象
   4，执行SQL命令，并返回结果集
   5，处理结果集
   6，依次关闭结果集	 

*11 使用JDBC完成CURD操作
   insert/update/delete----Statement.executeUpdate(sql)：返回值表示影响记录的行数
   select------------------Statement.exeucteQuery():返回值表示符合条件的记录	
   create------------------ ? 
   drop-------------------- ?














