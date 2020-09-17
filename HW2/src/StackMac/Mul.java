package StackMac;

public class Mul extends StackMac implements Command{

    public Mul() {

    };

    @Override
    public void execute() throws ShortStackException {
        if(stack.size() < 2){
            throw new ShortStackException("Stack has too few elements");
        }

        double val1 = stack.pop();
        double val2 = stack.pop();

        stack.push(val1*val2);
    }
}

