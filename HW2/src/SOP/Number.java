package SOP;

public class Number implements Expression{
    private double num;

    public Number(double number){
        this.num = number;
    }

    @Override
    public Double execute() {
        return num;
    }
}
