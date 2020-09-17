package sims.birds;
/*
April 11, 2020 -> Added by Christian Miller
April 13 -> Cleaned up extra variables, Antonio
 */
import mvc.Utilities;
import simstation.Agent;
import simstation.*;



public class Bird extends Agent {
    private int speed;
    public final int MAX_SPEED = 10;
    public final int RADIUS = 40;

    public Bird(Simulation simulation) {
        super(simulation);
        this.heading = randomHeading();
        this.speed = Utilities.rng.nextInt(MAX_SPEED) +1;
    }


    public void update() {
        Bird neighbor = (Bird)simulation.getNeighbor(this, RADIUS);
        if(neighbor != null) {
            speed = neighbor.getSpeed();
            heading =  neighbor.getHeading();
        }
        move(speed);
        simulation.changed();
    }

    public int getSpeed() {
        return speed;
    }
    public Heading getHeading() { return heading;}
}
