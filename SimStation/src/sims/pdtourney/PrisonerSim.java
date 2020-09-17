package sims.pdtourney;

/*
 * Edit history:
 *   Magana, 4/11: created
 *   Magana, 4/12: Used enum strategy
 *   Magana, 4/13: changed to dedicated strategy design pattern
 *
 */

import simstation.*;

public class PrisonerSim extends Simulation{

    public PrisonerSim(){
        super();
    }

    public void populate(){
        super.populate();
        Prisoner p;
        for(int i = 0; i < 100; i++){
            p = new Prisoner(this);
            switch(i % 4){
                case 0: p.setStrat(new AlwaysCheats(p));break;
                case 1: p.setStrat(new AlwaysCoop(p));break;
                case 2: p.setStrat(new AlwaysRandom(p));break;
                case 3: p.setStrat(new RepeatLast(p));break;
            }
            agents.add(p);
        }
    }

    public String[] getStats(){
        double cheatF = 0;
        double coopF = 0;
        double randF = 0;
        double repF = 0;

        for(Agent a : agents){
            Prisoner p = (Prisoner)a;
            switch(p.getStrat().getFlag()){
                case 0: cheatF += p.getFitness(); break;
                case 1: coopF += p.getFitness(); break;
                case 2: randF += p.getFitness(); break;
                case 3: repF += p.getFitness(); break;
            }
        }

        cheatF = cheatF/25;
        coopF = coopF/25;
        randF = randF/25;
        repF = repF/25;

        String[] stats = new String[6];
        stats[0] = "clock = " + clock;
        stats[1] = "Average Scores Per Type";
        stats[2] = "Always Cheat = " + cheatF;
        stats[3] = "Always Cooperate = " + coopF;
        stats[4] = "Always Random = " + randF;
        stats[5] = "Repeat Last = " + repF;
        return stats;
    }
}
