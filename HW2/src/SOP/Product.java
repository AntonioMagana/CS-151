package SOP;

public class Product implements Expression{
    private Expression[] array;

    public Product(Expression ... x) {
        this.array = x;
    }

    @Override
    public Double execute() {
        double result = this.array[0].execute();

        for(int i = 1; i < array.length; i++) {
            result *= this.array[i].execute();
        }
        return result;
    }
}
