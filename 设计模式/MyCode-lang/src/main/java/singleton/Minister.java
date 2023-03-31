package singleton;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/28 16:04
 * @description :
 *
 *
 * 我们使用这个类去获得一个实例 并且获得的实列都一样
 */
public class Minister {
    public static void main(String[] args) {

        Emperor emperor = Emperor.getInterance();
        emperor.getEmperoorInfo();

        Emperor emperor1 = Emperor.getInterance();
        emperor1.getEmperoorInfo();

        Emperor emperor2 = Emperor.getInterance();
        emperor2.getEmperoorInfo();

        System.out.println(emperor );
        System.out.println(emperor1 );


    }
}
