package lab2.currencyExchange.payment;

import lab2.currencyExchange.invoice.Invoice;

public class CashPayment implements Payment {
    final String customerName;
    final String customerIDNP;
    final Invoice invoice;

    protected CashPayment(String name, String idnp, Invoice invoice) {
        this.customerName = name;
        this.customerIDNP = idnp;
        this.invoice = invoice;
    }

    public void execute() {
        System.out.printf("""
                        Executed exchange:
                          for customer %s (IDNP: %s)
                          from %f %s supplied as cash
                          to %f %s
                          with %d%% tax
                        """,
                this.customerName, this.customerIDNP,
                this.invoice.getOriginalAmount(), this.invoice.getOriginCurrency(),
                this.invoice.getExchangedAmount(), this.invoice.getTargetCurrency(),
                this.invoice.getTax());
    }
}
