package sims.drunks;
/*
April 7, 2020 -> Added by Christian Miller
 */
import simstation.Simulation;

public class DrunkSim extends Simulation {

    public static final int POPULATION_SIZE = 50;

    @Override
    public void populate() {
        for(int i = 0; i < POPULATION_SIZE; i++){
            agents.add(new Drunks(this));
        }
    }

}
