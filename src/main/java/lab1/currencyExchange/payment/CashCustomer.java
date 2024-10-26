package lab1.currencyExchange.payment;

import lab1.currencyExchange.invoice.Invoice;

public class CashCustomer extends Customer {
    String idnp;

    public CashCustomer(String name, String idnp) {
        super(name);
        this.idnp = idnp;
    }

    public CashPayment createPayment(Invoice invoice) {
        return new CashPayment(this.name, this.idnp, invoice);
    }
}
