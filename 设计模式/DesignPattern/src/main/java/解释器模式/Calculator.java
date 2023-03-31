package 解释器模式;

import java.util.HashMap;
import java.util.Stack;

public class Calculator {
    Expression expression;
    public Calculator(String expStr){
        Stack<Expression> stack = new Stack<>();
        char[] charArray = expStr.toCharArray();
        Expression left;
        Expression right;
        for (int i=0;i<charArray.length;i++) {
            char c = charArray[i];
            switch (c){
                case '+':
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    AddExpression addExpression = new AddExpression(left, right);
                    stack.push(addExpression);
                    break;
                case '-':
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    SubstractExpression substractExpression = new SubstractExpression(left,right);
                    stack.push(substractExpression);
                    break;
                default:
                    stack.push(new VarExpression(String.valueOf(c)));
                    break;
            }
        }
        this.expression = stack.pop();
    }
    public int run(HashMap<String,Integer> var){
        return this.expression.interpret(var);
    }
}
