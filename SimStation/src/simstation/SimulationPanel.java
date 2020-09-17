package simstation;
/*
March 30, 2020 -> Added by Christian Miller
 */
import mvc.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SimulationPanel extends AppPanel implements ActionListener {

    private JButton startButton, suspendButton, resumeButton, stopButton, statsButton;

    public SimulationPanel(SimFactory factory) {
        super(factory);
        View view = factory.getView(model);
        this.setLayout(new GridLayout(1,2));
        //this.setLayout(new BorderLayout());


        //Make buttons
        startButton = new JButton("Start");
        suspendButton = new JButton("Suspend");
        resumeButton = new JButton("Resume");
        stopButton = new JButton("Stop");
        statsButton = new JButton("Stats");


        // Listen to Buttons
        startButton.addActionListener(this);
        suspendButton.addActionListener(this);
        resumeButton.addActionListener(this);
        stopButton.addActionListener(this);
        statsButton.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5,1));

        JPanel buttonFormat = new JPanel();
        buttonFormat.setLayout(new BorderLayout());

        add(buttonFormat, "West");
        buttonPanel.setVisible(true);
        add(view, "East");


        JPanel p = new JPanel();
        p.add(startButton);
        buttonPanel.add(p);

        p = new JPanel();
        p.add(suspendButton);
        buttonPanel.add(p);

        p = new JPanel();
        p.add(resumeButton);
        buttonPanel.add(p);

        p = new JPanel();
        p.add(stopButton);
        buttonPanel.add(p);

        p = new JPanel();
        p.add(statsButton);
        buttonPanel.add(p);

        buttonFormat.add(buttonPanel, "North");


    }




}