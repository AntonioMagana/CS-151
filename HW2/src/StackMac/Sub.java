package StackMac;

public class Sub extends StackMac implements Command{

    public Sub(){
    }

    @Override
    public void execute() throws ShortStackException {
        if(stack.size() < 2){
            throw new ShortStackException("There are too few elements in the stack");
        }
        double val1 = stack.pop();
        double val2 = stack.pop();

        stack.push(val1-val2);
    }
}
