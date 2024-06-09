package com.alaoabdulhakeem;

import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            // Prompt user for two numbers
            System.out.print("Enter the first number: ");
            double num1 = scanner.nextDouble();

            System.out.print("Enter the second number: ");
            double num2 = scanner.nextDouble();

            // Prompt user for an operator
            System.out.print("Enter an operator (+, -, *, /): ");
            char operator = scanner.next().charAt(0);

            double result;

            // Perform the corresponding arithmetic operation
            switch (operator) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> {
                    if (num2 == 0) {
                        throw new ArithmeticException("Division by zero is not allowed.");
                    }
                    result = num1 / num2;
                }
                default -> throw new IllegalArgumentException("Invalid operator. Please use one of +, -, *, /.");
            }

            // Display the result
            System.out.println("The result is: " + result);
        } catch (ArithmeticException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
        // Close the scanner
    }
}

