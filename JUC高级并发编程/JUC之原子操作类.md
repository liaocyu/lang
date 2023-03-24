什么是原子操作
-------

什么是原子操作，所谓原子操作，就是一个操作是不能打断的操作。嗯.......确切的说应该是不被其他线程或者任务影响的操作。

![1646458917476.png](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303220116184.png) 没错，原子操作就是你在家里的一次上厕所的操作 >> 进厕所，上锁，执行操作..... 身心愉悦，开锁，离开.....

在程序中的体现就是一个线程在执行某个任务占用某个资源在操作的时候，不会被其他的线程或者任务抢走资源，直到这个任务结束释放资源，其他的线程或者任务才能使用这个资源。

嗯......其实就是我们说的给资源上锁，就是同步操作。。。。。

看看案例
----

我们都知道 i++ 是给i变量加1。那么i++是不是原子操作呢？

看看程序：

先交代一下程序: 静态成员变量x就是要操作的资源。 静态方法incr()就是对x进行加1操作。在main方法中定义CountDownLatch对象，用来确保所有线程结束之后再输出x的结果。 循环创建100个线程，每个线程调用incr()方法1000次，理论上x最终的值应该是100000。

```
 package com.qidian.atom;
 import java.util.concurrent.CountDownLatch;
 /**
  * @author 戴着假发的程序员
  */
 public class Test {
     // 静态成员变量
     private static int x = 0;
     public static void main(String[] args) throws InterruptedException {
         // 定义CountDownLatch 确保所有线程结束之后再输出x的值
         CountDownLatch cd = new CountDownLatch(100);
         // 循环创建100个线程
         for(int i = 0;i<100;i++){
             new Thread("线程A"){
                 public void run() {
                     // 每个线程执行1000次incr方法
                     for (int j = 0;j<1000;j++){
                         incr();
                     }
                     cd.countDown();
                 }
             }.start();
         }
         // 确保所有线程结束之后再继续执行
         cd.await();
         // 输出x的值
         System.out.println(x);
     }
     // incr方法，执行x ++
     public static void incr(){
         x ++;
     }
 }

```

多执行几次，我们会发现x的值有时并不是100000.

![1646459781486.png](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303220116928.png) 这样的结果就是因为x ++不是原子操作。也就是说你在上厕所的时候没有锁门，导致有可能上到一半就被别人打断了，所有你上的这100000次厕所，总有那么几次可能没有成功，身心没有得到放松。。。。。。。

看图理解一下被打断的情况：

首先要知道 x++ 实际的操作是有两步的 就是：

第一步： int z = x + 1;

第二步: x = z;

![1646460226145.png](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303220116807.png) 说明一下：线程A和线程B同时给X执行++操作。

线程A先获取x的值，并且执行 z = x +1, 这时线程A打个盹，线程B获取x的值，并且执行 z = x + 1,然后将z的值写入x变量。 这时x就从10被修改为11。 这时线程A醒了，直接将自己计算的z（还是11）的值写入x变量。就会导致x的值从11修改为11。这时我们会发现，线程B的加1操作被覆盖了。这就导致线程B的这次+1操作失败了。

这就是上面程序产生的非100000的结果的原因。其实解决办法非常简单，就是给incr方法上锁。任何一个线程操作x的时候，其他线程都必须等待。哪怕当前正在操作的线程打盹，其他线程也不能操作x。

嗯！没错，这就是提醒你，上厕所一定要记得锁门......永远都无法忘记曾经发生在大学宿舍的凌晨厕所惊悚事件.....

于是乎，程序可以是这样：使用synchronized修饰incr方法，当然了加锁的方法有很多种。我们后面的文章再说锁的问题。

```
 package com.qidian.atom;
 ​
 import java.util.concurrent.CountDownLatch;
 ​
 /**
  * @author 戴着假发的程序员
  * @company 江苏极刻知学-起点编程
  */
 public class Test {
     // 静态成员变量
     private static int x = 0;
     public static void main(String[] args) throws InterruptedException {
         // 定义CountDownLatch 确保所有线程结束之后再输出x的值
         CountDownLatch cd = new CountDownLatch(100);
         // 循环创建100个线程
         for(int i = 0;i<100;i++){
             new Thread("线程A"){
                 public void run() {
                     // 每个线程执行1000次incr方法
                     for (int j = 0;j<1000;j++){
                         incr();
                     }
                     cd.countDown();
                 }
             }.start();
         }
         // 确保所有线程结束之后再继续执行
         cd.await();
         // 输出x的值
         System.out.println(x);
     }
     // incr方法，执行x ++
     // 使用synchronized修饰incr方法，使其成为同步方法，其中的操作就无法被其他线程影响了
     public synchronized static void incr(){
         x ++;
     }
 }

```

