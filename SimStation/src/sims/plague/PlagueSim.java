package sims.plague;

import simstation.*;
/*
 * Edit history:
 *   Magana, 4/9: created
 *   Miller, 4/10: Changed getStats method
 *   Magana, 4/11: added Population_Size variable
 *
 */

public class PlagueSim extends Simulation {
    public static int VIRULENCE = 50; // % chance of infection
    public static int RESISTANCE = 2; // % chance of resisting infection
    public static int POPULATION_SIZE = 50;

    public PlagueSim(){
        super();
    }

    public void populate()
    {
        for(int i = 0; i < POPULATION_SIZE; i++){
            agents.add(new Host(this));
        }
    }

    public String[] getStats(){
        double count = 0;
        for(Agent a : agents){
            Host h = (Host)a;
            if(h.isInfected()){
                count++;
            }
        }
        String[] stats = new String[3];
        stats[0] = "#agents = " + agents.size();
        stats[1] = "clock = " + clock;
        stats[2] = "Percent of infected: " + Math.round(count/POPULATION_SIZE * 100);
        return stats;
    }
}
