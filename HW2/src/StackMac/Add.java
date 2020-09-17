package StackMac;

public class Add extends StackMac implements Command {

    public Add() { }

    @Override
    public void execute() throws ShortStackException {
        if(stack.size() < 2){
            throw new ShortStackException("The stack has too few elements");
        }
        double val1 = stack.pop();
        double val2 = stack.pop();

        stack.push(val1 + val2);
    }
}
