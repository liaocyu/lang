package zhouyang.simpleDateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/23 17:09
 * @description : 使用Thread 进行线程本地存储
 */
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
