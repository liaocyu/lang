package zhouyang.强引用;

import java.util.concurrent.TimeUnit;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/23 21:49
 * @description :
 */

class MyObject {
    @Override
    protected void finalize() throws Throwable{
        System.out.println("------------- gc ,finalize() invoked");
    }
}

public class ReferenceDemoCopy {

    public static void main(String[] args) {
        MyObject myObject = new MyObject();//默认，强引用,死了都不放手
        System.out.println("gc before: "+myObject);
        myObject = null;
        System.gc();//手动挡的方式开启Gc回收。
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("gc after: "+myObject);
    }
}
