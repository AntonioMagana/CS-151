package sims.birds;

/*
April 11, 2020 -> Added by Christian Miller
 */
import simstation.*;


public class BirdSim extends Simulation {
    public static final int POPULATION_SIZE = 50;

    @Override
    public void populate() {
        for(int i = 0; i < POPULATION_SIZE; i++){
            agents.add(new Bird(this));
        }
    }


}
