# JVM面试

## ReadME

### Jvm的位置

![image-20230326194126282](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303261941345.png)

jvm是运行在操作系统之上的 它与硬件没有直接的交互 

### 整体结构

![image-20230326194243539](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303261942640.png)

![image-20230326194447393](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303261944442.png)

### 一些命令

#### 查看字节码的指令

>javap -v ***.class 

### jvm中一些设置的命令

#### 设置栈内存大小

>使用参数 `-Xss` 选项设置线程的最大占空间 栈的大小直接决定了函数调用的最大可达深度
>
>也可以使用 `-XX:ThreadStackSize=2m` 这也表示将虚拟机栈的大小设置为 2 MB
>
>eg: `-Xss256k`

****

### 内存泄漏

在程序运行过程中，因为某些原因导致不再使用的内存没有被及时释放，从而导致程序运行时所占用的内存越来越多，直至耗尽系统的可用内存。

造成原因： 程序中存在一些无用的对象或引用没有被正确处理，使得这些对象无法被垃圾回收器回收，从而占用了系统的内存资源。

```java
import java.util.ArrayList;
import java.util.List;

public class MemoryLeakDemo {
    private static List<byte[]> list = new ArrayList<byte[]>();
    public static void main(String[] args) {
        while (true) {
            list.add(new byte[1024*1024]);
        }
    }
}

// 程序会不断创建一个大小为 1MB的 byte数组并添加到一个 List集合中 由于没有对这些byte数组进行任何操作和释放，他们会不断地占用系统内存，从而导致内存泄漏问题
```

### 内存溢出

程序运行时需要申请更多的内存，但系统内存已经耗尽，无法再分配更多的内存空间。

内存溢出的原因通常是程序中存在某些内存申请不当或者内存使用过度等问题，使得系统内存不足，无法满足程序的需要。

```java
public class OutOfMemoryDemo {
    public static void main(String[] args) {
        String s = "OutOfMemoryError";
        while (true) {
            s += s;
        }
    }
}

// 程序会不断地将字符串s与自身连接 使得字符串s的长度不断增加 从而导致内存占用不断增加 最终导致内存溢出问题

// 使用 -Xss128k设置栈的大小
public class StackErrorDemo1 {

    private static int count = 1;

    public static void main(String[] args) {
        System.out.println(count);
        count++;
        main(args);
    }
}
```



## JVM类加载过程

==这张图需要会画的==

![image-20230326195754464](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303261957542.png)

运行时数据区具体结构【重要】。这里的执行引擎的作用是将字节码文件翻译成机器指令去执行。本地方法接口可以调用C或者C++的api

![image-20230327194209823](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303271942217.png)

- Class文件 
- 类加载子系统
- 执行引擎
- 本地方法库
- 运行时数据区
  - 方法区
  - 堆
  - 程序计数器
  - 虚拟机栈
  - 本地方法栈

### 类加载器ClassLoader

#### 加载阶段

>目的在于将class文件加载到内存中去 出现异常会将其抛出去

![image-20230326200329325](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303262017247.png)

过程

>1. 通过一个类的全限定名获取定义此类的二进制字节流
>2. 将这个字节流所代表的静态存储结构转化为方法区的运行时数据结构
>3. 在内存中生成一个代表这个类的java.lang.Class对象，作为方法区这个
>     的各种数据的访问入口

#### 链接阶段

- **验证（Verify）**： 
- - 目的在确保Class文件的字节流中包含信息符合当前虚拟机要求，保证被加载类的正确性，不会危害虚拟机自身安全。
- - 主要包括四种验证，文件格式验证，元数据验证，字节码验证，符号引用验证。
- **准备（Prepare）**： 
- - ==为类变量分配内存并且设置该类变量的默认初始值，即零值。== (char类型的默认值是 '\u000')
- - 这里不包含用final修饰的static，因为final在编译的时候就会分配了，准备阶段会显式初始化；
- - 这里不会为实例变量分配初始化，类变量会分配在方法区中，而实例变量是会随着对象一起分配到Java堆中。
- **解析（Resolve）**： 
- - 将常量池内的符号引用转换为直接引用的过程。
  - 事实上，解析操作往往会伴随着JVM在执行完初始化之后再执行。
  - 符号引用就是一组符号来描述所引用的目标。符号引用的字面量形式明确定义在《java虚拟机规范》的Class文件格式中。直接引用就是直接指向目标的指针、相对偏移量或一个间接定位到目标的句柄。
  - 解析动作主要针对类或接口、字段、类方法、接口方法、方法类型等。对应常量池中的CONSTANT_Class_info，CONSTANT_Fieldref_info、CONSTANT_Methodref_info等。

