package Money;

import java.util.HashMap;
import java.util.Map;

public class MockConverter implements CurrencyConverter {
    private Map<Currency, Double> eRate;

    public MockConverter() {
        eRate = new HashMap<>();

        eRate.put(Currency.EUR, 1.085);
        eRate.put(Currency.USD, 1.000);
        eRate.put(Currency.JPY, 0.009);
        eRate.put(Currency.MXP, 0.053);
        eRate.put(Currency.INR, 0.014);
    }

    @Override
    public double exchangeRate(Currency from, Currency to){
        return eRate.get(from) / eRate.get(to);
    }
}
