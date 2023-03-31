package 解释器模式;

import java.util.HashMap;

/**
 * 加法解释器
 */
public class AddExpression extends SymbolExpression{
    public AddExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int interpret(HashMap<String, Integer> var) {
        return super.left.interpret(var)+super.right.interpret(var);
    }
}
