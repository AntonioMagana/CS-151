package sims.pdtourney;

/*
 * Edit history:
 *   Magana, 4/13: created
 */

import mvc.*;

public class AlwaysRandom extends Strategy {
    int rand;

    public AlwaysRandom(Prisoner p) {
        super(p);
        this.flag = 2;
    }

    @Override
    public void theStrategy() {
        rand = Utilities.rng.nextInt(2);
        if(rand == 0){
            this.cheats = true; //Cheats
        }
        else{
            this.cheats = false; //Cooperates
        }
    }
}
