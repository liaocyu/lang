package Decoratore;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/28 21:43
 * @description :
 */
public class SortDecorator extends Decorator{
    // 构造函数
    public SortDecorator(SchoolReport sr) {
        super(sr);
    }

    //告诉老爸学校的排名情况
    private void reportSort(){
        System.out.println("我是排名第38名...");
    }

    //老爸看完成绩单后再告诉他，加强作用
    @Override
    public void report(){
        super.report();
        this.reportSort();
    }



}
