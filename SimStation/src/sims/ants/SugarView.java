package sims.ants;

import mvc.*;
import simstation.*;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class SugarView extends SimulationView {
    public static final Integer X_COORDINATE = 10;
    public static final Integer Y_COORDINATE = 10;
    public static final Integer SIZE = 300;


    public SugarView(Model model) {
        super(model);
    }


    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Color oldColor = g2.getColor();

        g2.setStroke(new BasicStroke(3));
        g2.draw(new Rectangle2D.Double(X_COORDINATE, Y_COORDINATE, SIZE, SIZE));
        g2.setColor(Color.RED);

        SugarScape sim = (SugarScape) model;
        ArrayList<Agent> agents = sim.getAgents();

        for(Agent a : agents){
            Ant h = (Ant)a;
            g2.setColor(Color.RED);
            g2.fillOval(h.getXCoordinate(), h.getYCoordinate(),h.getSize(),h.getSize());
        }
        for(Point p: sim.getSugarPods()) {
            g2.setColor(Color.BLACK);
            g2.fillOval(p.getXc(), p.getYc(), 2, 2);
        }
        g2.setColor(oldColor);

    }
}

