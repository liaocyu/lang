# Java多线程编程 

# 写在前面

使用场景 : 开启独立线程 去执行某个特定任务  线程操作==资源类== 

## 并发

同一时刻多个线程在访问同一个资源 多个线程对一个点 eg: 春运抢票、电商秒杀

## 并行

多项工作一起执行 之后在汇总 eg : 泡方便面 电水壶烧水 一边撕掉调料导入桶中

## 管程（monitor）

 是保证了==同一时刻==只有==一个进程==在管程内活动,即管程内定义的操作在同

一时刻只被==一个进程调用==(由编译器实现) 执行线程首先要持有管程对象 其他线程无法在获取同一个管程 

进入方法加锁 出方法解锁 jvm中同步是基于监视器对象来实现的 

## 用户线程 

 自定义线程 

主线程结束了 用户线程还在运行 jvm存活

## 守护线程

是一种特殊的线程，在后台默默地完成一些系统性的服务 比如垃圾回收机制 

没有用户线程了 都是守护线程 jvm结束 

设置守护线程，需要在start()方法之前进行

## 线程池 

### 是什么

线程池，其实就是一个容纳多个线程的容器，其中的线程可以反复使用，省去了频繁创建线程对象的操作，无需反复创建线程而消耗过多资源。



线程池主要用来解决线程生命周期开销问题和资源不足问题。通过对多个任务重复使用线程，线程创建的开销就被分摊到了多个任务上了，而且由于在请求到达时线程已经存在，所以消除了线程创建所带来的延迟。

### 作用

>1、线程池主要用来解决线程生命周期开销问题和资源不足问题。通过对多个任务重复使用线程，线程创建的开销就被分摊到了多个任务上了，而且由于在请求到达时线程已经存在，所以消除了线程创建所带来的延迟。
>
>2、通过适当的调整线程中的线程数目可以防止出现资源不足的情况。

### 创建

通过线程池工厂创建，再调用线程池中的方法获取线程，再通过线程去执行任务方法。        

>Executors：线程池创建工厂类
>
>public static ExecutorServicenewFixedThreadPool(int nThreads)：返回线程池对象
>
>ExecutorService：线程池类
>
>Future<?> submit(Runnable task)：获取线程池中的某一个线程对象，并执行
>
>Future 接口：用来记录线程任务执行完毕后产生的结果。线程池创建与使用

#### 使用 Runnable街交口创建线程池 

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        //创建线程池对象  参数5，代表有5个线程的线程池
        ExecutorService service = Executors.newFixedThreadPool(5);
        //创建Runnable线程任务对象
        TaskRunnable task = new TaskRunnable();
        //从线程池中获取线程对象
        service.submit(task);
        System.out.println("----------------------");
        //再获取一个线程对象
        service.submit(task);
        //关闭线程池
        service.shutdown();
    }
}

interface接口如下 ：
    
public class TaskRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("自定义线程任务在执行"+i);
        }
    }
}  
```

#### 使用Callable接口创建线程池

Callable接口：与Runnable接口功能相似，用来指定线程的任务。其中的call()方法，用来返回线程任务执行完毕后的结果，call方法可抛出异常。

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test{
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        TaskCallable c = new TaskCallable();
        //线程池中获取线程对象，调用run方法
        service.submit(c);
        //再获取一个
        service.submit(c);
        //关闭线程池
        service.shutdown();
    }
}

import java.util.concurrent.Callable;

public class TaskCallable implements Callable<Object>{
    @Override
    public Object call() throws Exception {
        for (int i = 0; i < 1000; i++) {
            System.out.println("自定义线程任务在执行"+i);
        }
        return null;
    }
}
```

## 进程和线程的区别 

进程 

应用程序的执行实例，有独立的内存空间和系统资源

线程

CPU调度和分派的基本单位，进程中执行运算的最小单位，可完成一个独立的顺序控制流程 线程不可独立存在 

## 进程和线程的关系 

（1）一个线程只能属于一个进程，而一个进程可以有多个线程，但至少有一个线程。线程是操作系统可识别的最小执行和调度单位。

（2）资源分配给进程，同一进程的所有线程共享该进程的所有资源。 同一进程中的多个线程共享代码段(代码和常量)，数据段(全局变量和静态变量)，扩展段(堆存储)。但是每个线程拥有自己的栈段，栈段又叫运行时段，用来存放所有局部变量和临时变量。

（3）处理机分给线程，即真正在处理机上运行的是线程。

（4）线程在执行过程中，需要协作同步。不同进程的线程间要利用消息通信的办法实现同步。

## 线程安全问题

## **产生原因**

多个线程竞争同一资源（访问同一数据），可参考经典的生产者消费者问题。

解决方案：

在 run方法内 同步代码块 synchronized {}

>```
>Public synchronized 返回值类型 方法名（）{} 自动释放对象锁
>```

使用费 lock锁 

>Lock lock =  new ReentranttLock()  // Reentrant(可重用的)

Lock接口中的方法 

```
void lock()   // 获取锁 
void unlock() // 释放锁 
```

使用步骤 

- 在成员位置创建一个 ReentrantLock 对象。
- 在可能出现线程安全问题的代码前，调用 Lock 接口中的方法 lock 获取锁对象。

- 在可能出现线程安全问题的代码后，调用 Lock 接口中的方法 unlock 释放锁对象。

```java
public class RunnableImpl implements Runnable{
    //定义一个共享的票源
    private int ticket = 100;
    //1.在成员位置创建一个ReentrantLock对象
    Lock l = new ReentrantLock();
    //设置线程任务:卖票
    @Override
    public void run() {
        //使用死循环,让卖票重复的执行
        while(true){
            //2.在可能出现线程安全问题的代码前,调用Lock接口中的方法lock获取锁对象
            l.lock();
            //判断票是否大于0
            if(ticket>0){
                //为了提高线程安全问题出现的几率,让程序睡眠10毫秒
                try {
                    //可能会产生异常的代码
                    Thread.sleep(10);
                    //进行卖票 ticket--
                    System.out.println(Thread.currentThread().getName()+"正在卖第"+ticket+"张票!");
                    ticket--;
                } catch (InterruptedException e) {
                    //异常的处理逻辑
                    e.printStackTrace();
                }finally {
                    //一定会执行的代码,一般用于资源释放(资源回收)
                    //3.在可能出现线程安全问题的代码后,调用Lock接口中的方法unlock释放锁对象
                    l.unlock();//无论程序是否有异常,都让锁对象释放掉,节约内存,提高程序的效率
                }
            }
        }
    }
}
```

# 创建线程的多种方式 

## 继承Thread类 

## 实现Runnable接口 

## 使用Callable接口 

## 使用线程池 

# CompletableFuture

Java8 诞生 

## Future接口和 Callable接口

Future接口 （FutureTask实现类）定义了操作异步任务执行一些方法 如获取异步任务的执行结果、取消恩物的执行、判断任务是否呗取消、判断任务执行是否完毕等。

Callable接口定义了需要返回的任务需要实现的方法

```java
@FunctionalInterface
public interface Callable<V> {
    V call() throws Exception;
}

比如主线程让一个子线程去执行任务，子线程可能比较耗时，启动子线程开始执行任务后，
主线程就去做其他事情了，过了一会才去获取子任务的执行结果。
```



如果主线程需要执行一个很耗时的计算任务 可以通过future把这个任务放到异步线程中执行 主线程继续处理其他任务或者先行结束 再通过Future获取计算结果

### 优点

和线程池异步多线程任务配合 能显著提高程序的执行效率

### 缺点

容易导致阻塞 一旦调用get() 方法求结果 如果计算没有完成容易导致程序阻塞 

# CompletableFuture

提供了非常强大的Future的扩展功能  简化异步编程的复杂性   供了函数式编程的能力，可以通过回调的方式处理计算结果，也提供了转换和组合CompletableFuture的方法。 

## 核心的四个静态方法 

目的是 ： 创建一个异步任务

### runAsync 无 返回值

>public static CompletableFuture runAsync(Runnable runnable)
>
>public static CompletableFuture runAsync(Runnable runnable,Executor executor)

