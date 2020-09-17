package sims.pdtourney;

/*
 * Edit history:
 *   Magana, 4/14: created
 */

abstract class Strategy {
    protected Prisoner pris;
    protected boolean cheats;
    protected int flag;

    public Strategy(Prisoner p){
        this.pris  = p;
        this.theStrategy();
    }

    public boolean getCheats(){ return this.cheats;}
    public int getFlag(){ return this.flag; }

    public abstract void theStrategy();
}
