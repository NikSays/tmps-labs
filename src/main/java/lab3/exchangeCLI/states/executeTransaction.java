package lab3.exchangeCLI.states;

import lab3.currencyExchange.exchangeRate.Currency;
import lab3.currencyExchange.invoice.Invoice;
import lab3.currencyExchange.payment.LoggedPayment;
import lab3.exchangeCLI.CLIState;
import lab3.exchangeCLI.ExchangeCLI;

import java.util.InputMismatchException;

public class executeTransaction implements CLIState {
    private ExchangeCLI context;

    public void setContext(ExchangeCLI cli) {
        this.context = cli;
    }

    public void runDialog() {
        System.out.println("\nFrom which currency?");
        Currency origin = this.getCurrency();

        System.out.println("\nHow much?");
        float amount = this.getAmount();

        System.out.println("\nTo which currency");
        Currency target = this.getCurrency();

        Invoice invoice = this.context.getInvoiceBuilder().
                reset().
                setAmount(amount).
                setOriginCurrency(origin).
                setTargetCurrency(target).
                setTax(this.context.getTax()).
                getResult();

        System.out.println();
        LoggedPayment payment = new LoggedPayment(
                this.context.getLogger(),
                this.context.getCustomer().createPayment(invoice)
        );
        payment.execute();

        this.context.setState(new handleCustomer());
    }

    private Currency getCurrency() {
        while (true) {
            System.out.println("Available currencies: MDL, EUR, USD");
            System.out.print("Enter currency: ");
            String currency = this.context.getScanner().nextLine();
            switch (currency) {
                case "MDL":
                    return Currency.MDL;
                case "EUR":
                    return Currency.EUR;
                case "USD":
                    return Currency.USD;
                default:
                    System.out.println("Error: Invalid currency");
                    break;
            }
        }
    }

    private float getAmount() {
        while (true) {
            System.out.print("Input the amount: ");
            float amount;
            try {
                amount = this.context.getScanner().nextFloat();
            } catch (InputMismatchException e) {
                System.out.println("Error: Not a float");
                continue;
            } finally {
                this.context.getScanner().nextLine();
            }
            if (amount < 0) {
                System.out.println("Error: Amount must be greater than 0");
                continue;
            }
            return amount;
        }
    }
}
