package sims.pdtourney;

/*
 * Edit history:
 *   Magana, 4/13: created
 */

public class RepeatLast extends Strategy{

    public RepeatLast(Prisoner p) {
        super(p);
        this.flag  = 3;
    }

    @Override
    public void theStrategy() {
        if(pris.wasCheated()){ //If it was cheated against last time
            this.cheats = true; //Cheats
        }
        else{
            this.cheats = false; //cooperates
        }
    }
}
