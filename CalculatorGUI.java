package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI {

    private final CalculatorService calculatorService;
    private JTextField input1;
    private JTextField input2;
    private JTextField resultField;

    public CalculatorGUI() {
        calculatorService = new CalculatorService();
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Simple Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLayout(new GridLayout(5, 2));

        input1 = new JTextField();
        input2 = new JTextField();
        resultField = new JTextField();
        resultField.setEditable(false);

        JButton addButton = new JButton("Add");
        JButton subtractButton = new JButton("Subtract");
        JButton multiplyButton = new JButton("Multiply");
        JButton divideButton = new JButton("Divide");

        addButton.addActionListener(new OperationAction("add"));
        subtractButton.addActionListener(new OperationAction("subtract"));
        multiplyButton.addActionListener(new OperationAction("multiply"));
        divideButton.addActionListener(new OperationAction("divide"));

        frame.add(new JLabel("First Number:"));
        frame.add(input1);
        frame.add(new JLabel("Second Number:"));
        frame.add(input2);
        frame.add(new JLabel("Result:"));
        frame.add(resultField);
        frame.add(addButton);
        frame.add(subtractButton);
        frame.add(multiplyButton);
        frame.add(divideButton);

        frame.setVisible(true);
    }

    private class OperationAction implements ActionListener {
        private final String operation;

        public OperationAction(String operation) {
            this.operation = operation;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double num1 = Double.parseDouble(input1.getText());
                double num2 = Double.parseDouble(input2.getText());
                double result;

                switch (operation) {
                    case "add":
                        result = calculatorService.add(num1, num2);
                        break;
                    case "subtract":
                        result = calculatorService.subtract(num1, num2);
                        break;
                    case "multiply":
                        result = calculatorService.multiply(num1, num2);
                        break;
                    case "divide":
                        result = calculatorService.divide(num1, num2);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operation");
                }

                resultField.setText(String.valueOf(result));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter valid numbers.");
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }
}

