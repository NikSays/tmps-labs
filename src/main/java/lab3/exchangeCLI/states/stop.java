package lab3.exchangeCLI.states;

import lab3.exchangeCLI.CLIState;
import lab3.exchangeCLI.ExchangeCLI;

public class stop implements CLIState {
    public void setContext(ExchangeCLI cli) {
        cli.stop();
    }

    public void runDialog() {
        System.out.println("Goodbye");
    }
}
