package com.alaoabdulhakeem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame implements ActionListener {
    private final Calculator calculator;
    private final JTextArea display;

    public CalculatorGUI() {
        calculator = new Calculator();

        setTitle("Scientific Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null);

        display = new JTextArea(3, 20);
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(display);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(5, 4));
        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "Clear", "Delete", "sqrt", "x^y",
                "sin", "cos", "tan"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "=" -> {
                String result = calculator.calculateResult();
                display.setText(result);
            }
            case "Clear" -> {
                calculator.clearInput();
                display.setText("");
            }
            case "Delete" -> {
                calculator.deleteLastInput();
                display.setText(calculator.getInput());
            }
            case "sqrt" -> {
                double sqrtResult = calculator.squareRoot(Double.parseDouble(calculator.getInput()));
                display.setText(String.valueOf(sqrtResult));
            }
            case "x^y" -> {
                calculator.appendInput("^");
                display.setText(calculator.getInput());
            }
            case "sin" -> {
                double sinResult = calculator.sin(Double.parseDouble(calculator.getInput()));
                display.setText(String.valueOf(sinResult));
            }
            case "cos" -> {
                double cosResult = calculator.cos(Double.parseDouble(calculator.getInput()));
                display.setText(String.valueOf(cosResult));
            }
            case "tan" -> {
                double tanResult = calculator.tan(Double.parseDouble(calculator.getInput()));
                display.setText(String.valueOf(tanResult));
            }
            default -> {
                calculator.appendInput(command);
                display.setText(calculator.getInput());
            }
        }
    }

}


