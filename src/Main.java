import java.math.BigDecimal;
import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        while(true) {
            try {
                Calculator calculator = new Calculator();
                Scanner scanner = new Scanner(System.in);
                String a = scanner.nextLine();
                calculator.set_expression(a);
                System.out.println(calculator.calculate());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}