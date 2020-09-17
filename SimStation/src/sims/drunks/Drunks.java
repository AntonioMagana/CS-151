package sims.drunks;
/*
April 7, 2020 -> Added by Christian Miller

April 8, 2020 -> Fixed bug where some drunks had no speed. - Christian Miller

 */
import mvc.*;
import simstation.*;

public class Drunks extends Agent {
    private int speed;
    public final int MAX_SPEED = 10;

    public Drunks(Simulation simulation) {
        super(simulation);
        this.heading = randomHeading();
        this.speed = Utilities.rng.nextInt(MAX_SPEED) +1;
    }

    @Override
    public void update() {
        heading = randomHeading();
        move(speed);
        simulation.changed();

    }
}
