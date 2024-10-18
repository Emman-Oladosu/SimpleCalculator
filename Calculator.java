package Calculator;

import javax.swing.SwingUtilities;

public class Calculator {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorGUI ui = new CalculatorGUI();
            ui.createAndShowGUI();
        });
    }
}
