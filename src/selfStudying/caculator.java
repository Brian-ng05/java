package selfStudying;

import java.util.Scanner;

public class caculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1;
        double num2;
        char operation;
        double result = 0;
        boolean validOpertation = true;

        System.out.print("Enter the first number: ");
        num1 = scanner.nextDouble();
        System.out.print("Enter the second number: ");
        num2 = scanner.nextDouble();
        System.out.print("Enter operation (+, -, *, /): ");
        operation = scanner.next().charAt(0);
        switch (operation) {
            case '+' -> result = num1 + num2;
            case '-' -> result = num1 - num2;
            case '*' -> result = num1 * num2;
            case '/' -> {
                if (num2 == 0) {
                    System.out.println("Cannot divide by zero!");
                    validOpertation = false;
                    result = num1 / num2;
                }
            }
            case '^' -> result = Math.pow(num1, num2);
            default -> {
                System.out.println("Invalid operator");
                validOpertation = false;
            }
        }
        if (validOpertation) {
            System.out.println(result);
        }
        scanner.close();
    }
}
