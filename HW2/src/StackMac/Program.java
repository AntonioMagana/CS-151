package StackMac;

import java.util.ArrayList;

public class Program{
    private ArrayList<Command> aList;

    public Program() {
        aList = new ArrayList<>();
    }

    void add(Command com){
        aList.add(com);
    }

    public void execute() throws Exception {
        for(int i = 0; i < aList.size(); i++){
            aList.get(i).execute();
        }
    }
}
