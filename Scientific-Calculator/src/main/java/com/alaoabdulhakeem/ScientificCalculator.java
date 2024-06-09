package com.alaoabdulhakeem;

import javax.swing.*;

public class ScientificCalculator {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorGUI calculatorGUI = new CalculatorGUI();
            calculatorGUI.setVisible(true);
        });
    }

}
