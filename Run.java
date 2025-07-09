import java.util.Scanner;

public class Run {
    Scanner scanner = new Scanner(System.in);
    String expression;
     Logic logic = new Logic();

    public void run() {
        System.out.println("Welcome to the calculator!");
        System.out.print("Enter first number: ");
        double a = scanner.nextDouble();
        System.out.println("Enter expressions: +, -, *, /, ^, sqrt, %:");
        expression = scanner.next();
        System.out.print("Enter second number: ");
        double b = scanner.nextDouble();


        switch (expression) {
            case "+":
                System.out.println("Result: " + logic.add(a, b));
                break;
            case "-":
                System.out.println("Result: " + logic.subtract(a, b));
                break;
            case "*":
                System.out.println("Result: " + logic.multiply(a, b));
                break;
            case "/":
                try {
                    System.out.println("Result: " + logic.divide(a, b));
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
            case "^":
                System.out.println("Result: " + logic.power(a, b));
                break;
            case "sqrt":
                try {
                    System.out.println("Result: " + logic.squareRoot(a));
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
            case "%":
                System.out.println("Result: " + logic.percentage(a, b));
                break;
            default:
                break;
        }
    }
    
}
