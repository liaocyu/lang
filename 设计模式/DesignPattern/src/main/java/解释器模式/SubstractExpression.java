package 解释器模式;

import java.util.HashMap;

public class SubstractExpression extends SymbolExpression{
    public SubstractExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int interpret(HashMap<String, Integer> var) {
        return super.left.interpret(var)-super.right.interpret(var);
    }
}
