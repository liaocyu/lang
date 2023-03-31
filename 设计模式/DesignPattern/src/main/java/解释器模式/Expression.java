package 解释器模式;

import java.util.HashMap;

/**
 * 抽象类表达式，通过对HashMap键值对获取变量的值
 */
public abstract class Expression {
    //解释公式和数值
    public abstract int interpret(HashMap<String,Integer> var);
}
