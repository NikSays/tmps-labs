package lab3.exchangeCLI;

public interface CLIState {
    void setContext(ExchangeCLI cli);

    void runDialog() throws Exception;
}
