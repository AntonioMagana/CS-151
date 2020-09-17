package sims.plague;

import mvc.Model;
import mvc.View;
import simstation.Agent;
import simstation.Simulation;
import simstation.SimulationView;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
/*
 * Edit history:
 *   Magana, 4/9: created
 *   Miller, 4/10: bugfix on specific colors
 *
 */

public class PlagueView extends SimulationView {
    public static final Integer X_COORDINATE = 10;
    public static final Integer Y_COORDINATE = 10;
    public static final Integer SIZE = 300;


    public PlagueView(Model model) {
        super(model);
    }


    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Color oldColor = g2.getColor();

        g2.setStroke(new BasicStroke(3));
        g2.draw(new Rectangle2D.Double(X_COORDINATE, Y_COORDINATE, SIZE, SIZE));
        g2.setColor(Color.RED);


        PlagueSim sim = (PlagueSim) model;
        ArrayList<Agent> agents = sim.getAgents();

        for(Agent a : agents){
            Host h = (Host)a;
            if(h.isInfected()){
                g2.setColor(Color.RED);
                g2.fillOval(h.getXCoordinate(), h.getYCoordinate(),4,4);
            }
            else{
                g2.setColor(Color.GREEN);
                g2.fillOval(h.getXCoordinate(), h.getYCoordinate(), 4,4);
            }
        }
        g2.setColor(oldColor);

    }
}
