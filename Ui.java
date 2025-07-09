import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.*;

public class Ui extends JFrame {
    private JTextField display = new JTextField();
    private String currentInput = "";
    private double firstNumber = 0;
    private String operator = "";
    private Logic logic = new Logic();

    public Ui(){
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(5, 4, 5, 5));
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C", "sqrt", "^", "%"
        };

        for (String text : buttons){
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(e -> buttonPressed(text));
            buttonPanel.add(button);
            
        }

        add(buttonPanel, BorderLayout.CENTER);
        setVisible(true);
        
    }

    private void buttonPressed(String text) {
        switch(text) {
            case "C":
            currentInput = "";
            firstNumber = 0;
            operator = "";
            display.setText("");
            break;
            case "+":
            case "-":
            case "*":
            case "/":
            case "^":
            case "%":
            if (!currentInput.isEmpty()) {
                firstNumber = Double.parseDouble(currentInput);
                operator = text;
                currentInput = "";
            }
            break;
            case "=":
            if (!currentInput.isEmpty() && !operator.isEmpty()) {
                double secondNumber = Double.parseDouble(currentInput);
                double result = 0;
                try {
                    switch (operator) {
                        case "+":
                            result = logic.add(firstNumber, secondNumber);
                            break;
                        case "-":
                            result = logic.subtract(firstNumber, secondNumber);
                            break;
                        case "*":
                            result = logic.multiply(firstNumber, secondNumber);
                            break;
                        case "/":
                            result = logic.divide(firstNumber, secondNumber);
                            break;
                        case "^":
                            result = logic.power(firstNumber, secondNumber);
                            break;
                        case "%":
                            result = logic.percentage(firstNumber, secondNumber);
                            break;
                    }
                    display.setText(""+result);
                    currentInput = "" + result;
                    operator = "";
                } catch (IllegalArgumentException e) {
                    display.setText("Error: " + e.getMessage());
                    currentInput = "";
                    operator = "";
                }
            }
            break;
            case "sqrt":
            if (!currentInput.isEmpty()) {
                try {
                    double val = Double.parseDouble(currentInput);
                    double result = logic.squareRoot(val);
                    display.setText("" + result);
                    currentInput = "" + result;
                } catch (IllegalArgumentException e) {
                    display.setText("Error: " + e.getMessage());
                    currentInput = "";
                }
            }
            break;
            default:
            currentInput += text;
            display.setText(currentInput);
            break;
        }
    }

}