```java
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future  = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "------come in");

            try { TimeUnit.MILLISECONDS.sleep(1000); } catch (InterruptedException e ) { e.printStackTrace() ; }

            System.out.println("------task is over ");
        });

        System.out.println(future.get());
    }
```



### supplyAsync 有 返回值

>public static CompletableFuture supplyAsync(Supplier supplier)
>
>public static CompletableFuture supplyAsync(Supplier supplier,Executor executor)

没有指定Executor的方法，直接使用默认的ForkJoinPool.commonPool() 作为它的线程池执行异步代码。

```java
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future  = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "------come in");

            try { TimeUnit.MILLISECONDS.sleep(1000); } catch (InterruptedException e ) { e.printStackTrace() ; }


            return ThreadLocalRandom.current().nextInt(100); //随机打印 0- 100的随机数
        });

        System.out.println(future.get());
```



==如果指定线程池，则使用我们自定义的或者特别指定的线程池执行异步代码==

## 优点

1. 异步任务结束时 会自动调用某个对象的方法
2. 异步任务出错时 会总动回调某个对象的方法
3. 主线程设置好回调后 不在关心异步任务的执行 异步任务之间可以顺利执行 

# Runnable、Function、Consumer、Supplier

Runable

```java
@FunctionalInterface
public interface Runable {
    public abstract void fun ();
}
```

Function

```java
@FunctionalInterface
public interface Function<T,R> {
    R apply(T , t);
}
```

Consumer  -- 消费性参数

```java
@FunctionalInterface
public void Consumer<T> {
	void accept(T t);
}


BiConsumer<T,U> 接受两个参数  没有返回值 
@FunctionalInterface
public interface BiConsumer<T , U> {
	void accept(T t , U u);
}
```

Supplier --- 供给型函数接口

```java
@FunctionalInterface
public interface Supplier<T>{
    T get();
}
```

# join和get对比 

join 和 get效果是一样的 获取线程返回的结果 区别就是 join不抛出异常

# CompletableFurure相关api

## 获取结果和触发计算 

```java  
public T get() // 不见不散 容易引起阻塞 
```

```java
public T get(long timeout , TimeUnit unit) // 指定等待时间
```

```java
public T join()  // 和 get一样 但是不会抛出异常
```

```java
public T getNow(T valueIfAbsent) // 在没有计算完成之前返回valueIfAbsent
```

## 主动触发计算

对计算结果进行处理 

### thenApply

计算结果存在依赖关系 这两个线程串行化  后一个运算依赖与前一个结果

由于存在依赖关系 （当前步错 不走下一步） 当前步骤有异常的就叫停 相当于 try {} catch

### handle

有异常也可以向下走 

计算结果存在依赖关系 这两个线程串行化  起作用和thenApply() 但是

当前错误不会暂停 ==继续带着参数向下走==  相当于try {} catch{} finally

```java

public class CompletableFutureDemo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 当一个线程依赖另一个线程时用 thenApply 方法来把这两个线程串行化 ,
        CompletableFuture.supplyAsync(() -> {
            // 暂停几秒钟线程
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("111");
            return 1024;
        }).thenApply(f -> {
            System.out.println("222");
            return f + 1;
        }).thenApply(f -> {
            int age = 10 / 0;
            // 异常情况：那步出错就停在那步。
            System.out.println("333");
            return f + 1;
        }).whenCompleteAsync((v, e) -> {
            System.out.println("*****v: " + v);
        }).exceptionally(e -> {
            e.printStackTrace();
            return null;
        });
        System.out.println("----- 主线程结束， END");
        // 主线程不要立刻结束，否则 CompletableFuture 默认使用的线程池会立刻关闭 :
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```

```java
handle
有异常也可以往下一步走，根据带的异常参数可以进一步处理
 
package com.atguigu.juc.cf;
 
 
import java.util.concurrent.*;
 
/**
 * @auther zzyy
 * @create 2021-03-02 11:56
 */
public class CompletableFutureDemo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException { // 当一个线程依赖另一个线程时用 handle 方法来把这两个线程串行化 ,
        // 异常情况：有异常也可以往下一步走，根据带的异常参数可以进一步处理
        CompletableFuture.supplyAsync(() -> {
            // 暂停几秒钟线程
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("111");
            return 1024;
        }).handle((f, e) -> {
            int age = 10 / 0;
            System.out.println("222");
            return f + 1;
        }).handle((f, e) -> {
            System.out.println("333");
            return f + 1;
        }).whenCompleteAsync((v, e) -> {
            System.out.println("*****v: " + v);
        }).exceptionally(e -> {
            e.printStackTrace();
            return null;
        });
        System.out.println("----- 主线程结束， END");
        // 主线程不要立刻结束，否则 CompletableFuture 默认使用的线程池会立刻关闭 :
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
 
 
}
```

### whenComplete 和 whenCompleAsync的区别

>whenComplete: 是执行当前任务的线程继续执行whenComplete的任务
>
>whenCompleteAsync:是执行把whenCompleteAsync这个任务继续提交给线程池来进行执行。(我是这样理解的 相当于在线程池重新开一个线程完成任务 和之前的线程是异步操作 )

## 对结果进行消费

>==thenAccept==  接受任务的处理结果 并消费处理  无返回结果 

```java
接收任务的处理结果，并消费处理，无返回结果
thenAccept
    
    public static void main(String[] args) {

        CompletableFuture.supplyAsync(() -> 1)
                .thenApply(f -> f + 2)
                .thenApply(f -> f + 3)
                .thenApply(f -> f + 4)
                .thenAccept(System.out::println);

        completeRunAcceptApply();
    }
```



Code之间任务之间的顺序执行 (根据英文意思进行理解 )

>① thenRun（然后运行）：thenRun(Runnable runnable) 任务 A 执行完执行 B，并且 B 不需要 A 的结果（ 比较 thenApply）
>
>② thenAccept（然后接受）：thenAccept(Consumer action) 任务 A 执行完执行 B，B 需要 A 的结果，但是任务 B 无返回值 （）
>
>③ thenApply（然后应用）：thenApply(Function fn) 任务 A 执行完执行 B，B 需要 A 的结果，同时任务 B 有返回值

## 对计算速度进行选用

applyToEither  谁快用谁

```java
public class CompletableFutureAPI3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> completableFuture1 = CompletableFuture.supplyAsync(() -> {

            System.out.println(Thread.currentThread().getName() + " \t " + "---come in ");
            // 暂停几秒钟线程
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 10;
        });

        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " \t " + "---come in ");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 20;
        });
        // 比较异步线程 1 和 2 谁快 谁就传入参数给后面继续执行
        CompletableFuture<Integer> thenCombineResult = completableFuture1.applyToEither(completableFuture2, f -> {
            System.out.println(Thread.currentThread().getName() + " \t " + "---come in ");
            return f + 1;
        });
        System.out.println(Thread.currentThread().getName() + " \t " + thenCombineResult.get());
    }
```

## 对计算结果进行合并

两个CompletionStage任务都完成后，最终能把两个任务的结果一起交给thenCombine 来处理

先完成的先等着，等待其它分支任务 thenCombine

```java
    public static void main(String[] args) {

        ExecutorService selfPool = Executors.newFixedThreadPool(3);

        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "---come in");
            try { TimeUnit.MILLISECONDS.sleep(10000); } catch (InterruptedException e ) { e.printStackTrace() ; }

            return 10;
        },selfPool);

        CompletableFuture<Integer> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "---come in");
            return 20;
        },selfPool);

        CompletableFuture<Integer> thenCombinRresult = completableFuture.thenCombine(completableFuture1, (x ,y) -> {
            // 在 thenCombine这个API里面 ThreadMy是指的是当前 合并的较慢的那个线程名字
            System.out.println(Thread.currentThread().getName() + "\t" + "---come in");

            return x + y;
        });
        System.out.println(thenCombinRresult.join());
        selfPool.shutdown();
    }
```

# JUC锁

## 乐观锁 

认为自己在使用数据时 不会有别的线程修改数据 ，所以不会添加锁

