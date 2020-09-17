package sims.pdtourney;
/*
 * Edit history:
 *   Magana, 4/11: created
 */

import simstation.*;

public class PrisonerPanel extends SimulationPanel {

    public PrisonerPanel(SimulationFactory factory) {
        super(factory);
    }

    public static void main(String[] args){
        PrisonerFactory factory = new PrisonerFactory();
        SimulationPanel panel  = new SimulationPanel(factory);
        panel.display();
    }
}
