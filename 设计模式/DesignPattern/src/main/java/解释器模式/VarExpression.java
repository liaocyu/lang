package 解释器模式;

import java.util.HashMap;

/**
 * 变量的解析器
 */
public class VarExpression extends Expression{
    private String key;

    public VarExpression(String key) {
        this.key = key;
    }


    //根据变量名称返回对应的值
    @Override
    public int interpret(HashMap<String, Integer> var) {
        return var.get(key);
    }
}
