package sims.drunks;

import simstation.SimulationFactory;
import mvc.*;

/*
April 7, 2020 -> Added by Christian Miller
April 11, 2020 -> Fixed bug where the agents were not showing up due to not having the right view being passed - Christian Miller

 */
public class DrunkFactory extends SimulationFactory {
    public DrunkFactory() {
        super();
    }

    @Override
    public Model makeModel() {
        return new DrunkSim();
    }

}
