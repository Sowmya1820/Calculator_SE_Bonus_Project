import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CalculatorUI implements ActionListener {

    JFrame frame;
    JTextField textField;
    JPanel panel;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[12];
    JButton addButton, subButton, mulButton, divButton, modButton;
    JButton decButton, equButton, clrButton, delButton, negButton, sqrtButton, logButton;

    boolean isResultDisplayed = false; // Flag to track if the result is displayed

    CalculatorUI() {
        // Create the frame
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 550);
        frame.setLayout(null);

        // Create and configure the text field
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setEditable(false);
        textField.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(textField);

        // Initialize function buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        modButton = new JButton("%");
        decButton = new JButton(".");
        equButton = new JButton("=");
        clrButton = new JButton("C");
        delButton = new JButton("AC");
        negButton = new JButton("+/-");
        sqrtButton = new JButton("√");
        logButton = new JButton("log");

        // Add all function buttons to the array
        functionButtons = new JButton[]{
            addButton, subButton, mulButton, divButton, modButton,
            decButton, equButton, clrButton, delButton, negButton, sqrtButton, logButton
        };

        // Configure function buttons
        for (JButton button : functionButtons) {
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(this);
        }

        // Initialize number buttons
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.BOLD, 18));
            numberButtons[i].addActionListener(this);
        }

        // Configure panel
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 400);
        panel.setLayout(new GridLayout(5, 4, 10, 10));

        // Add number buttons and function buttons to the panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(subButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(mulButton);
        panel.add(divButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(modButton);
        panel.add(equButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(clrButton);
        panel.add(delButton);
        panel.add(negButton);
        panel.add(sqrtButton);
        panel.add(logButton);

        // Add panel to the frame
        frame.add(panel);

        // Make the frame visible
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                if (isResultDisplayed) {
                    textField.setText(""); // Clear screen if a result was displayed
                    isResultDisplayed = false;
                }
                if (textField.getText().length() < 8) { // Limit to 8 digits
                    textField.setText(textField.getText() + i);
                }
            }
        }

        if (e.getSource() == decButton) {
            if (isResultDisplayed) {
                textField.setText(""); // Clear screen if a result was displayed
                isResultDisplayed = false;
            }
            if (!textField.getText().contains(".")) {
                textField.setText(textField.getText() + ".");
            }
        }
    }

    public static void main(String[] args) {
        new CalculatorUI();
    }
}
