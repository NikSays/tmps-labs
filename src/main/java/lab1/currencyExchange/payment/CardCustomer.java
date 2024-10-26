package lab1.currencyExchange.payment;

import lab1.currencyExchange.invoice.Invoice;

public class CardCustomer extends Customer {
    String cardNumber;

    public CardCustomer(String name, String cardNumber) {
        super(name);
        this.cardNumber = cardNumber;
    }

    public CardPayment createPayment(Invoice invoice) {
        return new CardPayment(this.name, this.cardNumber, invoice);
    }
}
