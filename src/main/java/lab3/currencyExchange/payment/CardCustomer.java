package lab3.currencyExchange.payment;

import lab3.currencyExchange.invoice.Invoice;

public class CardCustomer extends Customer {
    final String cardNumber;

    public CardCustomer(String name, String cardNumber) {
        super(name);
        this.cardNumber = cardNumber;
    }

    public CardPayment createPayment(Invoice invoice) {
        return new CardPayment(this.name, this.cardNumber, invoice);
    }
}
