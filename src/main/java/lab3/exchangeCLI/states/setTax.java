package lab3.exchangeCLI.states;

import lab3.exchangeCLI.CLIState;
import lab3.exchangeCLI.ExchangeCLI;

import java.util.InputMismatchException;

public class setTax implements CLIState {
    private ExchangeCLI context;

    public void setContext(ExchangeCLI cli) {
        this.context = cli;
    }

    public void runDialog() {
        System.out.print("\nInput new tax value: ");
        int tax;
        try {
            tax = this.context.getScanner().nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error: Not an integer");
            return;
        } finally {
            this.context.getScanner().nextLine();
        }
        if (tax < 0 || tax > 100) {
            System.out.println("Error: Tax must be between 0% and 100%");
            return;
        }
        this.context.setTax(tax);
        this.context.setState(new initialState());
    }
}
