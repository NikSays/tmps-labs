package lab3.currencyExchange.payment;

import lab3.currencyExchange.invoice.Invoice;

public abstract class Customer {
    protected final String name;

    public Customer(String name) {
        this.name = name;
    }

    abstract public Payment createPayment(Invoice invoice);
}
