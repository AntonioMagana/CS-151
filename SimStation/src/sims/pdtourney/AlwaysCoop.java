package sims.pdtourney;

/*
 * Edit history:
 *   Magana, 4/13: created
 */

public class AlwaysCoop extends Strategy {

    public AlwaysCoop(Prisoner p) {
        super(p);
        this.flag  = 1;
    }

    @Override
    public void theStrategy() {
        this.cheats = false;
    }
}
