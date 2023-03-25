# MySQL

## 概念模型的术语

## 🐬**实体**

实体(Entity)是指客观存在并可相互区分的事物，如学生、班级、课程。

## 🐬**属性**

属性(Attribute)是指实体所具有的某一特性，一个实体可以由若干个属性来描述。

eg： 学生的实体属性有学号 、学生姓名等。属性由两部分组成 属性名和属性值

# SQL分类

默认字符集使用的 UTF-8

## DCL 

数据定义语言，用来定义数据库对象(数据库，表，字段)

### 创建数据库

```sql
create database [if not exists] 数据库名 [default charset utf-8]
eg: create database if not exists selfDB default charset utf8mb4

```

## 数据类型

### 数值类型

![image-20230325161230321](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303251612444.png)

- 年龄字段 -- 不会出现负数 而且人的年龄不会太大 

  ```sql
  age tinyint unsigned
  ```

- 分数 -- 总分 100分 最多出现以为小数

  ```sql
  score doble(4,1)
  ```

### 字符串类型

![image-20230325161541121](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303251615175.png)

其中 char与varchar描述字符串 char是定长字符串 指定长度多长，就占用多少个字符，和字段值的长度无关 。而varchar是变长字符串，指定的长度为最大占用长度 。相对来说，char的性能会更高些。

```sql
1). 用户名 username ------> 长度不定, 最长不会超过50
username varchar(50)
2). 性别 gender ---------> 存储值, 不是男,就是女
gender char(1)
3). 手机号 phone --------> 固定长度为11
phone char(11)
```

### 日期时间类型

![image-20230325161917423](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303251619468.png)



## DML

数据操作语言，用来对数据库表中的数据进行增删改



## DQL

数据查询语言，用来查询数据库中表的记录

### 查询语法

```sql
select 字段列表 from 表名列表
where 条件列表 group by 分组字段列表
having 分组后条件列表
order by 排序字段列表
limit 分页参数
```

### 关于聚合函数

将一列数据作为一个整体 进行纵向计算

| 函数  | 功能     |
| ----- | -------- |
| count | 统计数量 |
| max   | 最大值   |
| min   | 最小值   |
| avg   | 平均值   |
| sum   | 求和     |



```sql
select 聚合函数(字段列表) from 表名;
# NULL值不参与所有聚合函数运算的
```

```sql
eg： 统计企业员工数量
select count(*) from emp;-- 统计的是总记录数
select count(idCard) from emp; -- 统计的是idCard字段不为null的记录数

# 对于count聚合函数，统计符合条件的总记录数，还可以通过 count(数字或者字符串)的形式进行统计查询
select count(1) from emp;

select avg(age) from emp; # 统计员工的平均年龄
select max(age) from emp; # 统计员工的最大年龄
select min(age) from emp; # 统计员工的最小年龄
select sum(age) from emp where workaddress = "西安" ; 
```

### 分组查询

```sql
select 字段列表 from 表名 where 条件 group by 分组字段名 having 分组后的过滤条件
```

- where 与having区别

  执行时机不同： where 是分组之前进行过滤 不满足where条件 不参与分组；而having是分组之后对结果进行过滤

- 注意事项

  分组之后 查询的字段一般为聚合函数和分组字段 查询其他字段没有意义

  执行顺序 ： where > 聚合函数 > having

  支持多字段分组 。group by columA，columnB

``` sql
# 根据性别分组 统计男性员工和女性员工的数量
select gender, count(*) from emp group by gender ; 
# 根据性别分组 , 统计男性员工 和 女性员工的平均年龄
select gender, avg(age) from emp group by gender ;
# 查询年龄小于45的员工 , 并根据工作地址分组 , 获取员工数量大于等于3的工作地址
select workaddress, count(*) address_count from emp where age < 45 group by workaddress having address_count >= 3;

# 统计各个工作地址上班的男性以及女性员工的数量
select workaddress , gender ,count(*) '数量' from emp group by gender , workaddress;
```

### 排序查询

```sql
# 根据年龄对公司的员工进行升序排序 , 年龄相同 , 再按照入职时间进行降序排序
select * from emp order by age asc , entrydate desc
```

### 分页查询

语法

>select 字段列表 from 表名 limit 起始索引 ,  查询记录数;

- ==起始索引从0开始 起始索引 = (查询页码 - 1) * 每页显示记录数==
- 查询第一页数据 起始索引可以省略 直接简写为 limit 10;

```sql
# 查询第1页员工数据 每页展示10条记录
select * from emp limit 0 , 10;
select * from emp limit 10;
```

