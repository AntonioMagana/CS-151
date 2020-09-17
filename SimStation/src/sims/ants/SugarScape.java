package sims.ants;

import simstation.*;
import java.awt.*;
import java.util.*;
import mvc.*;

public class SugarScape extends Simulation {

    private Set<Point> sugarPods;
    public static int numPods = 100;
    public static int numAnts = 50;

    public SugarScape() {
        super();
        sugarPods = new HashSet<Point>();
        for(int i = 0; i < numPods; i++) {
            int xc = mvc.Utilities.rng.nextInt(SIZE);
            int yc = mvc.Utilities.rng.nextInt(SIZE);
            Point p = new Point(xc, yc);
            sugarPods.add(p);
        }

    }

    // delegators:
    public boolean contains(Point pod) { return sugarPods.contains(pod); }
    public boolean remove(Point pod) { return sugarPods.remove(pod); }
    public Iterator<Point> podIterator() { return sugarPods.iterator(); }
    public Set<Point> getSugarPods(){return sugarPods;}

    public void populate() {
        for(int i = 0; i < numAnts; i++) {
            agents.add(new Ant(this));
        }
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new SugarScapeFactory());
        panel.display();
    }
}