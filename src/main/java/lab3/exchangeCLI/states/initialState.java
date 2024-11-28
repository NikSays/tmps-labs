package lab3.exchangeCLI.states;

import lab3.exchangeCLI.CLIState;
import lab3.exchangeCLI.ExchangeCLI;

public class initialState implements CLIState {
    private ExchangeCLI context;

    public void setContext(ExchangeCLI cli) {
        this.context = cli;
    }

    public void runDialog() {
        System.out.println("\nWhat will the teller do?");
        System.out.println("""
                n -- Next customer
                r -- set exchange Rates
                t -- set exchange Tax
                c -- Close""");
        System.out.print("Enter command: ");
        String b = this.context.getScanner().nextLine();
        switch (b) {
            case "n":
                this.context.setState(new greetCustomer());
                break;
            case "r":
                this.context.setState(new setRates());
                break;
            case "t":
                this.context.setState(new setTax());
                break;
            case "c":
                this.context.setState(new stop());
                return;
            default:
                System.out.println("Error: Invalid command");
                break;
        }
    }
}
