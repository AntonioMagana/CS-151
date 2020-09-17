package simstation;
/*
April 6, 2020 -> Added by Christian Miller
April 8 -> Bugfix for paintComponent method, Antonio
 */
import mvc.*;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class SimulationView extends View {

    public static final Integer X_COORDINATE = 10;
    public static final Integer Y_COORDINATE = 10;

    public SimulationView(Model model) {
        super(model);
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        Color oldColor = g2.getColor();

        Simulation sim = (Simulation) model;
        ArrayList<Agent> agents = sim.getAgents();
        g2.setColor(Color.RED);

        for(int i = 0; i < agents.size(); i++){
            g2.fillOval(agents.get(i).getXCoordinate(),agents.get(i).getYCoordinate(), 4,4);
        }

        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(3));
        g2.draw(new Rectangle2D.Double(X_COORDINATE, Y_COORDINATE, Simulation.SIZE + 2, Simulation.SIZE + 2));
        g2.setColor(oldColor);

    }
}



