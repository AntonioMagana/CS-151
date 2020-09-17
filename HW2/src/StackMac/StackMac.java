package StackMac;

import java.util.*;

public class StackMac {
    public static Stack<Double> stack = new Stack<Double>();

    public static void execute(Program p) {
        try {
            stack.clear();
            p.execute();
            System.out.println(stack.toString());
        } catch (DivByZeroException e) {
            System.err.println(e);
        } catch (ShortStackException e) {
            System.err.println(e);
        } catch (EmptyStackException e) {
            System.err.println(e);
        } catch (StackMachineException e) {
            System.err.println(e);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            System.out.println(stack);
        }
    }
}
