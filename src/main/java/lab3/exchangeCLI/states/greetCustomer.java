package lab3.exchangeCLI.states;

import lab3.currencyExchange.payment.CardCustomer;
import lab3.currencyExchange.payment.CashCustomer;
import lab3.currencyExchange.payment.Customer;
import lab3.exchangeCLI.CLIState;
import lab3.exchangeCLI.ExchangeCLI;

public class greetCustomer implements CLIState {
    private ExchangeCLI context;

    public void setContext(ExchangeCLI cli) {
        this.context = cli;
    }

    public void runDialog() throws Exception {
        Customer customer;

        System.out.println("\nNext customer, please!");
        System.out.println("Hello, what is your name?");
        System.out.print("Enter name: ");
        String name = this.context.getScanner().nextLine();
        String paymentTypeChoice = this.getPaymentType();

        switch (paymentTypeChoice) {
            case "s":
                System.out.println("\nAnd what's your IDNP?");
                System.out.print("Enter IDNP: ");
                String idnp = this.context.getScanner().nextLine();
                customer = new CashCustomer(name, idnp);
                break;
            case "r":
                System.out.println("\nAnd what's your card number?");
                System.out.print("Enter card number: ");
                String card = this.context.getScanner().nextLine();
                customer = new CardCustomer(name, card);
                break;
            default:
                throw new Exception("Invalid payment type returned");
        }

        this.context.setCustomer(customer);
        this.context.setState(new handleCustomer());
    }

    private String getPaymentType() {
        while (true) {
            System.out.println("\nHow will you be paying today?");
            System.out.println("""
                    s -- caSh
                    r -- caRd""");
            System.out.print("Enter command: ");
            String b = this.context.getScanner().nextLine();
            switch (b) {
                case "s", "r":
                    return b;
                default:
                    System.out.println("Error: Invalid command");
                    break;
            }
        }
    }
}
