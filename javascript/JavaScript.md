# JavaScript

Js是一门跨平台、面向对象 的脚本语言 控制网页行为 是网页能够交互

## 1.内部脚本

==将JS代码定义在HTML页面中==

在HTML中 js代码必须在<script>与</script>标签之间

~~~js
<script>
    alert("hello JS ~");
</script>
~~~

在html文档中可以在任意地方 放置任意数量的<script>

一般把脚本置于<body>元素的底部 改善显示速度 

## 2.外部脚本 

将js代码定义在外部的jss文件中 然后引入到html页面中

>引入外部js文件 
>
><script src="../js/demo.js"></script>

外部脚本不能包含<script>标签

<script>标签不能自闭合

## 3.语法

每行结尾的分号可有可无

输出语句 

>window.alert("hello JS ~"); // 弹出警告框
>
>document.write("hello JS ~"); // 写入HTML
>
>console.log("hello JS ~") ; // 写入控制台

## 4.变量

js中使用var关键字 来声明变量

1. var关键字的特点 

   ~~~html
   <script>
       /*
       1.作用域:全局变量 
       2.变量可以重复定义
       */
       {
           var age = 20;
           var age = 30;
           var age = "张三";
       }
       alert(age);
   </script>   
   ~~~

2. ES6中添加了let关键字来定义变量 用法类似于var 但是是局部变量 且不允许重复定义
3. ES6新增了const关键字 用来声明一个只读的变量 一旦声明 常量的值不允许修改 

## 5.数据类型 

js中分为原始类型和引用类型

>==原始类型==
>
>number(可表整数、小数)、string(字符、字符串、单双引)、boolean、null(对象为空)、undefined(当声明的变量没有初始化时 该变量的默认值是undefined)

## 6.函数

执行特定任务的代码块

~~~js
// 方式一：
function add(a , b) {

return a + b;

}   参数不需要类型 

调用 ： let result = add(1 , 2); js中 函数调用可以传递人一个数参数 let result = add(1 , 2, 3);
// 方式二
var add = function(a , b){
    return a + b;
}

~~~

## 7.对象

Array

~~~JS
var arr = new Array(1,2,3);
var arr2 = [1,2,3];
//访问
arr2[0] = 10;
~~~

String

~~~JS
var str1 = new String("abc");
var str2 = "abc";
var str3 = 'abc';
// trim():去除字符串前后两端的空白字符串

var str4 = '   abc   ';
alert(1 + str4.trim() + 1);// 1abc1
~~~

自定义对象

~~~js
var person={
    name:"zhangsan",
    age:23,
    eat:function(){
        alert("干饭~");
    }
};
// 访问
alert(person.name);
alert(person.age);
person.eat();
~~~

BOM对象

>浏览器对象

~~~JS
// alert
alert("abc");
// confirm,点击确定按钮 返回true 点击取消按钮 返回false
var flag = confirm("确认删除？？");
if(flag){
    // 逻辑
}

/*
定时器
setTimeout(function,毫秒值): 在一定的时间间隔后执行一个function,只执行一次
setInterval(function,毫秒值):在一定的时间间隔后执行一个function,循环执行
*/
setTimeout(function () {
    alert("hehe");
},3000);
setInterval(function () {
    alert("hehe");
},3000);

// location 跳转
document.write("3秒跳转到首页...");
setTimeout(function () {
    location.href = "https://www.baidu.com"
},3000);
~~~

DOM对象

>文档对象模型
>
>Document(整个文档对象)、Element(元素对象  标签对象)、Attribute(属性对象)、Text(文本对象)、Comment(注释对象)

参考www3cSchool吧