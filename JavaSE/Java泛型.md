# Java泛型

## 用泛型表示类

泛型可以加到类上面 来表示这个类的类型

```java
// 这里的T可以写任意标识 常见的T、E、K等
public class GenericDemo<T>{

 // T的类型由外部确定 
 private T value;
 public GenericDemo(T value) {
 this.value = value;
 }
    // T由外部确定
 public T getValue() {
      return value;
 }
 public void setValue(T value){
 this.value = value
 }
}
```

## 用泛型标识接口 

```java
// 定义泛型接口 
public interface Generator<T> {
    public T next();
}
```

## 泛型方法

```java

public class TestFX {
    /**
     * 返回第一个元素
     * @param a
     * @param <T> 声明一个类型
     * @return
     */
    public static <T> T getFirst(T... a) {
        return a[0];
    }
 
    public static void main(String[] args) {
 
        //调用泛型方法时，在方法名前的尖括号中放入具体的类型
        String first1 = TestFX.<String>getFirst("AAA", "BBB");
        System.out.println(first1);
 
        //调用泛型方法时，在方法名前的尖括号中放入具体的类型
        Integer first2 = TestFX.<Integer>getFirst(123, 456);
        System.out.println(first2);
 
        //大多数情况下，方法调用可以省略<T>，编译器有足够信息推断出调用的方法，
        //这里利用形参的类型String[]与泛型类型T[]匹配，推断出T是String
        //故可以调用：
        String first3 = TestFX.getFirst("AAA", "BBB");
        System.out.println(first3);
 
        Integer first4 = TestFX.getFirst(123, 456);
        System.out.println(first4);
    }
}
```

## 泛型通配符

表示各种泛型的父类 它的元素类型可以匹配任何类型。

```java
public static void main(String[] args) {
 List<String> name = new ArrayList<String>();
 List<Integer> age = new ArrayList<Integer>();
 List<Number> number = new ArrayList<Number>();
 name.add("cxuan");
 age.add(18);
 number.add(314);
 generic(name);
 generic(age);
 generic(number); 
}
public static void generic(List<?> data) {
 System.out.println("Test cxuan :" + data.get(0));
}

上界通配符:<? extends ClassType>该通配符为ClassType 的所有子类型。它表示的是任何类型都是ClassType类型的子类。
下界通配符:<? super ClassType>该通配符为ClassType的所有超类型。它表示的是任何类型的父类都是ClassType。
```

