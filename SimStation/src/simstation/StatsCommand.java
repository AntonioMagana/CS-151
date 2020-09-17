package simstation;
/*
March 30, 2020 -> Added by Christian Miller
 */
import mvc.*;

public class StatsCommand extends Command {

    public StatsCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() {
        Simulation sim = (Simulation)model;
        Utilities.inform(sim.getStats());
    }
}
