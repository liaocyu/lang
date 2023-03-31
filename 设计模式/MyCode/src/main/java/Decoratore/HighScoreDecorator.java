package Decoratore;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/28 21:40
 * @description :
 */
public class HighScoreDecorator extends Decorator{
    // extends继承必须实现得构造 ？？？？
    public HighScoreDecorator(SchoolReport sr) {
        super(sr);
    }

    // 汇报最高成绩
    private void reportHighScore() {
        System.out.println("这次考试语文最高是75，数学是78，自然是80");
    }

    // 最高成绩我要当老爸看成绩单前告诉他，否则等他一看，就抡起笤帚有揍我，我那还有机会说呀
    @Override
    public void report() {
        this.reportHighScore();
        super.report();
    }
}
