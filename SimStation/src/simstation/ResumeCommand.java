package simstation;
/*
March 30, 2020 -> Added by Christian Miller
 */
import mvc.*;

public class ResumeCommand extends Command {

    public ResumeCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() {
        ((Simulation)model).resume();

    }
}
