import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[14];
    JButton addButton, subButton, divButton, mulButton;
    JButton clrButton, delButton, equButton, decButton, negButton, sqrtButton, percButton;
    JButton memStoreButton, memRecallButton, historyButton;
    JPanel panel, topPanel;
    double memory = 0;
    ArrayList<String> history = new ArrayList<>();

    Font myFont = new Font("Ink Free", Font.BOLD, 24);
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 700);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50, 25, 400, 60);
        textfield.setFont(myFont);
        textfield.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        clrButton = new JButton("CLR");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        negButton = new JButton("(-)");
        sqrtButton = new JButton("√");
        percButton = new JButton("%");
        memStoreButton = new JButton("M+");
        memRecallButton = new JButton("MR");
        historyButton = new JButton("Hist");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;
        functionButtons[9] = sqrtButton;
        functionButtons[10] = percButton;
        functionButtons[11] = memStoreButton;
        functionButtons[12] = memRecallButton;
        functionButtons[13] = historyButton;

        for (int i = 0; i < 14; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        topPanel = new JPanel();
        topPanel.setBounds(50, 100, 400, 50);
        topPanel.setLayout(new GridLayout(1, 3, 10, 10));
        topPanel.add(memStoreButton);
        topPanel.add(memRecallButton);
        topPanel.add(historyButton);
        frame.add(topPanel);

        panel = new JPanel();
        panel.setBounds(50, 180, 400, 400);
        panel.setLayout(new GridLayout(5, 4, 10, 10));
        
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);
        
        panel.add(sqrtButton);
        panel.add(percButton);
        panel.add(negButton);
        panel.add(clrButton);

        frame.add(panel);
        frame.add(textfield);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            textfield.setText(textfield.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textfield.getText());

            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/': result = num1 / num2; break;
            }
            textfield.setText(String.valueOf(result));
            num1 = result;
            history.add(num1 + " " + operator + " " + num2 + " = " + result);
        }
        if (e.getSource() == clrButton) textfield.setText("");
        if (e.getSource() == delButton) textfield.setText(textfield.getText().substring(0, textfield.getText().length() - 1));
        if (e.getSource() == negButton) textfield.setText(String.valueOf(-Double.parseDouble(textfield.getText())));
        if (e.getSource() == sqrtButton) textfield.setText(String.valueOf(Math.sqrt(Double.parseDouble(textfield.getText()))));
        if (e.getSource() == percButton) textfield.setText(String.valueOf(Double.parseDouble(textfield.getText()) / 100));
        if (e.getSource() == memStoreButton) memory = Double.parseDouble(textfield.getText());
        if (e.getSource() == memRecallButton) textfield.setText(String.valueOf(memory));
        if (e.getSource() == historyButton) JOptionPane.showMessageDialog(null, String.join("\n", history), "History", JOptionPane.INFORMATION_MESSAGE);
    }
}
