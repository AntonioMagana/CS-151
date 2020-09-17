package Money;

import java.io.Serializable;

public class Money extends MockConverter implements Serializable, Comparable<Money> {
    double amt;
    Currency cur;

    public Money(double amt, Currency cur){
        this.amt = amt;
        this.cur = cur;
    }

    double getAmount() {
        return this.amt;
    }

    double add(Money m){
        if(this.cur == m.cur){
            return this.getAmount() + m.getAmount();
        }
        else{
            return this.getAmount() + m.getAmount()*exchangeRate(m.cur, this.cur);
        }
    }

    @Override
    public int compareTo(Money m) {
        double amount = m.getAmount();
        if (this.cur.equals(m.cur)) {
            return Double.compare(this.getAmount(), m.getAmount());
        }
        return Double.compare(this.amt * exchangeRate(this.cur, m.cur), m.amt * exchangeRate(m.cur, this.cur));
    }

    public String toString(){
        return this.getAmount() + " " + this.cur;
    }
}