package StackMac;

public class StackMacTests {
    // example: f() = 5x^2 - 3
    public static void test0(Double x) {
        // create an empty program
        Program p = new Program();
        // add commands to p:
        p.add(new Push(3.0));
        p.add(new Push(x));
        p.add(new Push(x));
        p.add(new Push(5.0));
        p.add(new Mul());
        p.add(new Mul());
        p.add(new Sub());
        // now execute
        StackMac.execute(p);
    }

    // f(x) = x^3 + 3x^2 - 2x + 1
    public static void test1(Double x) {
        Program p = new Program();

        p.add(new Push(1.0));
        p.add(new Push(x));
        p.add(new Push(2.0));
        p.add(new Mul());
        p.add(new Push(x));
        p.add(new Push(x));
        p.add(new Push(3.0));
        p.add(new Mul());
        p.add(new Mul());
        p.add(new Push(x));
        p.add(new Push(x));
        p.add(new Push(x));
        p.add(new Mul());
        p.add(new Mul());
        p.add(new Add());
        p.add(new Sub());
        p.add(new Add());

        StackMac.execute(p);
    }

    public static void main(String[] args) {
        test1(2.0); // [17.0]
        test1(5.0); // [191.0]

        test0(2.0); // [17.0]
        test0(4.0); // [77]
    }

}