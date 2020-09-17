package simstation;
/*
March 30, 2020 -> Added by Christian Miller
 */
import mvc.*;

public class SimulationFactory implements SimFactory {

    @Override
    public Model makeModel() {
        return new Simulation();
    }

    @Override
    public String[] getEditCommands() {

        return new String[] {"Start", "Suspend", "Resume", "Stop", "Stats"};
    }

    @Override
    public Command makeEditCommand(Model model, String type) {
        if (type == "Start")
            return new StartCommand(model);
        else if(type == "Suspend")
            return new SuspendCommand(model);
        else if(type == "Resume")
            return new ResumeCommand(model);
        else if(type == "Stop")
            return new StopCommand(model);
        else if(type == "Stats")
            return new StatsCommand(model);
        return null;
    }

    @Override
    public String getTitle() {
        return "Sim Station";
    }

    @Override
    public String[] getHelp() {
        return new String[] {"Click buttons"}; }

    @Override
    public String about() {
        return "Sim Station";
    }

    @Override
    public View getView(Model model) {
        return new SimulationView(model);
    }
}
