package lab3.currencyExchange.exchangeRate;

import java.util.HashMap;

public class RateService {
    private static RateService instance;

    private final HashMap<Currency, Float> rates;

    private RateService() {
        this.rates = new HashMap<>();
        this.rates.put(Currency.MDL, 1F);
    }

    public static RateService getInstance() {
        if (instance == null) {
            instance = new RateService();
        }
        return instance;
    }

    public float getRate(Currency currency) {
        return this.rates.get(currency);
    }

    public void setRate(Currency currency, float rate) {
        if (currency == Currency.MDL) {
            throw new IllegalArgumentException("Currency exchange rate for MDL cannot be set");
        }
        if (rate <= 0) {
            throw new IllegalArgumentException("Currency exchange rate must be higher than 0");
        }
        this.rates.put(currency, rate);
    }
}
