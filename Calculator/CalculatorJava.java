package CalculatorJava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorJava extends JFrame implements ActionListener {
    JTextField displayField;
    JButton[] numButtons;
    JButton[] operationButtons;
    JButton equalsButton;
    JButton clearButton;
    JButton deleteButton;
    JPanel buttonPanel;
    
    double num1, num2, result;
    String operation;

    public CalculatorJava() {
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        displayField = new JTextField();
        displayField.setEditable(true);
         displayField.setPreferredSize(new Dimension(300, 100));
        
        numButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].addActionListener(this);
        }
        
        operationButtons = new JButton[7];
        String[] operationSymbols = {"+", "-", "*", "/", "%", ".", "e"};
        for (int i = 0; i < 7; i++) {
            operationButtons[i] = new JButton(operationSymbols[i]);
            operationButtons[i].addActionListener(this);
        }
        
        equalsButton = new JButton("=");
        equalsButton.addActionListener(this);
        
        clearButton = new JButton("AC");
        clearButton.addActionListener(this);
        
        deleteButton = new JButton("DEL"); 
        deleteButton.addActionListener(this); 
        
        buttonPanel = new JPanel(new GridLayout(5, 4));
        
        buttonPanel.add(clearButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(operationButtons[3]);
        buttonPanel.add(operationButtons[4]);
        buttonPanel.add(numButtons[7]);
        buttonPanel.add(numButtons[8]);
        buttonPanel.add(numButtons[9]);
        buttonPanel.add(operationButtons[2]);
        buttonPanel.add(numButtons[4]);
        buttonPanel.add(numButtons[5]);
        buttonPanel.add(numButtons[6]);
        buttonPanel.add(operationButtons[1]);
        buttonPanel.add(numButtons[1]);
        buttonPanel.add(numButtons[2]);
        buttonPanel.add(numButtons[3]);
        buttonPanel.add(operationButtons[0]);
        buttonPanel.add(operationButtons[6]);
        buttonPanel.add(numButtons[0]);
        buttonPanel.add(operationButtons[5]);
        buttonPanel.add(equalsButton);
       
        setLayout(new BorderLayout());
        add(displayField, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source == clearButton) {
            displayField.setText("");
        }
        else if (source == equalsButton){
            num2 = Double.parseDouble(displayField.getText());
            switch (operation) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break; 
                case "%":
                    result = num1 / 100;
            }
            displayField.setText(String.valueOf(result));
        } else if (source == deleteButton) {
            String currentText = displayField.getText();
            if (!currentText.isEmpty()) {
                displayField.setText(currentText.substring(0, currentText.length() - 1));
            }
        } else {
            for (int i = 0; i < 10; i++) {
                if (source == numButtons[i]) {
                    displayField.setText(displayField.getText() + i);
                    return;
                }
            }
            for (int i = 0; i < 5; i++) {
                if (source == operationButtons[i]) {
                    num1 = Double.parseDouble(displayField.getText());
                    operation = operationButtons[i].getText();
                    displayField.setText("");
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        CalculatorJava calculator = new CalculatorJava();
    }
}
