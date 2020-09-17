package Money;

public interface CurrencyConverter {
    public static CurrencyConverter calculator = new MockConverter(); // mock converter uses 2/18 rates
    public double exchangeRate(Currency from, Currency to);
}
