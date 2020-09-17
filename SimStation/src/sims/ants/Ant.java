package sims.ants;

import mvc.*;
import simstation.*;

public class Ant extends Agent {

    private int fitness;
    SugarScape sim = (SugarScape) simulation;

    public Ant(Simulation sim){
        super(sim);
        fitness = 1;
    }

    synchronized public void consume(){
        this.fitness++;
    }

    public int getSize(){
        return this.fitness;
    }

    @Override
    public void update() {
        Point p  = new Point(this.getXCoordinate(),this.getYCoordinate());
        if(sim.contains(p)){
            this.consume();
            sim.remove(p);
        }

        move(fitness);
        heading = randomHeading();
        simulation.changed();

    }
}
