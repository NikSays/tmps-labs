package lab2.currencyExchange.invoice;

import lab2.currencyExchange.exchangeRate.Currency;

public interface Builder {
    Builder reset();

    Builder setAmount(float amount);

    Builder setOriginCurrency(Currency currency);

    Builder setTargetCurrency(Currency currency);

    Builder setTax(int percent);
}
