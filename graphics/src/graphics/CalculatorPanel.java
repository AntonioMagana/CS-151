package graphics;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CalculatorPanel extends JPanel implements ActionListener {

    private Calculator calculator;
    private JButton addButton, mulButton, subButton, divButton, clearButton;
    private JTextField display;

    public CalculatorPanel() {
        // make calculator
        calculator = new Calculator();
        // make buttons and display
        addButton = new JButton("Add");
        mulButton = new JButton("Mul");
        subButton = new JButton("Sub");
        divButton = new JButton("Div");
        clearButton = new JButton("Clear");
        display = new JTextField(calculator.getResult().toString(), 10);
        // listen to buttons
        addButton.addActionListener(this);
        mulButton.addActionListener(this);
        subButton.addActionListener(this);
        divButton.addActionListener(this);
        clearButton.addActionListener(this);

        //initPanel1();
        //initPanel2();
        //initPanel3();
        //initPanel4();
        initPanel5();

    }

    private void initPanel1() {
        add(display);
        add(addButton);
        add(mulButton);
        add(subButton);
        add(divButton);
        add(clearButton);

    }
    private void initPanel2() {
        this.setLayout(new BorderLayout());
        add(display, "North");
        add(addButton, "East");
        add(mulButton, "Center"); // not enough room!
        add(subButton, "Center");
        add(divButton, "West");
        add(clearButton, "South");

    }

    private void initPanel3() {
        this.setLayout(new GridLayout(2, 6));
        add(display);
        add(addButton);
        add(mulButton);
        add(subButton);
        add(divButton);
        add(clearButton);
    }

    private void initPanel4() {
        this.setLayout(new BorderLayout());

        JPanel displayPanel = new JPanel();
        displayPanel.add(display);
        this.add(displayPanel, "North");

        JPanel mathPanel = new JPanel();
        mathPanel.setLayout(new GridLayout(2, 2));
        mathPanel.add(addButton);
        mathPanel.add(mulButton); // not enough room!
        mathPanel.add(subButton);
        mathPanel.add(divButton);
        this.add(mathPanel, "Center");

        this.add(clearButton, "South");
    }

    private void initPanel5() {
        this.setLayout(new BorderLayout());

        JPanel displayPanel = new JPanel();
        displayPanel.add(display);
        this.add(displayPanel, "North");

        JPanel mathPanel = new JPanel();
        mathPanel.setLayout(new GridLayout(2, 2));

        JPanel p = new JPanel();
        p.add(addButton);
        mathPanel.add(p);

        p = new JPanel();
        p.add(mulButton);
        mathPanel.add(p);

        p = new JPanel();
        p.add(subButton);
        mathPanel.add(p);

        p = new JPanel();
        p.add(divButton);
        mathPanel.add(p);

        this.add(mathPanel, "Center");

        p = new JPanel();
        p.add(clearButton);
        this.add(p, "South");
    }

    public void display() {
        JFrame frame = new JFrame();
        Container cp = frame.getContentPane();
        cp.add(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Calculator");
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String cmmd = ae.getActionCommand();
        try {
            Double arg = Double.valueOf(display.getText());
            if (cmmd == "Add") calculator.add(arg);
            else if (cmmd == "Mul") calculator.mul(arg);
            else if (cmmd == "Sub") calculator.sub(arg);
            else if (cmmd == "Div") calculator.div(arg);
            else if (cmmd == "Clear") calculator.clear();
            display.setText(calculator.getResult().toString());
        } catch(NumberFormatException gripe) {
            JOptionPane.showMessageDialog(null,
                    gripe.getMessage(),
                    "OOPS!",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        CalculatorPanel panel = new CalculatorPanel();
        panel.display();
    }

}