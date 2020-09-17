package graphics;

public class Calculator {
    private Double result = 0.0;
    public Double getResult() { return result; }
    public void add(Double amt) { result += amt; }
    public void sub(Double amt) { result -= amt; }
    public void mul(Double amt) { result *= amt; }
    public void div(Double amt) { result /= amt; }
    public void clear() { result = 0.0; }

}