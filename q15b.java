package questions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class q15b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter two integers:");
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            int result = num1 / num2;
            System.out.println("The result is: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter an integer.");
        } finally {
            scanner.close();
        }
    }
}