#### 初始化

- 初始化阶段就是执行类构造器方法<clinit>()的过程
- 此方法不需定义，是javac编译器自动收集类中的所有类变量的赋值动作和静
  态代码块中的语句合并而来
- 构造器方法中指令按语句在源文件中出现的顺序执行。
- <c1init>()不同于类的构造器。（关联：构造器是虚拟机视角下的<init>())
- 若该类具有父类，JVM会保证子类的<c1init>()执行前，父类的<clinit>()
  已经执行完毕
- 虚拟机必须保证一个类的<clinit>()方法在多线程下被同步加锁

### 运行时数据区内部结构



## JVM内存模型

![image-20230327194412199](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303271944263.png)

class文件通过类加载子系统进行加载、经历过 load(加载)、link(链接)、initialize(初始化)进行加载。加载完成后就在方法区保存了内的实例本身。然后使用run engine(执行引擎)去执行，用完之后使用GC(垃圾回收)

一个进程包括多个线程 堆空间和方法区是进程间（也就是各个线程间）共用的，但是程序计数器（Program Counter Registere）、本地方法栈（Native Method s、Stack）、虚拟机栈（Java Virtual Machine Stack）都是每个线程独有的

![image-20230327195704527](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303271957667.png)





### 整体架构

![image-20230326195754464](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303272008461.png)

### 程序计数器（PC寄存器）

>==作用== ：PC寄存器用来存储指向下一条指令的地址，也就是将要执行的指令代码。由执行引擎读取下一条指令。其中在 Java栈中存放的是每一个 方法
>
>![image-20230327201611449](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303272016196.png)

#### PC Register介绍

- 是一块很小的内存空间 几乎可以忽略不记 运行速度最快的存储区域
- 每个线程都有自己的程序计数器 是线程私有的 声明周期与线程的声明周期保持一致。
- 任何时间一个线程都只有一个方法在执行，也就是所谓的当前方法。==程==
  ==序计数器会存储当前线程正在执行的Java方法的M指令地址==：或者如果是在执行native方法，则是未指定值(undefned)
- 在这个区域是没有GC垃圾回收机制的 也不会发OOM(内存溢出的异常的) 做个compareset: 虚拟机栈也是没有GC垃圾回收机制的 但是可能会发生OOM(内存溢出异常的)

查看看字节码编译出的指令步骤

>- 选择 build -> run mavne -> compaire编译出字节码
>- 进入字节码的 cmd目录下  输入指令 `javap -verbose .\xxxxx.class`

#### 举例说明

```java
/**
 * PCRegister的实例演示
 */
public class PCRrgisterTest {
    public static void main(String[] args) {
        int i = 10;
        int j = 20;
        int k = i + j;

        String s = "abc";
        System.out.println(i);
        System.out.println(k);

    }
}
```

通过字节码编译出的指令

