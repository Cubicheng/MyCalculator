import java.math.BigDecimal;
import java.util.Stack;
import java.lang.Character;
import com.calc.Operator.*;

public class Calculator {
    private String expression;
    private final Stack<BigDecimal> number_stack = new Stack<BigDecimal>();
    private final Stack<Character> operator_stack = new Stack<Character>();

    public void set_expression(String expression) {
        this.expression=expression;
    }

    private boolean is_operator(char op){
        return op == '+' || op == '-' || op == '*' || op == '/' ||
                op == '(' || op == ')';
    }

    private int get_operator_rank(char op){
        if(op=='*'||op=='/')
            return 2;
        return 1;
    }

    private void do_one_calc(){
        if(operator_stack.isEmpty()) {
            throw new IllegalStateException("Lack of operators!");
        }
        if(number_stack.size()<2){
            throw new IllegalStateException("Lack of numbers!");
        }
        Operator op = OperatorFactory.createOperator(number_stack.pop(), number_stack.pop(), operator_stack.pop());
        number_stack.push(op.getResult());
    }

    private void pop_until_left_bracket(){
        while(!operator_stack.isEmpty()&&operator_stack.peek()!='(') {
            do_one_calc();
        }
        if(operator_stack.isEmpty()||operator_stack.peek()!='(') {
            throw new IllegalStateException("Mismatched parentheses!");
        }
        operator_stack.pop(); // pop '('
    }

    private void pop_until_rank_ch_is_higher(char op){
        while(!operator_stack.isEmpty()&&operator_stack.peek()!='('&&get_operator_rank(operator_stack.peek())>=get_operator_rank(op)) {
            do_one_calc();
        }
        operator_stack.push(op);
    }

    public String calculate() {
        DecimalNumber number = new DecimalNumber();
        for (int i = 0;i<expression.length();i++) {
            char ch = expression.charAt(i);
            if(ch==' '){
                throw new IllegalArgumentException("Can not contain space.");
            }
            if(!Character.isDigit(ch)&&!is_operator(ch)&&ch!='.') {
                throw new IllegalArgumentException("Only could contain 0~9 '.' '+' '-' '*' '/' '(' ')'.");
            }
        }
        for (int i = 0;i<expression.length();i++) {
            char ch = expression.charAt(i);
            if(Character.isDigit((ch))){
                number.addOneDigit(ch);
                //当前位是数字，下一位是结尾或者是符号，即这个数字结束
                if(i==expression.length()-1||is_operator(expression.charAt(i+1))) {
                    number_stack.push(number.getNumber());
                    number = new DecimalNumber();
                }
            }else if(ch=='.'){
                number.set_is_decimal(true);
            }else{
                if(ch=='(') {
                    operator_stack.push(ch);
                }else if(ch==')') {
                    pop_until_left_bracket();
                }else{
                    pop_until_rank_ch_is_higher(ch);
                }
            }
        }
        while(!operator_stack.isEmpty()){
            do_one_calc();
        }
        return number_stack.pop().toString();
    }
}