```sql
# 查询年龄为 20，21，22，23的员工信息
select * from emp where gender = '女' and age in (20,21,22,23);
# 查询性别为男 ，并且年龄在 20 - 40岁以内的 姓名为 三个字的员工
select * from emp where gender = '男' and ( age between 20 and 40 ) and name like '___';
# 统计员工表中 年龄小于60岁的 男性员工和 女性员工的总人数
select gender, count(*) from emp where age < 60 group by gender;
# 查询性别为男，且年龄在20-40 岁(含)以内的前5个员工信息，对查询的结果按年龄升序排序，年龄相同按入职时间升序排序。
select * from emp where gender = '男' and age between 20 and 40 order by age asc ,entrydate asc limit 5 ;
```

### 多表查询

#### 连接查询

1. 内连接 ： 相当于查询 A、B交际部分数据

   ![image-20230325212805302](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303252128351.png)

   - 隐式内连接

     >select 字段列表 from 表1，表2 where 条件.......

     ```sql
     select e.name,d.name from emp e , dept d where e.dept_id = d.id;
     ```

   - 显示内连接

     >SELECT 字段列表 FROM 表1 [ INNER ] JOIN 表2 ON 连接条件 ... ;

     ```sql
     select e.name, d.name from emp e join dept d on e.dept_id = d.id;
     ```

2. 外连接

   ![image-20230325213201351](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303252132397.png)

   - 左外连接

     左外连接相当于查询表1(左表)的所有数据，当然也包含表1和表2交集部分的数据。

     >SELECT 字段列表 FROM 表1 LEFT [ OUTER ] JOIN 表2 ON 条件 ... ; 

     ```sql
      查询emp表的所有数据, 和对应的部门信息
      由于需求中提到，要查询emp的所有数据，所以是不能内连接查询的，需要 考虑使用外连接查询。
      
      select e.*, d.name from emp e left join dept d on e.dept_id = d.id; 或者
      select e.*, d.name from emp e left outer join dept d on e.dept_id = d.id;
     ```

     

   - 右外连接

     右外连接相当于查询表2(右表)的所有数据，当然也包含表1和表2交集部分的数据。

     >SELECT 字段列表 FROM 表1 RIGHT [ OUTER ] JOIN 表2 ON 条件 ... 

     ```sql
     查询dept表的所有数据, 和对应的员工信息(右外连接)  由于需求中提到，要查询dept表的所有数据，所以是不能内连接查询的，需要考虑使用外连接查询。
     select d.*, e.* from emp e right outer join dept d on e.dept_id = d.id;  或者 
     select d.*, e.* from dept d left outer join emp e on e.dept_id = d.id;
     ```

   >左外连接和右外连接是可以相互替换的，只需要调整在连接查询时SQL中，表结构的先后顺序就可以了。而我们在日常开发使用时，更偏向于左外连接。

3. 左外连接： 查询左表所有数据，以及两张表交集部分数据

4. 右外连接 :  插叙右表所有数据 以及两张表交集部部分数据

5. 自连接： 当前表与自身的连接查询 自连接必须使用别名

#### 联合查询

union查询，就是把多次查询的结果合并起来，形成一个新的查询结果集。

```sql
SELECT 字段列表 FROM 表A ...
UNION [ ALL ]
SELECT 字段列表 FROM 表B ....;
```

>对于联合查询的多张表的列数必须保持一致，字段类型也需要保持一致。
>
>union all 会将全部的数据直接合并在一起，union 会对合并之后的数据去重。

-  将薪资低于 5000 的员工 , 和 年龄大于 50 岁的员工全部查询出来.

  ```sql
  select * from emp where salary < 5000
  union (all) # 加了all 不会对查询出来的结果进行去重处理。
  select * from emp where age > 50;
  ```

>如果多条查询语句查询出来的结果，字段数量不一致，在进行union/union all联合查询时，将会报错。

#### 子查询

SQL语句中嵌套SELECT语句，称为嵌套查询，又称子查询。

```sql
SELECT * FROM t1 WHERE column1 = ( SELECT column1 FROM t2 );
```

根据子查询结果不同，分为：

- 标量子查询（子查询结果为单个值）

  >子查询返回的结果是单个值（数字、字符串、日期等），最简单的形式，这种子查询称为标量子查询。常用的操作符：= <> > >= < <= 

  ```sql
  # 查询 "销售部" 的所有员工信息
  select * from emp where dept_id = (select id from dept where name = '销售部');
  # 查询在 "方东白" 入职之后的员工信息
  select * from emp where entrydate > (select entrydate from emp where name = '方东白');
  ```

- 列子查询(子查询结果为一列)

  ![image-20230325215310266](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303252153319.png)

  >子查询返回的结果是一列（可以是多行），这种子查询称为列子查询。
  >
  >常用的操作符：IN 、NOT IN 、 ANY 、SOME 、 ALL

  ```sql
  # 查询 "销售部" 和 "市场部" 的所有员工信息
  select * from emp where dept_id in (select id from dept where name = '销售部' or name = '市场部');
  
  # 查询比 财务部 所有人工资都高的员工信息
  select * from emp where salary > all ( select salary from emp where dept_id = (select id from dept where name = '财务部') );
  ```