如果这个数据没有被更新，当前线程将自己修改的数据成功写入。如果数据已经被其他线程更新，则根据不同的实现方式执行不同的操作  

适合读操作多的场景，不加锁的特点能够使其读操作的性能大幅提升。

实现方式 ：

1、采用版本号机制

2、CAS（Compare-and-Swap，即比较并替换）算法实现

## 悲观锁

认为自己在使用数据的时候一定有别的线程来修改数据 因此在获取数据的时候会加锁 确保数据不会被别的线程修改 

>synchronized和 Lock的实现类都是悲观锁

### synchronized

- 作用于实例方法，当前实例加锁，进入同步代码前要获得当前实例的锁；
- 作用于代码块，对括号里配置的对象加锁。
- 作用于静态方法，当前类加锁，进去同步代码前要获得当前类对象的锁； 

### 适用场景

适合写操作多的场景 先加锁保证写数据数据正确

### synchronized同步代码块 

实现使用的是monitorenter和 monitorexit指令

### synchronized普通同步方法

### synchronized普通同步方法

        调用指令将会检查方法的ACC_SYNCHRONIZED访问标志是否被设置。
    
        如果设置了，执行线程会将先持有monitor然后再执行方法，
    
        最后在方法完成(无论是正常完成还是非正常完成)时释放 monitor
### synchronized静态同步方法

**synchronized静态同步方法**

​    ACC_STATIC, ACC_SYNCHRONIZED访问标志区分该方法是否静态同步方法



## 什么是管程monitor

管程 (英语：Monitors，也称为监视器) 是一种程序结构，结构内的多个子程序（对象或模块）形成的多个工作线程互斥访问共享资源。 

这些共享资源一般是硬件设备或一群变量。对共享变量能够进行的所有操作集中在一个模块中。（把信号量及其操作原语“封装”在一个对象内部）管程实现了在一个时间点，最多只有一个线程在执行管程的某个子程序。管程提供了一种机制，管程可以看做一个软件模块，它是将共享的变量和对于这些共享变量的操作封装起来，形成一个具有一定接口的功能模块，进程可以调用管程来实现进程级别的并发控制。 

![img](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303180047053.png)





```java
// 悲观锁的调用方式 
public synchronized void m1() {
    // 加锁后的业务逻辑
}

// 保证多个线程使用的是同一个 lock 对象的 前提下 
ReentrantLock lock = new ReentrantLock();
public void m2 () {
    lock.lock();
    try{
        // 操作同步的资源
    } finally {
        lock.unlock();
    }
}
```

==相较于公平锁而言 悲观锁的性能没有乐观锁性能好==

## 公平锁

程序中的公平性也是符合请求锁的绝对时间的，其实就是 FIFO，否则视为不公平 

如果为了更高的吞吐量，很显然非公平锁是比较合适的，因为节省很多线程切换时间，吞吐量自然就上去了； 否则那就用公平锁，大家公平使用。 

## 非公平锁

非公平锁能更充分的利用CPU 的时间片，尽量减少 CPU 空闲状态时间。  

## 可重入锁（递归锁）

是指在同一个线程在外层方法获取锁的时候，再进入该线程的内层方法会自动获取锁(前提，锁对象得是同一个对象)，不会因为之前已经获取过还没释放而阻塞。 

“可重入锁”这四个字分开来解释：

可：可以。

重：再次。

入：进入。进入同步域（即同步代码块/方法或显式锁锁定的代码）

锁：同步锁。

### 可重入锁种类

==隐式锁（即synchronized关键字使用的锁）==默认是可重入锁

指的是可重复可递归调用的锁，在外层使用锁之后，在内层仍然可以使用，并且不发生死锁，这样的锁就叫做可重入锁。 

简单的来说就是： 在一个synchronized修饰的方法或代码块的内部调用本类的其他synchronized修饰的方法或代码块时，是永远可以得到锁的 

与可重入锁相反，不可重入锁不可递归调用，递归调用就发生死锁。 

```java
static Object objectLock = new Object();
public static void syncBlock()
{
    new Thread(() -> {
        synchronized (objectLock) {// lock
            System.out.println("-----外层");
            synchronized (objectLock)
            {
                System.out.println("-----中层");
                synchronized (objectLock)
                {
                    System.out.println("-----内层");
                }
            }
        }//unlock
    },"t1").start();
}
```

同步方法

```java
  
public class ReEntryLockDemoCopy {
    public synchronized void m1() {
        System.out.println("-----m1");
        m2();
    }
 
    public synchronized void m2() {
        System.out.println("-----m2");
        m3();
    }
 
    public synchronized void m3() {
        System.out.println("-----m3");
    }
 
    public static void main(String[] args) {
        ReEntryLockDemoCopy reEntryLockDemo = new ReEntryLockDemoCopy();
        reEntryLockDemo.m1();
    }
}
```

### Synchronized的重入的实现机理

每个锁对象拥有一个锁计数器和一个指向持有该锁的线程的指针。 

当执行monitorenter时，如果目标锁对象的计数器为零，那么说明它没有被其他线程所持有，Java虚拟机会将该锁对象的持有线程设置为当前线程，并且将其计数器加1。 

在目标锁对象的计数器不为零的情况下，如果锁对象的持有线程是当前线程，那么 Java 虚拟机可以将其计数器加1，否则需要等待，直至持有线程释放该锁。 

当执行monitorexit时，Java虚拟机则需将锁对象的计数器减1。计数器为零代表锁已被释放。  就是如果发生异常 可能会造成死锁 因为会被try {} catch{} 代码块捕获  解决方法就是在finally代码块下 一定要记得释放锁 

==显示锁（即Lock）也有ReentrantLock这样的可重入锁==

```java
package com.atguigu.juc.locks;
 
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
 
/**
 * @auther zzyy
 * @create 2020-07-09 18:09
指的是可重复可递归调用的锁，在外层使用锁之后，在内层仍然可以使用并且不发生死锁，这样的锁就叫做可重入锁。
简单的来说就是：
 
在一个synchronized修饰的方法或代码块的内部调用本类的其他synchronized修饰的方法或代码块时，是永远可以得到锁的
 */
public class ReEntryLockDemo
{
 
    public static void main(String[] args)
    {
        Lock lock = new ReentrantLock();
 
        new Thread(() -> {
            lock.lock();
            try
            {
                System.out.println(Thread.currentThread().getName()+"\t"+"-----外层");
                lock.lock();
                try
                {
                    System.out.println(Thread.currentThread().getName()+"\t"+"-----内层");
                }finally {
                    //  这里故意注释，实现加锁次数和释放次数不一样                     
                    //   由于加锁次数和释放次数不一样，第二个线程始终无法获取到锁，导致一直在等待。
                   // lock.unlock(); //  正常情况，加锁几次就要解锁几次
                }
            }finally {
                lock.unlock();
            }
        },"t1").start();
 
        new Thread(() -> {
            lock.lock();
            try
            {
                System.out.println("------22222");
            }finally {
                lock.unlock();
            }
        },"t2").start();
    }
 
}
```



## 死锁

指两个或者两个以上的 线程在执行过程中 争夺资源 造成的一种相互等待的现象 无外力干涉 他们无法推进下去 如果资源充足 进程的资源请求都能够满足 死锁问题得到满足  死锁出现的可能性就很低 

![image-20230318113803238](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303181138362.png)

产生死锁的主要原因 ：

1、 系统资源不足 2、进程运行推进的顺序不合适 3、资源分配不当

### 排查死锁

1、使用jps命令定位进程编号

![img](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303181613140.png)

jstack找到死锁查看 jstack 6488

![img](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303181614009.png)

不可String 同一把锁 

String locka = "A" ; String lockb = "B";

2、win + R 输入 jconsole进入java自带的客户端查询

![image-20230318162300014](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303181623092.png)

![image-20230318162346078](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303181623149.png)

![image-20230318162424992](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303181624063.png)

# LockSupport与线程中断

## 中断

在Java中没有办法立即停止一条线程  Java提供了一种用于停止线程的机制——中断。 

若要中断一个线程，你需要手动调用该线程的 interrupt 方法， 该方法也仅仅是将线程对象的中断标识设成true ；

