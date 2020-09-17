package sims.ants;

import mvc.*;
import simstation.*;

public class SugarScapeFactory extends SimulationFactory {

    public SugarScapeFactory() {
        super();
    }

    @Override
    public Model makeModel() {
        return new SugarScape();
    }

    @Override
    public View getView(Model model){
        return new SugarView(model);
    }
}
