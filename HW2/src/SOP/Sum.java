package SOP;

public class Sum implements Expression {
    private Expression[] array;

    public Sum(Expression ... x){
        this.array = x;
    }

    @Override
    public Double execute() {
        double ans = this.array[0].execute();

        for(int i=1; i<this.array.length; i++){
            ans = ans + this.array[i].execute();
        }
        return (double) Math.round(ans * 100) / 100;
    }
}
