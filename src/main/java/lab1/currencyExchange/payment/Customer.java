package lab1.currencyExchange.payment;

import lab1.currencyExchange.invoice.Invoice;

public abstract class Customer {
    protected String name;

    public Customer(String name) {
        this.name = name;
    }

    abstract public Payment createPayment(Invoice invoice);
}
