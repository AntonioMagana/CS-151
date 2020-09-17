package simstation;
/*
March 30, 2020 -> Added by Christian Miller
 */
import mvc.*;

public class SuspendCommand extends Command{

    public SuspendCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() {
        ((Simulation)model).suspend();
    }
}
