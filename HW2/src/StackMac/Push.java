package StackMac;

public class Push<T> extends StackMac implements Command {
    private T val;

    public Push(T x){
        this.val = x;
    }

    @Override
    public void execute() {
        stack.push((Double) val); //not sure why, but its forcing me to cast as a double
    }
}
