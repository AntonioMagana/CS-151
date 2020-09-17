package sims.drunks;

import simstation.SimulationFactory;
import simstation.SimulationPanel;
/*
April 7, 2020 -> Added by Christian Miller

 */
public class DrunkPanel extends SimulationPanel {
    public DrunkPanel(SimulationFactory factory) {
        super(factory);
    }

    public static void main(String[] args) {
        DrunkFactory factory = new DrunkFactory();
        SimulationPanel panel = new SimulationPanel(factory);
        panel.display();
    }
}
