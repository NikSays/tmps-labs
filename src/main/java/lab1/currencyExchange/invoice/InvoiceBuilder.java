package lab1.currencyExchange.invoice;

import lab1.currencyExchange.exchangeRate.Currency;

public class InvoiceBuilder implements Builder {
    private Invoice invoice;

    public InvoiceBuilder() {
        this.reset();
    }

    public InvoiceBuilder reset() {
        this.invoice = new Invoice();
        this.invoice.tax = 0;
        return this;
    }

    public InvoiceBuilder setAmount(float amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be bigger than 0");
        }
        this.invoice.originalAmount = amount;
        return this;
    }

    public InvoiceBuilder setOriginCurrency(Currency currency) {
        this.invoice.originCurrency = currency;
        return this;
    }

    public InvoiceBuilder setTargetCurrency(Currency currency) {
        this.invoice.targetCurrency = currency;
        return this;
    }

    public Builder setTax(int percent) {
        if (percent < 0 || percent > 100) {
            throw new IllegalArgumentException("Tax must be between 0% and 100%");
        }
        return this;
    }

    public Invoice getResult() {
        if (this.invoice.originalAmount <= 0) {
            throw new IllegalArgumentException("Amount must be bigger than 0");
        }
        if (this.invoice.originCurrency == null) {
            throw new IllegalArgumentException("Origin currency not set");
        }
        if (this.invoice.targetCurrency == null) {
            throw new IllegalArgumentException("Origin currency not set");
        }
        return this.invoice;
    }
}
