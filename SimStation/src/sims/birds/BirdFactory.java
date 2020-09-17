package sims.birds;
/*
April 11, 2020 -> Added by Christian Miller
 */
import mvc.Model;
import simstation.SimulationFactory;


public class BirdFactory extends SimulationFactory {

    public BirdFactory() {
        super();
    }

    @Override
    public Model makeModel() {
        return new BirdSim();
    }


}
