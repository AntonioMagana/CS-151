package simstation;
/*
March 30, 2020 -> Added by Christian Miller
 */
import mvc.*;

public class StopCommand extends Command {

    public StopCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() {
        Simulation sim = (Simulation)model;
        sim.stop();
    }
}
