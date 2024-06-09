package com.alaoabdulhakeem;

import java.util.Stack;

public class Calculator {
    private String input;

    public Calculator() {
        this.input = "";
    }

    public String getInput() {
        return input;
    }

    public void appendInput(String value) {
        input += value;
    }

    public void clearInput() {
        input = "";
    }

    public void deleteLastInput() {
        if (!input.isEmpty()) {
            input = input.substring(0, input.length() - 1);
        }
    }

    public String calculateResult() {
        try {
            // Evaluate the input expression using a stack-based algorithm
            Stack<Double> numbers = new Stack<>();
            Stack<Character> operators = new Stack<>();
            StringBuilder numberBuilder = new StringBuilder();

            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (Character.isDigit(ch) || ch == '.') {
                    numberBuilder.append(ch);
                } else {
                    if (numberBuilder.length() > 0) {
                        double number = Double.parseDouble(numberBuilder.toString());
                        numbers.push(number);
                        numberBuilder.setLength(0);
                    }

                    while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(ch)) {
                        processOperator(numbers, operators);
                    }
                    operators.push(ch);
                }
            }

            if (numberBuilder.length() > 0) {
                double number = Double.parseDouble(numberBuilder.toString());
                numbers.push(number);
            }

            while (!operators.isEmpty()) {
                processOperator(numbers, operators);
            }

            return String.valueOf(numbers.pop());
        } catch (Exception e) {
            return "Error";
        }
    }

    private void processOperator(Stack<Double> numbers, Stack<Character> operators) {
        char operator = operators.pop();
        double operand2 = numbers.pop();
        double operand1 = numbers.pop();
        double result = 0.0;
        switch (operator) {
            case '+' -> result = operand1 + operand2;
            case '-' -> result = operand1 - operand2;
            case '*' -> result = operand1 * operand2;
            case '/' -> {
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                result = operand1 / operand2;
            }
        }
        numbers.push(result);
    }


    private int precedence(char operator) {
        return switch (operator) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> 0;
        };
    }

    public double squareRoot(double value) {
        return Math.sqrt(value);
    }

    public double exponentiation(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public double sin(double value) {
        return Math.sin(Math.toRadians(value));
    }

    public double cos(double value) {
        return Math.cos(Math.toRadians(value));
    }

    public double tan(double value) {
        return Math.tan(Math.toRadians(value));
    }
}
