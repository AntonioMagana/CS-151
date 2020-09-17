package sims.pdtourney;

/*
 * Edit history:
 *   Magana, 4/11: created
 */

import simstation.*;
import mvc.*;

public class PrisonerFactory extends SimulationFactory {
    public PrisonerFactory(){
        super();
    }

    @Override
    public Model makeModel() {
        return new PrisonerSim();
    }
}
