package sims.plague;

import simstation.*;
import mvc.*;
/*
 * Edit history:
 *   Magana, 4/9: created
 *   Magana, 4/10: updated to include new view
 *
 */

public class PlagueFactory extends SimulationFactory {


    public PlagueFactory() {
        super();
    }

    @Override
    public Model makeModel() {
        return new PlagueSim();
    }

    @Override
    public View getView(Model model){
        return new PlagueView(model);
    }

}