加锁之后，incr方法中的操作 i++ 就可以理解为原子操作了。当然我们也要明白，任何程序只要上锁都会有效率问题。

java中的原子操作类
-----------

java中给我们提供了几个原子操作类，这几个类提供了好用的API。这些个API对资源的操作都是原子操作，不会有线程安全问题。我们来see see。。。。

![1646460986654.png](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303220117591.png) 没错就是java.util.concurrent.atomic包下的所有类。

我们来看几个经典的类的使用吧！

### AtomicInteger

这个类是一个int类型的原子操作类。

看看他的AIP：

**构造方法：**

*   AtomicInteger() 创建一个新的AtomicInteger，初始值为 0 。

*   AtomicInteger(int initialValue) 用给定的初始值创建一个新的AtomicInteger。

**来看看一些经典的API**

*   addAndGet(int delta) 将给定的值原子地添加到当前值。并且返回更新后的int值。

*   compareAndSet(int expect, int update) 如果当前值 ==为预期值，则将该值原子设置为给定的更新值。 如果更新成功就返回true，否则返回false。
*   decrementAndGet() 原子减1当前值。并且返回更新后的值。
*   get() 获取当前值。
*   getAndAdd(int delta) 将给定的值原子地添加到当前值。 并且返回更新前的值。
*   getAndDecrement() 原子减1当前值。 并且返回更新前的值。
*   getAndIncrement() 原子上增加一个当前值。 并且返回更新前的值。
*   getAndSet(int newValue) 将原子设置为给定值并返回旧值。
*   incrementAndGet() 原子上增加1。并且返回更新后的值。
*   set(int newValue) 设置为给定值。

**来来来！先根据程序理解一下API。 后面我们来翻翻源码，看看有没有啥问题。。。。**

```
 package com.qidian.atom;
 ​
 import java.util.concurrent.atomic.AtomicInteger;
 ​
 /**
  * @author 戴着假发的程序员
  */
 public class Test1 {
     public static void main(String[] args) {
         AtomicInteger atomi = new AtomicInteger(10);
         // 将给定的值原子地添加到当前值。
         int i = atomi.addAndGet(10);
         System.out.println(i);// 20
         //  如果当前值 ==为预期值，则将该值原子设置为给定的更新值。 如果更新成功就返回true，否则返回false。
         boolean b = atomi.compareAndSet(20, 30);
         System.out.println(b); // true
         System.out.println(atomi.get());// 30
         // 原子减1当前值。并且返回更新后的值。
         i = atomi.decrementAndGet();
         System.out.println(i); // 29
         System.out.println(atomi.get()); // 29
         // 将给定的值原子地添加到当前值。 并且返回更新前的值。
         i = atomi.getAndAdd(50);
         System.out.println(i); // 29
         System.out.println(atomi.get()); // 79
         // 原子减1当前值。  并且返回更新前的值。
         i = atomi.getAndDecrement();
         System.out.println(i);// 79
         System.out.println(atomi.get());// 78
         // 原子上增加一个当前值。 并且返回更新前的值。
         i = atomi.getAndIncrement();
         System.out.println(i);// 78
         System.out.println(atomi.get());// 79
         //  将原子设置为给定值并返回旧值。
         i = atomi.getAndSet(100);
         System.out.println(i);// 79
         System.out.println(atomi.get());// 100
         // 原子上增加一个当前值。并且返回更新后的值。
         i = atomi.incrementAndGet();
         System.out.println(i);// 101
         System.out.println(atomi.get());// 101
     }
 }

```

OK！ 看看源码：

嗯。。。。。。。。。先看看addAndGet的源码： AtomicInteger中的源码：

```
 /**
  * Atomically adds the given value to the current value.
  *
  * @param delta the value to add
  * @return the updated value
  */
 public final int addAndGet(int delta) {
     return unsafe.getAndAddInt(this, valueOffset, delta) + delta;
 }

```

原来使用的是unsafe类中的方法，ok我们继续翻：