- 行子查询(子查询结果为一行)

  >子查询返回的结果是一行（可以是多列），这种子查询称为行子查询。
  >
  >常用的操作符：= 、<> 、IN 、NOT IN

  ```sql
  # 查询与 "张无忌" 的薪资及直属领导相同的员工信息 ;
  select * from emp where (salary,managerid) = (select salary, managerid from emp where name = '张无忌');
  ```

- 表子查询(子查询结果为多行多列)

  >子查询返回的结果是多行多列，这种子查询称为表子查询。常用的操作符：IN

  ```sql
  # 查询与 "鹿杖客" , "宋远桥" 的职位和薪资相同的员工信息
  select * from emp where (job,salary) in ( select job, salary from emp where name = '鹿杖客' or name = '宋远桥' );
  
  # 查询入职日期是 "2006-01-01" 之后的员工信息 , 及其部门信息
  select e.*, d.* from (select * from emp where entrydate > '2006-01-01') e left join dept d on e.dept_id = d.id ;
  ```

## DCL

数据控制语言，用来创建数据库用户、控制数据库的访问权限

1. 查询用户

   ```sql
   select * from mysql.user;
   ```

2. 创建用户

   ```sql
   create user '用户名'@'主机名' IDENTIFIED BY '密码'
   
   eg: create user 'self'@'%' identified by '779500' # 该用户可以任意主机访问数据库 
   ```

3. 修改用户密码

   ```sql
   ALTER USER '用户名'@'主机名' IDENTIFIED WITH mysql_native_password BY '新密码' ;
   
   eg: alter user 'heima'@'%' identified with mysql_native_password by '1234';
   ```

4. 删除用户

   ```sql
   DROP USER '用户名'@'主机名' ;
   
   eg: drop user 'itcast'@'localhost';
   ```

>在MySQL中需要通过用户名@主机名的方式，来唯一标识一个用户。
>
>主机名可以使用 % 通配。

### 权限控制

![image-20230325211303450](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303252113580.png)

1. 查询权限

   ```sql
   SHOW GRANTS FOR '用户名'@'主机名' ;
   
   eg: show grants for 'self'@'%'
   ```

2. 授予权限

   ```sql
   GRANT 权限列表 ON 数据库名.表名 TO '用户名'@'主机名';
   
   # 授予 'self'@'%'用户itcast数据库所有表的所有操作权限
   grant all on itcast.* to 'self'@'%';
   ```

3. 撤销权限

   ```sql
   REVOKE 权限列表 ON 数据库名.表名 FROM '用户名'@'主机名';
   
   eg: revoke all on itcast.* from 'heima'@'%';
   ```

   >多个权限之间，使用逗号分隔
   >
   >授权时， 数据库名和表名可以使用 * 进行通配，代表所有。

   

# 索引

帮助 mysql高效获取数据的数据结构(有序)。在数据之外，数据库系统还维护着满足特定查找算法的数据结构，这些数据结构以某种方式引用（指向）数据， 这样就可以在这些数据结构上实现高级查找算法，这种数据结构就是索引。

![image-20230326015334719](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303260153772.png)

## 结构

![image-20230326015448997](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303260154055.png)

![image-20230326015512240](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303260155290.png)

## 二叉树

在 MySQL的索引结构中 选择 B+Tree作为索引结构

选择二叉树作为索引结构会存在：

>顺序插入时，会形成一个链表，查询性能大大降低。
>
>大数据量情况下，层级较深，检索速度慢。

选择红黑树作为索引结构 会存在：

>大数据量情况下，层级较深，检索速度慢。

## B-Tree

B-Tree，B树是一种多叉路衡查找树，相对于二叉树，B树每个节点可以有多个分支，即多叉。以一颗最大度数（max-degree）为5(5阶)的b-tree为例，那这个B树每个节点最多存储4个key，5个指针

## B+Tree

B-Tree的变种

B+Tree 与 B-Tree相比，主要有以下三点区别：

>- 所有的数据都会出现在叶子节点。
>- 叶子节点形成一个单向链表。
>- 非叶子节点仅仅起到索引数据作用，具体的数据都是在叶子节点存放的。

## Hash

哈希索引就是采用一定的hash算法 将键值换算成新的hash值 映射到对应的槽位上，然后存储在hash表中

特点

>-  Hash索引只能用于对等比较(=，in)，不支持范围查询（between，>，< ，...）
>- 无法利用索引完成排序操作
>- 查询效率高，通常(不存在hash冲突的情况)只需要一次检索就可以了，效率通常要高于B+tree索引

存储库支持

