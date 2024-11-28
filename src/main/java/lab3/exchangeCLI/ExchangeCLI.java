package lab3.exchangeCLI;

import lab3.currencyExchange.invoice.InvoiceBuilder;
import lab3.currencyExchange.payment.Customer;
import lab3.logging.Logger;

import java.util.Scanner;

public class ExchangeCLI {
    private final Logger logger;
    private final Scanner scanner;
    private CLIState state;
    private final InvoiceBuilder invoiceBuilder;
    private boolean stop = false;
    private int tax;
    private Customer customer;

    public ExchangeCLI(Scanner scanner, Logger logger) {
        this.scanner = scanner;
        this.invoiceBuilder = new InvoiceBuilder();
        this.logger = logger;
    }

    public int getTax() {
        return this.tax;
    }

    public void setTax(int tax) {
        if (tax < 0 || tax > 100) return;
        this.tax = tax;
    }

    public Scanner getScanner() {
        return this.scanner;
    }

    public InvoiceBuilder getInvoiceBuilder() {
        return this.invoiceBuilder;
    }

    public Logger getLogger() {
        return this.logger;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void stop() {
        this.stop = true;
    }

    public void setState(CLIState state) {
        state.setContext(this);
        this.state = state;
    }

    public void run() throws Exception {
        if (this.state == null) {
            throw new Exception("State is not initialized");
        }
        while (!this.stop) {
            this.state.runDialog();
        }
    }
}
