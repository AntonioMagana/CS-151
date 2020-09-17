package simstation;
/*
April 1, 2020 -> Added move method, start, resume, stop, and suspend - Christian Miller

April 4, 2020 -> Added run method. Fixed a bug in move method, added helper functions to make world "circular".
              -> Added random heading, distance method, and abstract update method. - Christian Miller

April 6, 2020 -> Changed heading and Simulation from private to protected. - Christian Miller

April 7 -> Cleaned up and organized variables and methods. Removed unnecessary methods, Antonio

 */
import mvc.Utilities;

import java.io.Serializable;
import java.util.Random;


public abstract class Agent implements Serializable, Runnable{

    protected Heading heading;
    protected Simulation simulation;
    private String name;
    private int xCoordinate;
    private int yCoordinate;
    private AgentState state;
    private boolean finished;
    private Thread thread;

    public static Integer WORLD_SIZE = 300;

    public Agent(Simulation simulation) {
        this.simulation = simulation;
        finished = false;
        xCoordinate = Utilities.rng.nextInt(Simulation.SIZE);
        yCoordinate = Utilities.rng.nextInt(Simulation.SIZE);
        this.heading = randomHeading();
        this.state = null;
        thread = new Thread();
    }

    @Override
    public void run() {
        thread = Thread.currentThread();
        while (!finished) {
            state = AgentState.RUNNING;
            update();
            simulation.changed();
            try {
                Thread.sleep(100);
                synchronized (this) {
                    while (state == AgentState.SUSPENDED) {
                        wait();
                    }
                }
            }   catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void move(int steps){
            if (heading == Heading.NORTH) {
                yCoordinate = yCoordinate - steps;
            }
            else if (heading == Heading.EAST) {
                xCoordinate = xCoordinate + steps;
            }
            else if (heading == Heading.SOUTH) {
                yCoordinate = yCoordinate + steps;
            }
            else if (heading == Heading.WEST) {
                xCoordinate = xCoordinate - steps;
            }
            if(outOfBounds()){
                handleOutOfBounds();
            }
    }

    public boolean outOfBounds(){
        if(xCoordinate > WORLD_SIZE + SimulationView.X_COORDINATE){
            return true;
        }
        else if(xCoordinate < SimulationView.X_COORDINATE){
            return true;
        }
        else if(yCoordinate > WORLD_SIZE + SimulationView.Y_COORDINATE){
            return true;
        }
        else if(yCoordinate < SimulationView.Y_COORDINATE)
            return true;
        return false;
    }

    public void handleOutOfBounds(){
        if(xCoordinate > WORLD_SIZE + SimulationView.X_COORDINATE ){
            xCoordinate = xCoordinate - WORLD_SIZE;
        }
        else if(xCoordinate < SimulationView.X_COORDINATE){
            xCoordinate = xCoordinate + WORLD_SIZE;
        }
        else if(yCoordinate > WORLD_SIZE + SimulationView.Y_COORDINATE){
            yCoordinate = yCoordinate - WORLD_SIZE;
        }
        else if(yCoordinate < SimulationView.Y_COORDINATE ){
            yCoordinate = yCoordinate + WORLD_SIZE;
        }
    }

    synchronized public void start(){
        state = AgentState.READY;
        thread = new Thread(this);
        thread.start();

    }

    synchronized public void suspend(){
        state = AgentState.SUSPENDED;

    }

    synchronized public void resume(){
        if(state != AgentState.STOPPED){
            state = AgentState.READY;
            notify();
        }
    }

    synchronized public void stop(){
        state = AgentState.STOPPED;
        finished = true;

    }

    public int getXCoordinate(){
        return xCoordinate;
    }

    public int getYCoordinate(){
        return yCoordinate;
    }




    public Heading randomHeading(){
        int direction = Utilities.rng.nextInt(4);
        if(direction == 0)
            return Heading.NORTH;
        else if(direction == 1)
            return Heading.EAST;
        else if(direction == 2)
            return Heading.SOUTH;
        else if(direction == 3)
            return Heading.WEST;
        return null;
    }

    public AgentState getState() {
        return state;
    }

    public double distance(Agent a){
        return Math.sqrt(Math.pow(this.xCoordinate - a.getXCoordinate(),2) + Math.pow(this.yCoordinate - a.getYCoordinate(), 2));
    }

    public abstract void update();
}
