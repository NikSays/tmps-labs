package lab3.exchangeCLI.states;

import lab3.currencyExchange.exchangeRate.Currency;
import lab3.currencyExchange.exchangeRate.RateService;
import lab3.exchangeCLI.CLIState;
import lab3.exchangeCLI.ExchangeCLI;

import java.util.InputMismatchException;

public class setRates implements CLIState {
    private ExchangeCLI context;

    public void setContext(ExchangeCLI cli) {
        this.context = cli;
    }

    public void runDialog() {
        System.out.print("\nInput new rate for EUR: ");
        this.currencyRate(Currency.EUR);

        System.out.print("\nInput new rate for USD: ");
        this.currencyRate(Currency.USD);

        this.context.setState(new initialState());
    }

    private void currencyRate(Currency currency) {
        try {
            RateService.getInstance().setRate(currency, this.context.getScanner().nextFloat());
        } catch (InputMismatchException e) {
            System.out.println("Error: Not a float");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        } finally {
            this.context.getScanner().nextLine();
        }
    }
}