每个线程对象中都有一个标识，用于表示线程是否被中断；该标识位为true表示中断，为false表示未中断；通过调用线程对象的interrupt方法将该线程的标识位设为true；可以在别的线程中调用，也可以在自己的线程中调用。

## 中断相关的API方法

### public void interrupt() 

实例方法interrupt()仅仅是设置线程的中断状态为true，不会停止线程 

### public static boolean interrupted() 

静态方法 Thread.interrupted(); 判断线程是否被中断，并清除当前中断状态 

这个方法做了两件事： 1、 返回当前线程的中断状态  2、将当前线程的中断状态设为false 

### public boolean isInterrupted() 

 实例方法，判断当前线程是否被中断（通过检查中断[标志位](https://so.csdn.net/so/search?q=标志位&spm=1001.2101.3001.7020)） 

# LockSupport

创建锁 和其他同步锁类的基本线程阻塞原语

==LockSupport中的park() 和 unpark() 的作用分别是阻塞线程和解除阻塞线程== 

## 线程唤醒机制 

### 使用Object中的wait()方法让线程等待，使用Object中的notify()方法唤醒线程

```java
    // main 主线程一切程序的入口守护线程
    public static void main(String[] args) {


        Object objectLock = new Object();

        //
        new Thread(() -> {
            // 锁着统一资源
            synchronized(objectLock) {
                System.out.println(Thread.currentThread().getName() + "\t --------有线程拿到资源了");

                try {
                    // 使用Object类的wait来是使线程等待
                    objectLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "t1").start();

        try { TimeUnit.MILLISECONDS.sleep(3000); } catch (InterruptedException e ) { e.printStackTrace() ; }


        new Thread(() -> {
            synchronized (objectLock) {
                objectLock.notify();
                System.out.println(Thread.currentThread().getName()+"\t"+"---发出通知 解锁了 ");
            }
        }, "t2").start();

    }
```

- wait和notify方法必须要在同步块或者方法里面，且成对出现使用
- 先wait后notify才OK

### 使用JUC包中Condition的await()方法让线程等待，使用signal()方法唤醒线程

```java
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) {

        new Thread(() -> {

            lock.lock();

            try {
                System.out.println(Thread.currentThread().getName() + "\t" + "---come in");
                condition.await();
                System.out.println(Thread.currentThread().getName() + "\t" + "---被唤醒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t1").start();

        try { TimeUnit.MILLISECONDS.sleep(3000); } catch (InterruptedException e ) { e.printStackTrace() ; }

        new Thread(() -> {

            lock.lock();
            try {
                condition.signal();
                System.out.println(Thread.currentThread().getName() + "\t" + "---发出通知");
            } finally {
                lock.unlock();
            }

        }, "t2").start();
    }
```

- Condtion中的线程等待和唤醒方法之前，需要先获取锁
- 一定要先await后signal，不要反了

### Object 和Condition使用的限制条件

线程先要获得并持有锁，必须在锁块(synchronized或lock)中

必须要先等待后唤醒，线程才能够被唤醒

### LockSupport类中的park等待和unpark唤醒

LockSupport是用来创建锁和其他同步类的基本线程阻塞原语。 

通过park()和unpark(thread)方法来实现阻塞和唤醒线程的操作

LockSupport是用来创建锁和其他同步类的基本线程阻塞原语

LockSupport类使用了一种名为Permit的概念来做到阻塞和唤醒线程的功能 每个线程都有一个许可 （permit）.permit只有两个指1和0 默认为零 可以把许可看成是一种 （0，1）信号量（Semaphore）

#### 主要方法 API

static void 

>park()  Disables the current thread for thread scheduling purposes unless the permit is available.
>
>park(Object blocker)  Disable the current thread scheduing purpose unless the permit is avaiable 
>
>unpark(Thread thread ) Makes avaiable the permit for the given thread , if it was not alreadly available

#### 阻塞

park() / park(Object blocker)

调用 LockSupport.park()时 

>public static void park() {
>
>UNSAFE.park( false , 0L)
>
>}

permit默认是零 所以一开始调用park() 方法 当前线程就会阻塞 直到别的线程将当前线程permit设置为1时 ，park方法将会被唤醒 然后会将permit再次设置为零并返回



#### 唤醒

unpark(Thread thread)

你看 静态方法

>public static void unpark(Thread thread) {
>
>if（thread ！= null） {
>
>UNSAFE.unpart(thread)
>
>}
>
>}

 因此 调用就是 LockSupport.unlock(thread);

调用unpark(thread) 方法后 就会将thread线程的许可permit设置为1 （多次调用unpark() 不会累加 peimit的 值还是1 ）会自动唤醒 thread线程 就是之前阻塞的LockSupport.park()方法会立即唤醒 

#### 示例代码块

```java
public static void main(String[] args) {
        Thread t1 = new Thread(() -> {

            System.out.println(Thread.currentThread().getName() + "\t" + "----come in");
            // 线程阻塞
            LockSupport.park();

            System.out.println(Thread.currentThread().getName() + "\t" + "-----当前线程被唤醒了 ");


        }, "t1");

        t1.start();

        try { TimeUnit.MILLISECONDS.sleep(3000); } catch (InterruptedException e ) { e.printStackTrace() ; }

        new Thread(() -> {
            // 唤醒线程
            LockSupport.unpark(t1);
            System.out.println(Thread.currentThread().getName() + "\t" + " 我已经成功唤醒了阻塞的线程了 ");

        }, "t2").start();
    }
```

```java
* @description : 使用 LockSupport.park() 和LockSupport.unpark()可以实现先唤醒后等待 不会出现异常 你掌握了原理就幸苦了 主要还是看permit
 */
public class ThreadParkUnpark2 {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {

            try { TimeUnit.MILLISECONDS.sleep(300); } catch (InterruptedException e ) { e.printStackTrace() ; }
            System.out.println(Thread.currentThread().getName() + "\t" + "我进来了 完成我自己的业务代码");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "\t" + "我被大哥唤醒了 ");
        }, "t1");

        t1.start();

        try { TimeUnit.MILLISECONDS.sleep(1000); } catch (InterruptedException e ) { e.printStackTrace() ; }

        new Thread(() -> {
            LockSupport.unpark(t1);

            System.out.println(Thread.currentThread().getName() + "\t" + "我成功唤醒了 t1");

        }, "t2").start();

    }
}

```

```java
* @description : 嗲用LockSupport.unpark()会使permit加1  但是permit的上线只能为1 因此线程会陷入阻塞
 */
public class ThreadParkUnpark3 {

    public static void main(String[] args)//main 方法，主线程一切程序入口
    {

        Thread t1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t" + "---come in");
            LockSupport.park();
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "\t" + "---被唤醒");
        }, "t1");
        t1.start();

        new Thread(() -> {
            LockSupport.unpark(t1);

            LockSupport.unpark(t1);
            System.out.println(Thread.currentThread().getName() + "\t" + "---发出通知");
        }, "t2").start();
    }
}
```

每个线程都有一个相关的permit，permit最多只有一个，重复调用unpark也不会积累凭证。

线程阻塞需要消耗凭证(permit)，这个凭证最多只有1个。

1、当调用park方法时

如果有凭证，则会直接消耗掉这个凭证然后正常退出;

如果无凭证，就必须阻塞等待凭证可用;

2、而unpark则相反，它会增加一个凭证，但凭证最多只能有1个，累加无效。

# Java内存模型之JMM

Java虚拟机规范中试图定义一中java内存模型 （java Memory Model , 简称JMM）来屏蔽掉各种硬件和操作系统的内存访问差异  以实现让Java程序在个平台下都能够达到一致的内存访问效果

## JMM 可见性

是指当一个线程修改了某一个共享变量的值，其他线程是否能够立即知道该变更  ， JMM 规定了所有的变量都存储在 主内存 中。

![img](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303191535411.png)

![img](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303191535638.png)

Java 中 普通的共享变量不保证可见性 ，因为数据修改被写入内存的时机是不确定的，多线程并发下很可能出现 " 脏读 " ，所以每个线程都有自己的 工作内存 ，线程自己的工作内存中保存了该线程使用到的变量的 ==主内存副本拷贝== ，==线程对变量的所有操作（读取，赋值等 ）都必需在线程自己的工作内存中进行，而不能够直接读写主内存中的变量==。不同线程之间也无法直接访问对方工作内存中的变量，线程间变量值的传递均需要通过主内存来完成

![img](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303191538180.png)

## JMM原子性

指一个线程是不可中断的 即多线程环境下 操作不能被其他线程干扰 

## JMM有序性

对于一个线程的执行代码而言，我们总是习惯性认为代码的执行总是从上到下，有序执行。  

但为了提供性能，编译器和处理器通常会对指令序列进行重新排序。 

指令重排 可以保证串行语义一致 ，但没有义务保证 多线程间的语义也一致 ，即可能产生 " 脏读 " ，简单说，  

两行以上不相干的代码在执行的时候有可能先执行的不是第一条， 不见得是从上到下顺序执行，执行顺序 会被优化 。 

![img](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303191545355.png)

单线程 环境里面确保程序最终执行结果和代码顺序执行的结果一致。

处理器在进行重排序时们必须考虑指令之间的数据依赖性

所线程环境中线程叫交替执行 由于编译器优化重排的存在 ，两个线程中使用的变量能否保证一致性是无法确定的 结果无法预测

## JMM 多线程对变量的读写过程

### 读取过程

由于 JVM 运行程序的实体是线程，而每个线程创建时 JVM 都会为其创建一个工作内存 ( 有些地方称为栈空间 ) ，工作内存是每个线程的私有数据区域，而 Java 内存模型中规定所有变量都存储在 主内存 ，主内存是共享内存区域，所有线程都可以访问， 但线程对变量的操作 ( 读取赋值等 ) 必须在工作内存中进行，首先要将变量从主内存拷贝到的线程自己的工作内存空间，然后对变量进行操作，操作完成后再将变量写回主内存， 不能直接操作主内存中的变量，各个线程中的工作内存中存储着主内存中的 变量副本拷贝 ，因此不同的线程间无法访问对方的工作内存，线程间的通信 ( 传值 ) 必须通过主内存来完成，其简要访问过程如下图 :   
![img](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303191552432.png)

JMM定义了线程和主存之间的抽象关系

1 、线程之间的共享变量存储在主内存中 ( 从硬件角度来说就是内存条 )  

2 、每个线程都有一个私有的本地工作内存，本地工作内存中存储了该线程用来读 / 写共享变量的副本 ( 从硬件角度来说就是 CPU 的缓存，比如寄存器、 L1 、 L2 、 L3 缓存等 )  

## 小总结

我们定义的所有共享变量都储存在物理主内存中
每个线程都有自己独立的工作内存，里面保存该线程使用到的变量的副本(主内存中该变量的一份拷贝)
线程对共享变量所有的操作都必须先在线程自己的工作内存中进行后写回主内存，不能直接从主内存中读写(不能越级)
不同线程之间也无法直接访问其他线程的工作内存中的变量，线程间变量值的传递需要通过主内存来进行(同级不能相互访问)

## JMM规范下，多线程先行发生原则之happens-before

1. 如果一个操作happens-before另一个操作，那么第一个操作的执行结果将对第二个操作可见，而且第一个操作的执行顺序排在第二个操作之前。
2. 两个操作之间存在happens-before关系，并不意味着一定要按照happens-before原则制定的顺序来执行。

# volatite与java内存模型

## 被volatite修改的变量有2个特点

可见性、有序性  排序要求

## **volatile的内存语义**

当写一个 volatile变量时 JMM会把该线程对应的本地内存中的共享变量值立即刷新回主内存中。

当读一个volatile变量时，JMM会把该线程对应的本地内存设置为无效，直接从主内存中读取共享变量，

## 内存屏障

  内存屏障（也称内存栅栏，内存栅障，屏障指令等，是一类同步屏障指令，是 CPU 或编译器在对内存随机访问的操作中的一个同步点，使得此点之前的所有读写操作都执行后才可以开始执行此点之后的操作），避免代码重排序。内存屏障其实就是一种 JVM 指令， Java 内存模型的重排规则会 要求 Java 编译器在生成 JVM 指令时插入特定的内存屏障指令 ，通过这些内存屏障指令， volatile 实现了 Java 内存模型中的可见性和有序性，==但 volatile 无法保证原子性。== 



内存屏障之前 的所有 写操作都要回写到主内存

内存屏障之后 的所有读操作都能获得内存屏障之前的所有写操作的最新结果 ( 实现了可见性 ) 。  

因此[重排序](https://so.csdn.net/so/search?q=重排序&spm=1001.2101.3001.7020)时，不允许把内存屏障之后的指令重排序到内存屏障之前。  

一句话：对一个 volatile 域的写 , happens-before 于任意后续对这个 volatile 域的读，也叫写后读。  

## **volatile凭什么可以保证可见性和有序性？？？**

内存屏障 (Memory Barriers / Fences)

![image-20230319211938968](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303192119053.png)

## Volatite特性

## 一、保证可见性

保证不同线程对这个变量进行操作时的可见性 即变量一旦改变所有线程即可见

```java
     static volatile boolean flag = true;

    // static  boolean flag = true;

    public static void main(String[] args) {
        new Thread(() -> {

            System.out.println(Thread.currentThread().getName() + "\t" + "---come in");

            while(flag) {
                new Integer(308);
            }
            System.out.println("t1 over");
        }, "t1").start();

        try { TimeUnit.MILLISECONDS.sleep(500); } catch (InterruptedException e ) { e.printStackTrace() ; }

        new Thread(() -> flag = false, "t2").start();
    }
```

使用volatile修饰共享变量，就可以达到上面的效果，被volatile修改的变量有以下特点： 

1、线程中读取的时候，每次读取都会去主内存中读取共享变量最新的值，然后将其复制到工作内存 

2、线程中修改了工作内存中变量的副本，修改之后会立即刷新到主内存 

## volatile变量的读写过程

Java内存模型中定义的8种工作内存与主内存之间的原子操作 

read(读取)→load(加载)→use(使用)→assign(赋值)→store(存储)→write(写入)→ lock(锁定)→unlock(解锁) 

```
read:  作用于主内存 ，将变量的值从主内存传输到工作内存，主内存到工作内存 

load: 作用于工作内存，将read从主内存传输的变量值放入工作 内存变量副本 中，即数据加载 

use: 作用于工作内存，将工作内存变量副本的值传递给执行引擎，每当JVM遇到需要该变量的字节码指令时会执行该操作 

assign: 作用于工作内存，将从执行引擎接收到的值赋值给工作内存变量，每当JVM遇到一个给变量赋值字节码指令时会执行该操作 

store: 作用于工作内存，将赋值完毕的工作变量的值写回给主内存 

write:  作用于主内存 ，将store传输过来的变量值赋值给主内存中的变量 

由于上述只能保证单条指令的原子性，针对多条指令的组合性原子保证，没有大面积加锁 ，所以，JVM提供了另外两个原子指令 ： 

lock: 作用于主内存 ，将一个变量标记为一个线程独占的状态，只是写时候加锁，就只是锁了写变量的过程。 

unlock: 作用于主内存 ，把一个处于锁定状态的变量释放，然后才能被其他线程占用 

```

## 二、没有原子性

==原子性指的是一个操作不可中断的 即使在多线程环境下 一个操作一旦开始就不会被其他线程影响==

volatile变量的复合操作(如i++)不具有原子性

```java
public class VolatileNoAtomicDemo {

    public static void main(String[] args) {
        MyNumber myNumber = new MyNumber();

        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++)
                    myNumber.addPlusPlus();
            }, String.valueOf(i)).start();
        }

        try { TimeUnit.MILLISECONDS.sleep(1000); } catch (InterruptedException e ) { e.printStackTrace() ; }

        System.out.println(Thread.currentThread().getName() + "\t" + myNumber.number);
    }
}

class MyNumber {
    volatile int number = 0 ;

    public void addPlusPlus() {
        number ++;
    }
}
```

多线程环境下 "数据计算"和"数据赋值"操作可能多次出现 及操作非原子 若数据在加载之后，若主内存count变量发生修改之后，由于线程工作内存中的值在此前已经加载，从而不会对变更操作做出相应变化，即私有内存和公共内存中变量不同步，进而导致数据不一致 

由此可见volatile解决的是变量读时的可见性问题，但无法保证原子性，对于多线程修改共享变量的场景必须使用加锁同步 

## 既然一修改就是可见，为什么还不能保证原子性？

volatile主要对其中部分指令做了处理  要使用一个变量的时候必须 load(载入) ，要载入的时候必需从主内存 read( 读取）这样就解决了读的可见性。写操作是把 assign 和 store 做了关联 ( 在 assign( 赋值 ) 后必需 store( 存储 )) 。 store( 存储 ) 后 write( 写入 ) 。也就是做到了给一个变量赋值的时候一串关联指令直接把变量值写到主内存。 就这样通过用的时候直接从主内存取，在赋值到直接写回主内存做到了内存可见性。

==由于volatile变量只能保证可见性，在不符合以下两条规则的运算场景中，我们仍然要通(使用synchronized、java.util.concurrent中的锁或原子类)来保证原子性：==  运算结果并不依赖变量的当前值 或者能够确保只有单一的线程修改变量的值。变量不需要与其他的状态变量共同参与不变约束

**面试回答：**JVM的字节码，i++分成三步，间隙期不同步非原子操作(i++)

![img](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303200006307.png)

## 三、指令禁止重排

重排序是指编译器和处理器为了优化程序性能而对指令序列进行重新排序的一种手段，有时候会改变程序语句的先后顺序   不存在数据依赖关系，可以重排序；  存在数据依赖关系 禁止重排序

但重排后的指令据不能改变原有的串行语义！

### 重排序的分类和执行流程

![img](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303200104775.png)

编译器优化的重排序 ： 编译器在不改变单线程传形成语义的前提下 可以重新调整指令的执行顺序

指令集并行的重排序： 处理器使用指令级并行技术来将多条指令重叠执行，若不存在数据依赖性，处理器可以改变语句对应机器指令的执行顺序  

内存系统的重排序 ：  由于处理器使用缓存和读 / 写缓冲区，这使得加载和存储操作看上去可能是乱序执行  

**数据依赖性** ： 若两个操作访问同一变量，且这两个操作中有一个为写操作，此时两操作间就存在数据依赖性。 

![image-20230320010738666](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303200107737.png)

***\*存在\**** 数据依赖关系 ，禁止重排序 ===> 重排序发生，会导致程序运行结果不同。  

编译器和处理器在重排序时，会遵守数据依赖性 不会改变存在依赖关系的两个操作的执行 但不同处理器和不同线程之间的数据行不会被编译器和处理器考虑 其只会作用于单处理器和单线程环境 下面三种情况，只要重排序两个操作的执行顺序，程序的执行结果就会被改变。  

![image-20230320011011914](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303200110989.png)

## 正确使用volatile 

### 单一赋值可以 but含符合运算赋值不可以（i ++之类）

>***\*volatile int a\**** = 10
>
>***\*volatile boolean flag\**** = ***\*false\****

### 状态标识 判断业务是否结束

```java
package com.atguigu.juc.jmm;
 
import java.util.concurrent.TimeUnit;
 
/**
 * @auther zzyy
 * @create 2021-03-17 15:00
 *   使用：作为一个布尔状态标志，用于指示发生了一个重要的一次性事件，例如完成初始化或任务结束  
 *   理由：状态标志并不依赖于程序内任何其他状态，且通常只有一种状态转换  
 *   例子：判断业务是否结束
 */
public class UseVolatileDemo {
    private volatile static boolean flag = true;
 
    public static void main(String[] args) {
        new Thread(() -> {
            while (flag) {
                //do something......
            }
        }, "t1").start();
        // 暂停几秒钟线程
        try {
            TimeUnit.SECONDS.sleep(2L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            flag = false;
        }, "t2").start();
    }
}
```

### 开销较低的读，写锁策略

```java
package com.atguigu.juc.jmm;
 
/**
 * @auther zzyy
 * @create 2021-03-17 15:00
 * 使用：当读远多于写，结合使用内部锁和  volatile  变量来减少同步的开销
 * 理由：利用 volatile 保证读取操作的可见性；利用 synchronized 保证复合操作的原子性
 */
public class Counter {
    private volatile int value;
 
    public int getValue() {
        return value;
        // 利用 volatile 保证读取操作的可见性
    }
 
    public synchronized int increment() {
        return value++; // 利用 synchronized 保证复合操作的原子性 
    }
}
```

## DCL双端锁的发布引起的问题

```java
package com.atguigu.juc.jmm;
 
/**
 * @auther zzyy
 * @create 2021-03-17 15:00
 */
public class SafeDoubleCheckSingleton
{
    private  static SafeDoubleCheckSingleton singleton = null;
    //私有化构造方法
    private SafeDoubleCheckSingleton(){ }
 
    //双重锁设计
    public static SafeDoubleCheckSingleton getInstance(){
        if (singleton == null){
            //1.多线程并发创建对象时，会通过加锁保证只有一个线程能创建对象
            synchronized (SafeDoubleCheckSingleton.class){
                if (singleton == null){
                    //隐患：多线程环境下，由于重排序，该对象可能还未完成初始化就被其他线程读取
                    singleton = new SafeDoubleCheckSingleton();
                }
            }
        }
        //2.对象创建完毕，执行getInstance()将不需要获取锁，直接返回创建对象
        return singleton;
    }
 
    public static void main(String[] args)
    {
        SafeDoubleCheckSingleton instance = SafeDoubleCheckSingleton.getInstance();
 
    }
}
```

引起的问题

![image-20230320012745401](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303200127496.png)

解决01： 加volatile修饰

```java
package com.atguigu.juc.jmm;
 
/**
 * @auther zzyy
 * @create 2021-03-17 15:00
 */
public class SafeDoubleCheckSingleton
{
    // 通过 volatile 声明，实现线程安全的延迟初始化。
    private volatile static SafeDoubleCheckSingleton singleton = null;
    //私有化构造方法
    private SafeDoubleCheckSingleton(){ }
 
    //双重锁设计
    public static SafeDoubleCheckSingleton getInstance(){
        if (singleton == null){
            //1.多线程并发创建对象时，会通过加锁保证只有一个线程能创建对象
            synchronized (SafeDoubleCheckSingleton.class){
                if (singleton == null){
                    //隐患：多线程环境下，由于重排序，该对象可能还未完成初始化就被其他线程读取
                    // 原理 : 利用 volatile ，禁止  " 初始化对象 "(2)  和  " 设置 singleton 指向内存空间 "(3)  的重排序 
                    singleton = new SafeDoubleCheckSingleton();
                }
            }
        }
        //2.对象创建完毕，执行getInstance()将不需要获取锁，直接返回创建对象
        return singleton;
    }
 
    public static void main(String[] args)
    {
        SafeDoubleCheckSingleton instance = SafeDoubleCheckSingleton.getInstance();
 
    }
}
```

解决02：采用静态内部类的方式实现

```java
package com.atguigu.juc.jmm;
 
/**
 * @auther zzyy
 * @create 2021-03-19 19:21
 */
public class SingletonDemo
{   //现在比较好的做法就是采用静态内部内的方式实现 
    // 私有化构造方法
    private SingletonDemo() { }
   
    private static class SingletonDemoHandler
    {
        private static SingletonDemo instance = new SingletonDemo();
    }
 
    public static SingletonDemo getInstance()
    {
        return SingletonDemoHandler.instance;
    }
}
```

## ==最后的小总结==

### **内存屏障是什么**

内存屏障：是一种 屏障指令，它使得CPU或编译器 对 屏障指令的前 和 后 所发出的内存操作 执行一个排序的约束。也叫内存栅栏  或 栅栏指令

### **内存屏障能干嘛**

阻止屏障两边的指令重排序

写数据时加入屏障，强制将线程私有工作内存的数据刷回主物理内存

读数据时加入屏障，线程私有工作内存的数据失效，重新到主物理内存中获取最新数据

### **内存屏障四大指令**

#### 1、在每一个volatile写操作前面插入一个StoreStore屏障

![img](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303200133837.png)

#### 2、在每一个volatile写操作后面插入一个StoreLoad屏障

![img](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303200133690.png)

#### 3、在每一个volatile读操作后面插入一个LoadLoad屏障

![img](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303200134707.png)

#### 4、在每一个volatile读操作后面插入一个LoadStore屏障

![img](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303200134090.png)

### **5.4、凭什么我们java写了一个volatile关键字 ，系统底层加入内存屏障？两者关系怎么勾搭上的?**

![img](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303200135403.png)

![image-20230320013540059](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303200135127.png)

### volatile可见性

volatile关键字保证可见性，意味看：

1:对一个volatile修饰的变量进行读操作的话，总是能够读到这个变量的最新的值，也就是这个变量最后被修改的值

2:一个线程修改了volatile修饰的变量的值的时候，那么这个变量的新的值，会立即刷新回到主内存中

3:一个线程去读取volatile修饰的变量的值的时候，该变量在工作内存中的数据无效，需要重新到主内存去读取最新的数据

### **volatile禁重排**

**写指令**

![image-20230320013703441](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303200137621.png)

**读指令**

![image-20230320013729002](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303200137161.png)

### **对比java.util.concurrent.locks.Lock来理解**

cpu执行机器码指令的时候，是使用lock前缀指令来实现volatile的功能的。

Lock指令，相当于内存屏障，功能也类似内存屏障的功能：

(1)首先对总线/缓存加锁，然后去执行后面的指令，最后，释放锁，同时把高速缓存的数据刷新回到主内存

(2)在lock锁住总线/缓存的时候，其它cpu的读写请求就会被阻塞，直到锁释放。Lock过后的写操作，会让其它cpu的高速缓存中相应的数据失效，这样后续这些cpu在读取数据的时候，就会从主内存去加载最新的数据

加了Lock指令过后的具体表现，就跟JMM添加内存屏障后一样

### **一句话总结**

volatile写之前的操作，都禁止重排序到volatile之后

volatile读之后的操作，都禁止重排序到volatile之前

volatile写之后volatile读，禁止重排序

# CAS

compare and swap的缩写    实现并发算法常用的一种技术 包含三个操作数 ----- ==内存位置、预期原值以及更新值==

执行CAS操作时 将内存位置的值与预期原值相比较 ：

如果匹配 那么处理器会自动将该位置的与预期原值相比较；

如果不匹配 处理器不做任何操作 多个线程同时执行CAS操作只有一个会成功 。

==CAS的原子性实际上是CPU实现的==

demo

```java
 public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5); // 初始化

        System.out.println(atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(5,109) + "\t" + atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(5,1011) + "\t" + atomicInteger.get());

    }
```

## 总结 

CAS是靠硬件实现的 从而再硬件层面提升效率额最底层还是交给硬件来把保证原子性和可见性 

实现方式是基于硬件平台的汇编指令 在intel的CPU中(X86机器上)，使用的是汇编指令cmpxchg指令。 

==核心思想==就是：比较要更新变量的值V和预期值E（compare），相等才会将V的值设为新值N（swap）如果不相等自旋再来。 

## 原子引用

### 原子整形

AtomicInterger、AtomicBook、AtomicOrder

原子引用Demo

```java
public class AtomicReferenceDemo {

    public static void main(String[] args) {
        User z3 = new User("z3",24);

        User lisi = new User("lisi" , 21 , "lzy");

        User ww = new User("ww" , 26);

        AtomicReference<User> atomicReference = new AtomicReference<>();

        atomicReference.set(z3); //指定对一个引用使用原子操作类
        // 对用用赋值并获取引用的一个值  将z3这个引用赋值为lisi
        System.out.println(atomicReference.compareAndSet(z3,lisi)+"\t"+atomicReference.get().toString());
        // 我的理解是模拟第二个线程来修改它
        System.out.println(atomicReference.compareAndSet(z3,ww)+"\t"+atomicReference.get().toString());


    }
}


@Getter
@ToString
@AllArgsConstructor
class User {
    String UserName;

    int age;

    public User(String userName, int age , String message) {
        UserName = userName;
        this.age = age;

        System.out.println("我的宝贝女孩啊：" + message);
    }
}
```

## 自旋锁 借鉴CAS思想

自旋锁 spinlock

尝试获取锁的线程不会立即阻塞 而是采用 ==循环的方式== 去尝试获取锁 

当线程发现锁被占用时 ，会不断循环判断锁的状态 直到获取 

好处 ：减少线程上下文切换的消耗

缺点 ：循环会消耗 CPU

SpinLockDemo

```java
public class SpinLockDemo {

    // 声明一个原子引用自旋锁
    AtomicReference<Thread> atmoicReference = new AtomicReference<>();

    public void myLock() {
        System.out.println(Thread.currentThread().getName() + "\t" + "--------come in");

        // 设置当前线程为 null 如果设置失败 就返回 false
        while(!atmoicReference.compareAndSet(null,Thread.currentThread())){
            // 等待锁的释放


            System.out.println("呜呜呜 自旋锁被拿走了 等待锁释放的逻辑代码");
        }

        System.out.println(Thread.currentThread().getName() + "\t" + "-----------持有锁成功");

    }


    public void MyUnlock() {
        // 你知道这个 compareAndSet什么意思嘛 ？？？？
        atmoicReference.compareAndSet(Thread.currentThread() , null);

        System.out.println(Thread.currentThread().getName() + "\t" + "--------------释放锁成功");
    }

    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();

        new Thread(() -> {

            // 获得自旋锁
            spinLockDemo.myLock();

            try { TimeUnit.MILLISECONDS.sleep(10); } catch (InterruptedException e ) { e.printStackTrace() ; }

            spinLockDemo.MyUnlock();


        }, "t1").start();

        new Thread(() -> {

            spinLockDemo.myLock();

            spinLockDemo.MyUnlock();

        }, "t2").start();
    }
}
```

### 引发出来的问题 

会导致ABA问题

CAS算法实现一个重要前提需要取出内存中某时刻的数据并在当下时刻比较并替换，那么在这个时间差类会导致数据的变化。 

>比如说一个线程one从内存位置V中取出A，这时候另一个线程two也从内存中取出A，并且线程two进行了一些操作将值变成了B， 
>
>然后线程two又将V位置的数据变成A，这时候线程one进行CAS操作发现内存中仍然是A，然后线程one操作成功。 

尽管线程one的CAS操作成功，但是不代表这个过程就是没有问题的。 

# ThreadLocal

ThreadLocal提供局部变量 每一个线程在访问ThreadLocal实例的时候（通过其get和set方法）==都有自己的 独立初始化的变量副本== ThreadLocal实例通常是类中的私有静态字段，使用它的目的是希望将状态（例如，用户ID或事务ID）与线程关联起来

它是线程安全的 

## 作用

ThreadLocal是Thread的局部变量 用于编多线程程序 对解决多线程程序的并发问题有一定的启示作用

实现每一个线程都有自己专属的本地变量副本 

解决了让每个线程绑定自己的值 通过get（）和set() 方法 获取默认值或将其值更改为当前线程所存的副本的值从而避免了[线程安全问题](https://so.csdn.net/so/search?q=线程安全问题&spm=1001.2101.3001.7020)

Demo

```java
class House {
    // 第一次创建就会初始化一个 int整形的函数 后面的访问中就不会都将使用自己的局部变量的副本
    ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    public void saleHouse(){
        Integer value = threadLocal.get();
        ++value;
        threadLocal.set(value);
    }
}

public class ThreadLocalDemo2{

    public static void main(String[] args){
        House house = new House();

        new Thread(() -> {
            try{
                for (int j = 1; j <=3; j++) {
                    house.saleHouse();
                }
                System.out.println(Thread.currentThread().getName()+"\t"+"---卖出： "+house.threadLocal.get()); // 3
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                // 如果不清理自定义的  ThreadLocal  变量，可能会影响后续业务逻辑和造成内存泄露等问题
                house.threadLocal.remove();
            }
        },"t1").start();

        new Thread(() -> {
            try {
                for (int j = 1; j <=2; j++) {
                    house.saleHouse();
                }
                System.out.println(Thread.currentThread().getName()+"\t"+"---卖出： "+house.threadLocal.get());
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                house.threadLocal.remove();
            }
        },"t2").start();

        new Thread(() -> {
            try{
                for (int j = 1; j <=5; j++) {
                    house.saleHouse();
                }
                System.out.println(Thread.currentThread().getName()+"\t"+"---卖出： "+house.threadLocal.get());
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                house.threadLocal.remove();
            }
        },"t3").start();

        System.out.println(Thread.currentThread().getName()+"\t"+"---卖出： "+house.threadLocal.get());

    }
}

/*
每个 Thread内有自己的实例副本 且该副本只由房前线程自己调用 其他Thread不可访问
统一设置初始值，但是每个线程对这个值的修改都是各自线程互相独立的
*/
```

## 小感悟

```
1 加入synchronized或者Lock控制资源的访问顺序
2 人手一份，大家各自安好，没必要抢夺
```

## **非线程安全的SimpleDateFormat**

SimpleDateFormat类内部有一个Calendar对象引用 用来储存和这个SimpleDateFormat相关的日期信息 例如sdf.parse(dateStr),sdf.format(date) 诸如此类的方法参数传入的日期相关String,Date等等, 都是交由Calendar引用来储存的.这样就会导致一个问题 如果你的SimpleDateFormat是个static的, 那么多个thread 之间就会共享这个 impleDateFormat, 同时也是共享这个Calendar引用。 


## 解决方法 

1、将 SimpleDateFormat定义成局部变量解决线程不安全

```java
public class DateUtils {
    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {

            new Thread(() -> {

                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    System.out.println(sdf.parse("2023-03-23 23:23:23"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
```

2、线程本地变量进行线程本地存储

```java
public class DateUtils2 {

    private static final ThreadLocal<SimpleDateFormat> sdf_threadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    /*
    * threadLocal可以确保每个线程可以得到一个独立的SimpledateFormat的对象 不存在竞争问题
    */

    public static Date parseDateTL(String stringDate) throws Exception {
        return sdf_threadLocal.get().parse(stringDate); // 获取到的是一个 SimpleDateFormat对象
    }

    public static void main(String[] args) {

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {

                try {
                    System.out.println(DateUtils2.parseDateTL("2023-03-23 23:23:23"));
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }, String.valueOf(i)).start();

        }
    }
}
```

## **Thread，ThreadLocal，ThreadLocalMap 关系**

Thread和ThreadLocal关系

![img](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303232100433.png)

ThreadLocal和ThreadLocalMap

![img](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303232101416.png)

三者之间的关系 

![img](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303232102111.png)

其中 threadLocalMap 实际上就是一个以 threadLocal实例为 key ，任意对象为 value的 Entry对象 当对threadLocal变量赋值，实际上就是当以前threadLocal实例为 key，值为 value的 Entry往这个threadLocalMap中存放

## 总结 

ThreadLocalMap 从字面上就可以看出这是一个保存 ThreadLocal 对象的 map( 其实是以 ThreadLocal 为 Key) ，不过是经过了两层包装的 ThreadLocal 对象：

![img](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303232107579.png)

JVM 内部维护了一个线程版的 Map<Thread,T>( 通过 ThreadLocal 对象的 set 方法，结果把 ThreadLocal 对象自己当做 key ，放进了 ThreadLoalMap 中 ) , 每个线程要用到这个 T 的时候，用当前的线程去 Map 里面获取， 通过这样让每个线程都拥有了自己独立的变量 ，人手一份，竞争条件被彻底消除，在并发模式下是绝对安全的变量。   

## 内存泄漏

不再会被使用的对象或者变量占用的内存不能被回收 

## 强引用、软引用、弱引用、虚引用

当内存不足 jvm开始垃圾回收 强引用是默认支持模式 

只要还有强引用指向一个对象，就能表明对象还“活着”，垃圾收集器不会碰这种对象。在 Java 中最常见的就是强引用，把一个对象赋给一个引用变量，这个引用变量就是一个强引用。当一个对象被强引用变量引用时，它处于可达状态，它是不可能被垃圾回收机制回收的， 即使该对象以后永远都不会被用到JVM也不会回收 。因此强引用是造成Java内存泄漏的主要原因之一。 



软引用相对强引用弱化了一些的引用 可以让对象豁免一些垃圾收集 

高速缓存就有用到软引用 内存够用的时候就保留 不够用就回收 

对于只有弱引用的对象来说，只要垃圾回收机制一运行，不管JVM的内存空间是否足够，都会回收该对象占用的内存。

### ThreadLocalMap与WeakReference

ThreadLocalMap 从字面上就可以看出这是一个保存 ThreadLocal 对象的 map( 其实是以它为 Key) ，不过是经过了两层包装的 ThreadLocal 对象：

>1.  第一层包装是使用 WeakReference<ThreadLocal<?>> 将 ThreadLocal 对象变成一个 弱引用的对象； 
>2.  第二层包装是定义了一个专门的类 Entry 来扩展 WeakReference<ThreadLocal<?>> ； 

## 小总结

ThreadLocal 并不解决线程间共享数据的问题

ThreadLocal 适用于变量在线程间隔离且在方法间共享的场景

ThreadLocal 通过隐式的在不同线程内创建独立实例副本避免了实例线程安全的问题

每个线程持有一个只属于自己的专属Map并维护了ThreadLocal对象与具体实例的映射，该Map由于只被持有它的线程访问，故不存在线程安全以及锁的问题

ThreadLocalMap的Entry对ThreadLocal的引用为弱引用，避免了ThreadLocal对象无法被回收的问题

# Synchronized与锁升级 



## 每一个对象都可以成为一个锁 

Monitor可以理解为一种同步工具 也是一种同步机制 Java对象是天生的Monitor 每一个 Java 对象都有成为 Monitor 的潜质，因为在 Java 的设计中 ，每一个 Java 对象自打娘胎里出来就带了一把看不见的锁，它叫做内部锁或者 Monitor 锁。  

## 无锁

```java
public class MyObject {
 
    public static void main(String[] args) {
 
        Object o = new Object();
 
        System.out.println("10 进制 hash 码： " + o.hashCode());
 
        System.out.println("16 进制 hash 码： " + Integer.toHexString(o.hashCode()));
 
        System.out.println("2 进制 hash 码： " + Integer.toBinaryString(o.hashCode()));
 
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
 
    }
}
```

## 偏锁

主要作用 

当一段同步代码一直被同一个线程多次访问，由于只有一个线程那么该线程在后续访问时便会自动获得锁，提高只有在一个线程执行同步时的性能

# AbstractQueuedSynchronizer之==AQS==

用来构建锁或者其他同步器组件的==重量级基础框架及整个 JUC体系的基石==，通过内置的FIFO队列来完成资源获取线程的排队工作 并通过一个int类变量表示持有锁的状态



![img](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303240100940.png)

![img](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303240051861.png)

## ReentrantLock

![img](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303240052728.png)

## CountDownLatch

![img](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303240053571.png)

## ReentrantReadWriteLock

![img](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303240054096.png)

## Semaphore

![img](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303240055179.png)



锁，面向锁的使用者 

>定义了程序员和锁交互的使用层API 隐藏了实现细节

同步器，面向锁的实现者

## AQS

AQS使用一个volatile 的int类型的成员变量来表示同步状态，通过内置的FIFO队列完成资源获取的排队的工作将每条要去抢占资源的线程封装成一个Node节点来实现锁的分配，通过CAS完成State值的修改

## AQS内部体系架构

![img](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303240105934.png)

## AQS同步队列的基本结构

![img](https://halo-1308808626.cos.ap-guangzhou.myqcloud.com/images/202303240118095.png)

CLH：Craig、Landin and Hagersten 队列，是个单向链表，AQS中的队列是CLH变体的虚拟双向队列（FIFO） 
