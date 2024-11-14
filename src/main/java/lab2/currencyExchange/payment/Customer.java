package lab2.currencyExchange.payment;

import lab2.currencyExchange.invoice.Invoice;

public abstract class Customer {
    protected final String name;

    public Customer(String name) {
        this.name = name;
    }

    abstract public Payment createPayment(Invoice invoice);
}