```sh'
Classfile /D:/每日学习文档/我的杂学文档/jvm/MyCode/target/classes/PCRegister/PCRrgisterTest.class
  Last modified 2023-3-27; size 663 bytes      
  MD5 checksum cf587b53492e0d28599dab9cf6779f2e
  Compiled from "PCRrgisterTest.java"          
public class PCRegister.PCRrgisterTest         
  minor version: 0                             
  major version: 52                            
  flags: ACC_PUBLIC, ACC_SUPER                 
Constant pool:                                 
   #1 = Methodref          #6.#26         // java/lang/Object."<init>":()V
   #2 = String             #27            // abc
   #3 = Fieldref           #28.#29        // java/lang/System.out:Ljava/io/PrintStream;
   #4 = Methodref          #30.#31        // java/io/PrintStream.println:(I)V
   #5 = Class              #32            // PCRegister/PCRrgisterTest
   #6 = Class              #33            // java/lang/Object
   #7 = Utf8               <init>
   #8 = Utf8               ()V
   #9 = Utf8               Code
  #10 = Utf8               LineNumberTable
  #11 = Utf8               LocalVariableTable
  #12 = Utf8               this
  #13 = Utf8               LPCRegister/PCRrgisterTest;
  #14 = Utf8               main
  #15 = Utf8               ([Ljava/lang/String;)V
  #16 = Utf8               args
  #17 = Utf8               [Ljava/lang/String;
  #18 = Utf8               i
  #19 = Utf8               I
  #20 = Utf8               j
  #21 = Utf8               k
  #22 = Utf8               s
  #23 = Utf8               Ljava/lang/String;
  #24 = Utf8               SourceFile
  #25 = Utf8               PCRrgisterTest.java
  #26 = NameAndType        #7:#8          // "<init>":()V
  #27 = Utf8               abc
  #28 = Class              #34            // java/lang/System
  #29 = NameAndType        #35:#36        // out:Ljava/io/PrintStream;
  #30 = Class              #37            // java/io/PrintStream
  #31 = NameAndType        #38:#39        // println:(I)V
  #32 = Utf8               PCRegister/PCRrgisterTest
  #33 = Utf8               java/lang/Object
  #34 = Utf8               java/lang/System
  #35 = Utf8               out
  #36 = Utf8               Ljava/io/PrintStream;
  #37 = Utf8               java/io/PrintStream
  #38 = Utf8               println
  #39 = Utf8               (I)V
{
  public PCRegister.PCRrgisterTest();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 13: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       5     0  this   LPCRegister/PCRrgisterTest;

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=5, args_size=1
         0: bipush        10
         2: istore_1
         3: bipush        20
         5: istore_2
         6: iload_1
         7: iload_2
         8: iadd
         9: istore_3
        10: ldc           #2                  // String abc
        12: astore        4
        14: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
        17: iload_1
        18: invokevirtual #4                  // Method java/io/PrintStream.println:(I)V
        21: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
}
SourceFile: "PCRrgisterTest.java"

```

![image-20230327204701094](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303272047688.png)

#### 两个常见问题

- 使用PC寄存器存储字节码指令地址有什么用呢？

  >因为CPU需要不停的切换各个线程，这时候切换回来以后，就得知道接着从哪开始继续执行。

- 为什么使用PC寄存器记录当前线程的执行地址呢？

  >JVM的字节码解释器就需要通过改变PC寄存器的值来明确下一条应该执行什么样的字节码指令。

****

### 虚拟机栈（Java栈）

>栈是运行时的单位，而堆是存储的单位。
>
>每个线程都有自己的虚拟机栈 用于存储方法的执行过程 每个栈帧都对应着一个方法的执行 包含了方法的局部变量表、操作数栈、动态链接、方法返回地址等信息

****

#### 概述

每个线程在创建的时候都会创建一个虚拟机栈 其内部保存了一个个的栈帧（Stack Frame） 对应着一次次的Java方法调用。java虚拟机栈是线程私有的 

>特点： 栈是一种快速有效的分分配存储方式 访问速度次于程序技术器
>
>- 每个方法执行，伴随着进栈（入栈、压栈）执行结束后的出栈工作
>- 不存在垃圾回收机制

设置栈内存大小

>使用参数 `-Xss` 选项设置线程的最大占空间 栈的大小直接决定了函数调用的最大可达深度

****

#### 栈的存储单位

栈中存储的东西

- 每个线程都有自己的栈，栈中的数据都是以栈帧(Stack Frame)的格式存在。
- 在这个线程上正在执行的每个方法都各自对应一个栈帧(Stack Frame)。
- 栈帧是一个内存区块，是一个数据集，维系着方法执行过程中的各种数据信息

栈帧中存储着

