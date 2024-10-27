package lab1.currencyExchange.invoice;

import lab1.currencyExchange.exchangeRate.Currency;
import lab1.currencyExchange.exchangeRate.RateService;

public class Invoice {
    float originalAmount;
    Currency originCurrency;
    Currency targetCurrency;
    int tax;

    public Invoice() {
    }

    public float getOriginalAmount() {
        return this.originalAmount;
    }

    public Currency getOriginCurrency() {
        return this.originCurrency;
    }

    public Currency getTargetCurrency() {
        return this.targetCurrency;
    }

    public int getTax() {
        return this.tax;
    }

    public float getExchangedAmount() {
        float originRate = RateService.getInstance().getRate(this.originCurrency);
        float targetRate = RateService.getInstance().getRate(this.targetCurrency);
        float afterTax = (100F - (float) this.tax) / 100F;
        return this.originalAmount * (originRate / targetRate) * afterTax;
    }
}
