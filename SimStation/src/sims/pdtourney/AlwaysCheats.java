package sims.pdtourney;

/*
 * Edit history:
 *   Magana, 4/13: created
 */

public class AlwaysCheats extends Strategy{

    public AlwaysCheats(Prisoner p) {
        super(p);
        this.flag = 0;
    }

    public void theStrategy() {
        this.cheats = true;
    }
}