- 局部变量表(Local Variables)
- 操作数栈(operand stack)(或表达式栈)
- 动态链接(Dynamic Linking)(或指向运行时常量池的方法引用)
- 方法返回地址(Return Address)(或方法正常退出或者异常退出的定义)
- 一些附加信息

在一条活动线程中，一个时间点上，只会有一个活动的栈帧。即==只有当前正在执行的方法的栈帧（栈顶栈帧）是有效的==，这个栈帧被称为当前栈帧(Current Frame),与当前栈帧相对应的方法就是当前方法(CurrentMethod),定义这个方法的类就是当前类(Current Class)

栈运行原理

- 不同线程中所包含的栈帧是不允许存在相互引用的，即不可能在一个栈帧之中引用
  另外一个线程的栈帧。
- 如果当前方法调用了其他方法，方法返回之际，当前栈帧会传回此方法的执行结果
  给前一个栈帧，接着，虚拟机会丢弃当前栈帧，使得前一个栈帧重新成为当前栈帧。
- Java方法有两种返回函数的方式，一种是正常的函数返回，使用return指令；另
  外一种是抛出异常。不管使用哪种方式，都会导致栈帧被弹出。

****

#### 局部变量表

用于存储方法执行过程中局部变量的一块内存区域 在方法执行时 虚拟机会根据方法的参数和局部变量的定义 为局部变量表分配响应的内存空间 并将其初始化为默认值 局部变量表中存储的是基本数据类型和对象引用类型，而不是对象本身。

****

#### 操作数栈

用于存储方法执行过程中的操作数和中间结果的一块内存区域 在方法执行过程中，虚拟机会根据方法的字节码指令从操作数栈中取出操作数，进行相应的运算，并将结果再次压入操作数栈中。操作数栈中存储的是基本数据类型的值和对象引用类型的地址。

操作数栈中的元素只在方法执行过程中有效，一旦方法执行结束，操作数栈中的内容也会随之销毁。

****

#### 代码追踪

>- `栈帧的创建`: 当一个方法被调用时，虚拟机会创建一个栈帧，并将其推入虚拟机栈的顶部。在创建栈帧时，虚拟机会为==局部变量表==和==操作数栈==分配相应的内存空间，并将其初始化为默认值。
>- `方法的执行`: 在方法执行过程中，虚拟机会根据方法的字节码指令从操作数栈和局部变量表中取出相应的操作数和变量，并进行相应的运算。
>- `方法返回`: 当方法执行完毕后，虚拟机会将栈帧弹出虚拟机栈，并返回到调用该方法的位置。在方法返回时，虚拟机会从栈帧中取出方法返回地址，并返回到该地址处继续执行代码。
>- `栈帧的销毁`: 在方法执行完毕后，虚拟机会将栈帧从虚拟机栈中弹出，并释放相应的内存空间。 

****

#### 栈顶缓存技术

优点： 提高方法调用的效率

副作用：① 如果多个线程同时操作同一个栈时，可能会发生冲突。

​			  ② 还会导致内存占用增加

> 每个线程都会维护一个栈顶缓存区，用于缓存当前线程执行的栈顶元素。当一个方法调用另一个方法时，虚拟机会将当前栈顶元素存储到缓存区中，以便在返回时快速恢复当前的栈顶元素。

****

#### 动态链接

用于解决 Java代码中方法的动态性问题。方法调用可以是静态调用和动态调用，静态调用指的是在编译期就能确定调用哪个方法，而动态调用则是在运行时才能确定调用哪个方法。在动态调用的情况下，虚拟机需要进行动态链接，以确定要调用哪个方法。

在动态链接的过程中 虚拟机需要进行一些安全性检查 以确保方法调用的正确性 

可以实现Java代码的动态性 可以支持方法的动态调用 从而实现更加灵活的编程方式

****

#### 方法的待用 ： 解析与分派

根据方法的符号引用，在类的方法池中查找方法的直接引用的过程。

方法的解析 ：在解析方法时，虚拟机会首先从当前类的方法池中查找方法，如果找不到，则会递归地从当前类的父类中查找，直到找到为止。

方法的分派：指确定要调用哪个方法的过程。方法分派可以是静态分派和动态分派。

