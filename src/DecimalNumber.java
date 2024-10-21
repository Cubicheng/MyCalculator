import java.math.BigDecimal;

public class DecimalNumber {
    private BigDecimal number=new BigDecimal("0");
    private boolean is_decimal = false;
    private BigDecimal decimal_depth = new BigDecimal("1");

    public BigDecimal getNumber(){
        return number;
    }

    public void addOneDigit(Character ch){
        if(!Character.isDigit(ch)) {
            throw new IllegalArgumentException("Invalid number"+ch);
        }
        if(is_decimal){
            decimal_depth = decimal_depth.multiply(new BigDecimal("0.1"));
            number = number.add(decimal_depth.multiply(new BigDecimal(ch.toString())));
        }else {
            number = number.multiply(new BigDecimal("10")).add(new BigDecimal(ch.toString()));
        }
    }

    public void set_is_decimal(boolean is_decimal){
        this.is_decimal = is_decimal;
    }
}
