package SOP;

public class TestSOP {
    public static void main(String[] args) {
        Processor proc = new Processor();
        Expression e1 = new Number(2.0);
        Expression e2 = new Number(3.1);
        Expression e3 = new Number(-5.0);
        Sum s1 = new Sum(e1, e2, e3);
        System.out.println("s1 - " + proc.execute(s1));
        Product p1 = new Product(s1, e3);
        System.out.println("p1 - " + proc.execute(p1));
        // etc.
    }
}