- 静态分派是指根据参数的静态类型在编译时就可以确定要调用哪个方法
- 动态分派则是指在运行时根据对象的实际类型来确定要调用哪个方法。 在Java虚拟机中 动态分派的实现需要使用到方法的待用

****

#### 方法返回地址

指方法执行完毕后需要返回到哪个指令继续执行的地址

在Java语言中 方法返回可以有两种方式 分别是普通返回和异常返回 普通返回是指在方法正常执行完成后返回的地址 而异常返回是指在方法执行过程中遇到异常后返回到正确的住址处

****

#### 一些附加信息

1. 栈帧中的局部变量表和操作数栈的大小限制。
2. 栈帧中的监视器和异常处理器信息。
3. 栈帧中的类引用信息和方法引用信息。
4. 栈帧中的调试信息

#### 相关面试题

****

## 垃圾回收原理

垃圾回收是一种自动化的内存管理机制 目的在程序运行期间自动识别并回收不在被程序引用的对象所占用的内存空间 从而避免内存泄露和内存溢出等问题。

原理是一种垃圾回收算法的选择并不是固定的，根据具体的场景和 JVM 参数的配置来确定的。==JVM 默认情况下使用的垃圾回收器是基于分代的垃圾回收算法==，即将堆内存分为新生代和老年代两个区域，使用不同的垃圾回收算法来处理不同区域的对象。

```
在新生代中，JVM 使用复制算法来回收内存，即将内存分为 Eden 区、Survivor 区 1 和 Survivor 区 2 三个部分，将对象存放在 Eden 区中，经过一次垃圾回收后，存活的对象会被复制到 Survivor 区中，再经过多次垃圾回收后，仍然存活的对象会被晋升到老年代中。

在老年代中，JVM 使用标记-整理算法或标记-清除算法来回收内存，标记-整理算法在垃圾回收时会将所有存活的对象向一端移动，使空间利用率更高，而标记-清除算法则是将无用对象标记后，直接回收内存，但可能会出现内存碎片的问题。
```

JVM中垃圾回收算法

过程分两个阶段 ： 标记和清楚

1. 标记清楚算法：

   - 标记阶段 ： 垃圾回收器遍历所有的对象 并对所有的可达对象进行标记
   - 清楚阶段： 垃圾回收器清楚所有未被标记的对象 并回收他们所占用的内存空间

   缺点： 无法解决内存碎片化问题 只是简单的讲未被标记的内存空间回收 不会对内存空间进行整理

2. 复制算法

   将堆内存分为两个部分（即 Eden 区和 Survivor 区）的垃圾回收算法。

   在程序运行过程中，垃圾回收器将对象分配到 Eden 区，并在 Eden 区满时对其进行垃圾回收。所有能够存活下来的对象都会被移动到 Survivor 区，而不是清除。

   在下一次垃圾回收时，垃圾回收器会将所有存活的对象移动到另一个 Survivor 区，同时将原来的 Survivor 区清空。

   

   避免了内存碎片化问题

3. 标记-整理算法

   通过标记和整理来回收未被使用的内存空间的垃圾回收算法。

   - 标记阶段：与标记-清除算法相同，垃圾回收器遍历所有的对象，并对所有的可达对象进行标记。

   - 整理阶段：垃圾回收器将所有存活的对象向一端移动，并清空另一端的内存空间。这样，所有的存活对象都会被移动到一端，形成一段连续的内存空间，而另一端则成为空闲内存。

     

   优点：可以有效解决内存碎片化问题 

   缺点： 

   1. 移动对象的开销较大
   2. 无法处理大对象
   3. 空间利用率较低

   

JVM 中还有一种分代算法，即将对象分为不同的代，每一代使用不同的垃圾回收算法进行回收。Java 对象的生命周期可以分为三个阶段：新生代、老年代和永久代。新生代中的对象一般存活时间较短，因此采用复制算法进行回收；老年代中的对象一般存活时间较长，因此采用标记-整理算法进行回收；永久代中存放的是类信息等不会被回收的对象，因此不需要垃圾回收。

