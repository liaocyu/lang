package singleton;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/28 15:59
 * @description :
 *
 * 设计模式----单例模式
 * 解决了多个线程获取同一个实例进行相应的业务逻辑
 */
public class Emperor {

    // 定义一个成员变量 Emperor
    // 后面使用了这个变量 emperor 因此我们需要进行初始化操作
    private static final Emperor emperor = new Emperor();
    private Emperor(){}

    // 获得 实例
    public synchronized static Emperor getInterance() {
        return emperor;
    }
    // 输出名字
    public  void getEmperoorInfo() {
        System.out.println("皇帝 liaocyu");
    }

}
