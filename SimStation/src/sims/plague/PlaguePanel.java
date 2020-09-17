package sims.plague;
import simstation.*;
/*
 * Edit history:
 *   Magana, 4/9: created
 */

public class PlaguePanel extends SimulationPanel {

    public PlaguePanel(SimFactory factory) {
        super(factory);
    }

    public static void main(String[] args) {
        SimFactory factory = new PlagueFactory();
        SimulationPanel panel = new SimulationPanel(factory);
        panel.display();
    }

}
