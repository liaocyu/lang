package zhouyang.simpleDateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/23 17:05
 * @description : 将 SimpleDateFormat定义成局部变量解决线程不安全
 */
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