```
 public final int getAndAddInt(Object var1, long var2, int var4) {
     int var5;
     do {
         //  volatile 嗯..... 欢迎持续关注，后面的文章中会有这个关键字的详解
         var5 = this.getIntVolatile(var1, var2);
         // 这里最终是使用 unsafe的compareAndSwapInt替换数据。
     } while(!this.compareAndSwapInt(var1, var2, var5, var5 + var4));
 ​
     return var5;
 }

```

嗯嗯嗯嗯！ 再来看看别的方法：

compareAndSet方法的源码：

```
 public final boolean compareAndSet(int expect, int update) {
     return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
 }

```

decrementAndGet方法源码：

```
 public final int decrementAndGet() {
     return unsafe.getAndAddInt(this, valueOffset, -1) - 1;
 }

```

getAndAdd方法源码：

```
 public final int getAndAdd(int delta) {
     return unsafe.getAndAddInt(this, valueOffset, delta);
 }

```

看到这里我们想差不多够了，我们也明白了， AtomicInteger类中的所有的API，做到原子操作更新值的底层都是通过unsafe的CAS实现的。

那么unsafe的CAS有没有问题呢？ （关于CAS后面的文章会有详细说明，欢迎关注，你懂的，我最喜欢你关注我了。( _^\_\_^_ ) 嘻嘻…… ）

**当然都看到这里了，就点个攒吧！**

### AtomicReference

看看这个类的说明：

```
 public class AtomicReference<V>
 extends Object
 implements Serializable
 可以原子更新的对象引用。

```

说白了就是对任何引用类型的原子操作类。

**直接上菜：**

```
 /**
  * @author 戴着假发的程序员
  * @company 江苏极刻知学-起点编程
  */
 public class Test3 {
     public static void main(String[] args) {
         AtomicReference<String> ar = new AtomicReference<>("卡卡西");
         System.out.println(ar.get()); // 卡卡西
         String s = ar.get();
         boolean b = ar.compareAndSet(s, "旗木卡卡西");
         System.out.println(b);// true
         System.out.println(ar.get());// 旗木卡卡西
     }
 }

```

嗯。。。。。应该不难理解吧！

CAS有个小问题那就是ABA问题。 休息5分钟......... 可以浏览一下我的其他文章......

### ABA问题

来吧，我来稍微聊聊ABA问题。

**先看看CAS：** CAS的全拼是：Compare And Swap 就是比较并且替换。什么意思呢？看图吧

![1646464611315.png](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303220117866.png) 稍微说明一下：一个容器里面有一只鸡，小明同学左手一只鸡，右手一只鸭。左手的鸡就是容器里面的预期值，如果左手的小鸡和容器里面的小鸡一样，就拿右手的小鸭把容器里的小鸡替换了。如果左手的预期值和容器里的小鸡不一样，那就算了，就不换了。

OK，看看ABA问题：

![1646465030128.png](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303220117311.png) 这个图好乱，看看我们的描述吧：

①小明小明准备把一只鸡替换成一只鸭，于是就查看了容器里的内容，发现是一只鸡，他就在右手抓起一只鸡作为预期值。准备执行CAS。 可是就在这时，小明肚子疼，去厕所了。 如花就开始了....

②③蓝色的如花使用CAS将容器里面的一只鸡替换成一头猪。

④⑤如花不知道为什么感觉鸡不划算，于是乎又使用另外一只鸡把猪给换回来了。

⑥这时小明上好厕所了，于是乎拿起自己之前准备好的鸡开始和容器里面的小鸡进行比较，发现果然一样，于是就使用一只鸭替换了容器里面的鸡。

在这个过程中，问题就是小明一开始按照容器里面的内容，准备了一只鸡，再他上完厕所再回来比较的时候，容器里面的鸡已经被如花替换过了，已经不是以前的鸡了。所谓此鸡非彼鸡。所以理论上小明的CAS应该不能成功的，但是结果缺失成功的，这就是经典的ABA问题。

**看程序理解一下**

