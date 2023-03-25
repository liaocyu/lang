# Java IO流

存储和读取数据的解决方案

## IO流的作用

用于读写数据（本地文件，网络）

## IO流按照流向可以分类哪两种流？

输出流：程序 ==> 文件
输入流：文件 ==> 程序

## IO流按照操作文件的类型可以分类哪两种流？

### 字节流：可以操作所有类型的文件

InputStream ====> 输入流

>

outputStream ====> 输出流 

>1、FileOutputStream 
>
>在创建文件字节输出流 的时候参数可以是表示的路径或者File对象都是可以的。如果文件不存在会创建一个新的文件，但是保证父级路径存在。如果文件已经存在，则会清空文件
>
>write方法的参数时正数 但是实际上写到本地文件中的是整数在ASCLL上对应的字符。每次使用完流都要释放资源
>
>写数据的三种方式 
>
>void write(int b)  // 一次写一个字节数据
>
>void write( byte[] b) // 一次写一个字节数组数据
>
>void write( byte[] b , int off , int len) // 一次写一个字节数组的部分数据
>
>换行 ：在windows中 需要再写一个换行符 （\r\n）
>
>续写 ： 在创建第二个对象时，传入 true

>2、FileInputStream  文件字节输入流 
>
>操作本地文件的字节输入流 可以把本地文件中的数据读取到程序中来 。当文件读到末尾会返回-1 。关于循环读写 while((b = fis.read())!= -1) { ……}。不能 直接用fis.read(),因为会直接移动指针。关于文件拷贝 核心就是边拷贝边读，while((b = fis.read())!= -1) { fos.write()}.
>
>FileInputStream fis = new FileInputStream("myCode/myfile.txt") ;
>
>int b1 = fis.read(); // 一次只能读入一个字节 转换成字母 （char(b1)）；  
>
>在读取的时候我们可以进行多个字节进行读取,流程如下; byte[] bytes = new byte[1024*1024 * 5]; while((len = fis.read(bytes)) != -1) {fos.write(bytes,0,len)}
>
>

### 字符流：只能操作纯文本文件

>Reader字符输入流       writer字符输出流
>
>其中 FileReader 与 FileWriter与 FileInputStream与FileOutputStream用法类似

什么是纯文本文件？
用windows系统自带的记事本打开并且能读懂的文件
txt文件，md文件，xml文件，lrc文件等