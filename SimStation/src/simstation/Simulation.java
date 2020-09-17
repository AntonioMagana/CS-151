package simstation;

/*
March 30, 2020 -> Added timer methods, start, stop, suspend, get stats and resume methods - Christian Miller
April 3 -> Bugfixes on Clock method, Antonio

 */
import mvc.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class Simulation extends Model  {

    protected int clock;
    private Timer timer;
    protected ArrayList<Agent> agents;
    protected Thread thread;
    protected static final int SIZE = 300;


    public Simulation() {
        this.agents = new ArrayList<>();
        thread = new Thread();
        clock = 0;
        timer = new Timer();
    }


    private void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);
    }

    private void stopTimer() {
        timer.cancel();
        timer.purge();
    }

    private class ClockUpdater extends TimerTask {
        public void run() {
            clock++;
            //changed();
        }
    }


    public void start() {
        agents.clear();
        populate();
        startTimer();
        for(Agent a : agents){
            a.start();
        }

        changed();
    }

    public void stop() {
        stopTimer();
        for(Agent a : agents) {
            a.stop();
        }
        changed();
    }

    public void suspend() {
        if(agents.get(0).getState() == AgentState.STOPPED)
            return;
        stopTimer();
        for(Agent a : agents){
            a.suspend();
        }
    }

    public synchronized void resume() {
        if(agents.get(0).getState() == AgentState.SUSPENDED) {
            startTimer();
            for (Agent a : agents) {
                a.resume();
            }
        }

    }


    public String[] getStats() {
        String[] stats = new String[2];
        stats[0] = "#agents = " + agents.size();
        stats[1] = "clock = " + clock;
        return stats;
    }


    public synchronized Agent getNeighbor(Agent asker, double radius) {
        Agent neighbor = null;
        boolean found = false;
        int i = Utilities.rng.nextInt(agents.size());
        int start = i;
        while(!found) {
            Agent candidate = agents.get(i);
            if(candidate != asker && asker.distance(candidate) < radius) {
                neighbor = agents.get(i);
                found = true;
            } else {
                i = (i + 1) % agents.size();
                if(i == start) break;
            }
        }
        return neighbor;
    }


    public ArrayList<Agent> getAgents(){
        return agents;
    }


    public int getClock() {
        return clock;
    }

    public void update(){

    }

    public void populate(){

    }

}