```
 package com.qidian.atom;
 ​
 import java.util.concurrent.TimeUnit;
 import java.util.concurrent.atomic.AtomicInteger;
 ​
 /**
  * @author 戴着假发的程序员
  */
 public class Test2 {
     // 原始值为 3
     private static AtomicInteger ai = new AtomicInteger(3);
 ​
     public static void main(String[] args) {
          // 启动线程1
         new Thread(){
             public void run() {
                 // 取出原来的值
                 int i = ai.get();// 这个值作为预期值
                 //打个盹
                 try {
                     TimeUnit.MICROSECONDS.sleep(50);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                 // 使用cas替换
                 boolean b = ai.compareAndSet(i, 4);
                 System.out.println("线程1将3替换为4："+b);
             }
         }.start();
         // 再来一个线程
         new Thread(){
             public void run() {
                 // 取出原来的值
                 int i = ai.get();
                 // 将3替换为4
                 boolean b = ai.compareAndSet(i, 4);
                 System.out.println("线程2将3替换为4："+b);
                 // 再次将4替换为3
                 b = ai.compareAndSet(4, 3);
                 System.out.println("线程2将4替换为3："+b);
             }
         }.start();
     }
 }

```

结果：

![1646466413884.png](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303220117667.png)理论上线程1之前取出的3已经不是现在的3了，但是依然替换成功了。

原子操作类也有ABA问题，于是乎准备了一个新的解决方案，那就是AtomicStampedReference类。

### AtomicStampedReference

看看这个类的说明：

```
 public class AtomicStampedReference<V>
 extends Object
     一个AtomicStampedReference维护对象引用以及整数“印记”，可以原子更新。

```

关键字：“印记”。 什么意思呢？

这个类为了解决ABA问题，给每个值增了一个“印记”，就好像，小明会给自己的鸡盖上一个印章，如花也会给自己的鸡盖上一个印章，这样的话我们就可以通过印章轻松判断，此鸡是否是彼鸡。

**看看构造方法：**

AtomicStampedReference(V initialRef, int initialStamp) 创建一个新的 AtomicStampedReference与给定的初始值。

**这个类的API有限，但是有两个比较经典的方法：**

*   boolean compareAndSet(V expectedReference, V newReference, int expectedStamp, int newStamp) 以原子方式设置该引用和邮票给定的更新值的值，如果当前的参考是 ==至预期的参考，并且当前标志等于预期标志。

*   V getReference() 返回引用的当前值。
*   int getStamp() 返回邮票的当前值。
*   void set(V newReference, int newStamp) 无条件地设置引用和戳记的值。

**看程序理解理解**

```
 package com.qidian.atom;
 ​
 import java.util.concurrent.TimeUnit;
 import java.util.concurrent.atomic.AtomicStampedReference;
 ​
 /**
  * @author 戴着假发的程序员
  */
 public class Test4 {
     private static AtomicStampedReference<String> asr = new AtomicStampedReference<>("卡卡西",1);
     public static void main(String[] args) {
         // 线程1
         new Thread(){
             public void run() {
                 // 取值
                 String s = asr.getReference();
                 // 获取印记
                 int stamp = asr.getStamp();
                 // 打盹
                 try {
                     TimeUnit.MICROSECONDS.sleep(500);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                 // 替换值  参数说明(原始值，新值，原始印记，新的印记)
                 boolean b = asr.compareAndSet("卡卡西","旗木卡卡西",stamp,stamp+1);
                 System.out.println("线程1，替换的结果："+b);
             }
         }.start();
         // 线程1
         new Thread(){
             public void run() {
                 // 取值
                 String s = asr.getReference();
                 // 获取印记
                 int stamp = asr.getStamp();
                 // 第一次替换值  参数说明(原始值，新值，原始印记，新的印记)
                 boolean b = asr.compareAndSet("卡卡西","旗木五五开",stamp,stamp+1);
                 System.out.println("线程2，第一次替换的结果："+b);
                 // 第二次替换值  参数说明(原始值，新值，原始印记，新的印记)
                 b = asr.compareAndSet("旗木五五开","卡卡西",stamp,stamp+1);
                 System.out.println("线程2，第二次替换的结果："+b);
             }
         }.start();
     }
 }

```

结果：

![1646468431972.png](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303220117516.png) 稍微说明一下：

由于每次在CAS的比较中，不光要比较预期值，还要比较”印记“。而每次替换的时候都不光要提换值，还要修改印记，所以即使值一样，如果印记不一样，依然会替换失败。

所以上面的程序就是线程2量次替换，第二次把”旗木五五开“替换回”卡卡西“之后，这个"卡卡西"的印记已经不是之前的”卡卡西“的印记了，所以线程1打盹结束之后，再去CAS就失败啦！