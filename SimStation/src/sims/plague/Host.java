package sims.plague;

import simstation.*;

/*
 * Edit history:
 *   Magana, 4/9: created
 *   Miller, 4/12: Changed update method
 *
 */

public class Host extends Agent{

    private boolean infected;
    private boolean resistant;
    private int speed;
    private int radius = 3;

    public Host(Simulation sim){
        super(sim);
        int luck = mvc.Utilities.rng.nextInt(100);
        this.resistant = luck < PlagueSim.RESISTANCE;
        this.speed = mvc.Utilities.rng.nextInt(10) + 1;
        infect();
    }

    public void infect(){
        if(!resistant){
            int luck = mvc.Utilities.rng.nextInt(100);
            this.infected = (luck < PlagueSim.VIRULENCE);
        }
    }

    @Override
    public void update() {
        Host neighbor = (Host)simulation.getNeighbor(this, radius);
        if(neighbor != null) {
            if (this.isInfected() && !neighbor.isResistant()) {
                neighbor.infected = true;
            } else if (!this.isResistant() && neighbor.isInfected()) {
                this.infected = true;
            }
        }

        move(speed);
        heading = randomHeading();
        simulation.changed();

    }


    public boolean isInfected() {
        return infected;
    }

    public boolean isResistant() {
        return resistant;
    }
}
