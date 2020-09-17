package sims.pdtourney;

/*
 * Edit history:
 *   Magana, 4/11: created
 *   Magana, 4/12: Used enum strategy
 *   Magana, 4/13: changed to dedicated strategy design pattern
 *
 */

import mvc.Utilities;
import simstation.*;

public class Prisoner extends Agent {
    private int fitness;
    private int speed;
    public final int MAX_SPEED = 10;
    private boolean cheated;
    private Strategy strat;

    public Prisoner(Simulation sim) {
        super(sim);
        this.fitness = 0;
        this.cheated = false;
        this.strat = null;
        this.speed = Utilities.rng.nextInt(MAX_SPEED) +1;
    }

    /*public boolean strategy(){
        if(this.strat == Strategy.ALWAYS_CHEAT){
            return true; //Cheats
        }
        else if(this.strat == Strategy.ALWAYS_COOP){
            return false; // Cooperates
        }
        else if(this.strat == Strategy.ALWAYS_RANDOM){
            int temp = Utilities.rng.nextInt(2);
            if(temp == 0){
                return true; //Cheats
            }
            else{
                return false; //Cooperates
            }
        }
        else if(this.strat == Strategy.ALWAYS_REPEAT){
            if(wasCheated){ //If it was cheated against last time
                return false; //Cheats
            }
            else{
                return true; //cooperates
            }
        }
        return false;
    }*/

    public int getFitness(){
        return this.fitness;
    }

    public boolean wasCheated() { return this.cheated; }

    public Strategy getStrat() { return this.strat; }
    public void setStrat(Strategy strat) { this.strat = strat; }


    @Override
    public void update() {
        Prisoner neighbor = (Prisoner)simulation.getNeighbor(this, 20);
        if(neighbor != null) {
            if (this.strat.getCheats() && neighbor.strat.getCheats()) { //if "this" cheats and "neighbor" cheats
                this.fitness += 1;
                neighbor.fitness += 1;
            }
            else if (this.strat.getCheats() && !neighbor.strat.getCheats()) { //if "this" cheats and "neighbor" cooperates
                this.fitness += 5;
                //neighbor.fitness += 0; //"Loser" fitness remains the same
            }
            else if (!this.strat.getCheats() && neighbor.strat.getCheats()) { //if "this" cooperates and "neighbor" cheats
                //this.fitness += 0;    //"Loser" fitness remains the same
                neighbor.fitness += 5;
            }
            else {  //"this" cooperates and "neighbor" cooperates
                this.fitness += 3;
                neighbor.fitness += 3;
            }
        }

        move(speed);
        heading = randomHeading();
        simulation.changed();
    }
}
