package lab3.exchangeCLI.states;

import lab3.exchangeCLI.CLIState;
import lab3.exchangeCLI.ExchangeCLI;

public class handleCustomer implements CLIState {
    private ExchangeCLI context;

    public void setContext(ExchangeCLI cli) {
        this.context = cli;
    }

    public void runDialog() {
        System.out.println("\nWhat will the customer do?");
        System.out.println("""
                e -- exchange money
                l -- leave""");
        System.out.print("Enter command: ");
        String b = this.context.getScanner().nextLine();
        switch (b) {
            case "e":
                this.context.setState(new executeTransaction());
                return;
            case "l":
                System.out.println("Goodbye!");
                this.context.setState(new initialState());
                return;
            default:
                System.out.println("Error: Invalid command");
        }
    }
}
