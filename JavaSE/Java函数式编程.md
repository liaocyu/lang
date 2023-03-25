# Java函数式编程

java8中的三种函数式编程

## 1.函数式编程

不赘述

## 2.lambda表达式

直接看这部分代码

```java
//1. lambda表达式的完整形态：有输入参数，有返回值，有代码块。
(int a, int b) -> {
 int c = a + b;
 return c;
}
//2. lambda表达式在某些情况也可以省略一部分
 //2.1 当代码块不需要返回值的 时候可以省略return语句
  (int a, int b) -> {
  int c = a + b;
 }
 //2.2 当代码块只有一句的时候可以省略大括号
  //并且这种情况默认返回这一句代码的执行结果
 (int a, int b) -> a + b; // 同1具有同样的作用
 //2.3 形参的类型可以根据函数式接口的里面的方法声明自行推断
  //可以省略形参类型
 (a, b) -> a + b; // 同1，2.2具有同样的效果
 //2.4 当只有一个参数的时候可以省略，形参的小括号
 a -> a * a;
```

具体案例

```java
public class Test1 {

 private int a = 1;
 private int b = 2;

 public int add1(IAdd add){
  return add.add(a,b);
 }
    
 public static void main(String[] args) {
  Test1 test1 = new Test1();
  // 使用lambda表达式
  int c = test1.add1((a, b) -> a + b);
  System.out.println(c);
  // 使用匿名类
  int d = test1.add1(new IAdd(){
   @Override
   public int add(int a, int b){
    return a + b;
   }
  });
  System.out.println(d);
 }
}


@FunctionalInterface
public interface IAdd {
 int add(int a, int b);
}
```



例子二 

```java
public class Test(){
 public static void main(String[] args) {
  Thread t1 = new Thread(new Runable(){
   System.out.println("使用匿名类的方式创建线程");
  });

  Thread t2 = new Thread( () -> System.out.println("使用lambda方式创建线程"));

  t1.start();
  t2.start();
 
 } 
}
```

## 3.双冒号：：符号

它的语法规则如下

>类名::静态方法名 或者 类的实例::实例方法

```java
List<File> list = new ArrayList<>;
list.forEach(File::getName); // 使用双冒号传递一个函数进来,
list.forEach( file -> file.getName()); // 使用正常的lambda表达式
```

## 4.OPtional类

它给予我们更加优雅的方式来处理Java语言中的NPE异常。

### 相关接口 

>- empty 创建一个空的Optional对象
>- of 和ofNullable

of创建一个Optional对象, 如果传入的参数为空则跑出NPE异常.
ofNullable和上面一样, 但是当传入参数为空的时候会调用empty方法创建一个空Optional对象.

```java
Optional<String> of = Optional.of("waxxd");
// 传入空参数会抛出NullPointerException异常
Optional<String> ofNull = Optional.of(null); 
// 以下两句都正常执行
Optional<String> ofNullable = Optional.ofNullable("waxxd");
// 参数为空的时候相当调用Optional.empty()
Optional<String> ofNullableNull = Optional.ofNullable(null); 
```

get/orElse/orElseGet/orElseThrow

```java
// get 获取Option包裹的值如果值为null则抛出NoSuchElementException异常
String aa = Optional.of("aa").get();
// orElse 获取值如果值为空则返回orElse设置的默认值
String aa1 = Optional.of("aa").orElse("bb");
// orElseGet 获取值如果值为空则内部可以是一个实现Supplier接口的匿名内部类调用提供返回结果
String aa2 = Optional.of("aa").orElseGet( () -> "aaa".toUpperCase());
// orElseThrow获取值如果不存在则抛出后面的异常
Optional.empty().orElseThrow(IllegalArgumentException::new);

// 实际的应用, 也就是上文所说的如何优化if
// 比如你有个接口, 用户传入参数Integer type, 用户也可以选择不传, 不传我们为它设置默认值1
public void f(Integer type){
	if(type = null) {
		type = 1;
	}
	
	Optional.ofNullable(type).orElse(1);
}
```

