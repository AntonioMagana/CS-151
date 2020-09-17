package simstation;
/*
March 30, 2020 -> Added by Christian Miller
 */
import mvc.*;

public class StartCommand extends Command {

    public StartCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() {
        ((Simulation)model).start();

    }
}