在MySQL中，支持hash索引的是Memory存储引擎。 而InnoDB中具有自适应hash功能，hash索引是InnoDB存储引擎根据B+Tree索引在指定条件下自动构建的。

## 索引分类

![image-20230326020644121](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303260206185.png)

### 聚集索引 二级索引

在InnoDB存储引擎中，根据索引的存储形式，又可以分为以下两种：

| 分类                     | 含义                                                       | 特点                |
| ------------------------ | ---------------------------------------------------------- | ------------------- |
| 聚集索引(ClusteredIndex) | 将数据存储与索引放到了一块，索引结构的叶子节点保存了行数据 | 必须有,而且只有一个 |
| 二级索引(SecondaryIndex) | 将数据与索引分开存储，索引结构的叶子节点关联的是对应的主键 | 可以存在多个        |

聚集索引选取规则：

如果存在索引 主键索引就是聚集索引

如果不存在主键，将使用第一个唯一（UNIQUE）索引作为聚集索引。

如果表没有主键，或没有合适的唯一索引，则InnoDB会自动生成一个rowid作为隐藏的聚集索引。

### 索引语法

#### 创建索引

```sql
CREATE [ UNIQUE | FULLTEXT ] INDEX index_name ON table_name (
index_col_name,... ) ;

eg: CREATE INDEX idx_user_name ON tb_user(name);
```

#### 查看索引

```sql
SHOW INDEX FROM table_name ;

eg： show index from tb_user;
```

####  删除索引

```sql
DROP INDEX index_name ON table_name ;
```



# 事务

事务 是一组操作的集合，它是一个不可分割的工作单位，事务会把所有的操作作为一个整体一起向系统提交或撤销操作请求，即这些操作要么同时成功，要么同时失败。

## 控制事务一

1. 查看 / 设置事务提交方式

   ```sql
   select @@autocommit ;
   set @@autocommit = 0;
   ```

2. 提交事务

   ```sql
   commit;
   ```

3. 回滚事务

   ```sql
   rollback;
   ```

>注意：上述的这种方式，我们是修改了事务的自动提交行为, 把默认的自动提交修改为了手动提交, 此时我们执行的DML语句都不会提交, 需要手动的执行commit进行提交。

## 控制事务二

1. 开启事务

   ```sql
   START TRANSACTION 或 BEGIN;
   ```

2. 提交事务

   ```sql
   COMMIT;
   ```

3. 回滚事务

   ```sql
   ROLLBACK;
   ```

```sql
-- 开启事务
start transaction
-- 1. 查询张三余额
select * from account where name = '张三';
-- 2. 张三的余额减少1000
update account set money = money - 1000 where name = '张三';
-- 3. 李四的余额增加1000
update account set money = money + 1000 where name = '李四';
-- 如果正常执行完毕, 则提交事务
commit;
-- 如果执行过程中报错, 则回滚事务
-- rollback;
```

## 事务四大特性（ACID）

- 原子性（Atomicity）：事务是不可分割的最小操作单元，要么全部成功，要么全部失败。
- 一致性（Consistency）：事务完成时，必须使所有的数据都保持一致状态。
- 隔离性（Isolation）：数据库系统提供的隔离机制，保证事务在不受外部并发操作影响的独立环境下运行。
- 持久性（Durability）：事务一旦提交或回滚，它对数据库中的数据的改变就是永久的。

# 存储引擎

>存储引擎就是存储数据、建立索引、更新/查询数据等技术的实现方式 。存储引擎是基于表的，而不是基于库的，所以存储引擎也可被称为表类型。我们可以在创建表的时候，来指定选择的存储引擎，如果没有指定将自动选择默认的存储引擎。

默认存储引擎就是 InnoDB

```sql
# 建表时指定存储引擎
CREATE TABLE 表名(
字段1 字段1类型 [ COMMENT 字段1注释 ] ,
......
字段n 字段n类型 [COMMENT 字段n注释 ]
) ENGINE = INNODB [ COMMENT 表注释 ] ;

# 查询当前数据库支持的存储引擎
show engines;
```

## 三种存储引擎

### 1、InnoDB

mysql的默认存储引擎

InnoDB是一种兼顾高可靠性和高性能的通用存储引擎

>DML操作遵循ACID模型，支持事务；
>
>行级锁，提高并发访问性能；
>
>支持外键FOREIGN KEY约束，保证数据的完整性和正确性；

>xxx.ibd : xxx代表的是表名 innoDB引擎的每张表都会对应这样一个表空间文件，存储该表的表结构（frm-早期的 、sdi-新版的）、数据和索引。

### 2、MyISAM

>不支持事务，不支持外键
>
>支持表锁，不支持行锁
>
>访问速度快

### 3、 Memory

>内存存放
>
> hash索引（默认）

![image-20230326014229171](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303260142238.png)



# canal实现数据同步