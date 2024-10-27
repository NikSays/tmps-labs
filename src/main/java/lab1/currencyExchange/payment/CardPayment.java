package lab1.currencyExchange.payment;

import lab1.currencyExchange.invoice.Invoice;

public class CardPayment implements Payment {
    final String customerName;
    final String customerCardNumber;
    final Invoice invoice;

    protected CardPayment(String name, String cardNumber, Invoice invoice) {
        this.customerName = name;
        this.customerCardNumber = cardNumber;
        this.invoice = invoice;
    }

    public void execute() {
        System.out.printf("""
                        Executed exchange:
                          for customer %s
                          from %f %s supplied by card %s
                          to %f %s
                          with %d%% tax
                        """,
                this.customerName,
                this.invoice.getOriginalAmount(), this.invoice.getOriginCurrency(), this.customerCardNumber,
                this.invoice.getExchangedAmount(), this.invoice.getTargetCurrency(),
                this.invoice.getTax());
    }
}
