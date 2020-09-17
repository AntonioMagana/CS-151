package sims.birds;
/*
April 11, 2020 -> Added by Christian Miller
 */

import simstation.*;

public class BirdPanel extends SimulationPanel {

    public BirdPanel(SimulationFactory factory) {
        super(factory);
    }

    public static void main(String[] args) {
        BirdFactory factory = new BirdFactory();
        SimulationPanel panel = new SimulationPanel(factory);
        panel.display();
    }


}
