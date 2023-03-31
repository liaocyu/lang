package Decoratore;

import Decoratore.SchoolReport;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/28 21:35
 * @description :
 */
public class FourGradeSchoolReport extends SchoolReport {

    // 成绩单
    @Override
    public void report() {
        //成绩单的格式是这个样子的
        System.out.println("尊敬的XXX家长:");
        System.out.println(" ......");
        System.out.println(" 语文 62 数学65 体育 98 自然 63");
        System.out.println(" .......");
        System.out.println(" 家长签名： ");
    }

    // 家长签名
    @Override
    public void sign(String name) {
        System.out.println("家长签名为："+name);
    }
}
