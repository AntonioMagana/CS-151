package StackMac;

import java.util.EmptyStackException;

public class Div extends StackMac implements Command {

    public Div(){ }

    @Override
    public void execute() throws DivByZeroException, ShortStackException, EmptyStackException {
        if(stack.isEmpty()) {
            throw new EmptyStackException();
        }
        else if(stack.size() < 2) {
            throw new ShortStackException("There are not enough elements in the stack to perform the operation");
        }
        else if(stack.top() == 0){
            throw new DivByZeroException("Dividing by 0 is not permitted");
        }
        double val1 = stack.pop();
        double val2 = stack.pop();

        stack.push(val2/val1);
    }
}
