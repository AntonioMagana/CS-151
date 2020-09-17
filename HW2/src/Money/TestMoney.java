package Money;

import java.util.*;

public class TestMoney {

    public static void main(String[] args) {
        Money m1 = new Money(3.25, Currency.USD);
        Money m2 = new Money(5.0, Currency.EUR);
        Money m3 = new Money(129.0, Currency.MXP);
        Money m4 = new Money(200.0, Currency.INR);
        Money m5 = new Money(100.0, Currency.JPY);

        List<Money> deposits = new ArrayList<Money>();
        deposits.add(m1);
        deposits.add(m2);
        deposits.add(m3);
        deposits.add(m4);
        deposits.add(m5);

        System.out.println("deposits = " + deposits);
        deposits.sort(null);
        System.out.println("deposits = " + deposits);

        System.out.println("m2 + m3 = " + m2.add(m3));

        System.out.println("m2 + m4 = " + m2.add(m4));

        System.out.println("m2 + m5 = " + m2.add(m5));

        System.out.println("m2 + m1 = " + m2.add(m1));


    }

}