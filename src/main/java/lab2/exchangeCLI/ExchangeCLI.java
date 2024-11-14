package lab2.exchangeCLI;

import lab2.currencyExchange.exchangeRate.Currency;
import lab2.currencyExchange.exchangeRate.RateService;
import lab2.currencyExchange.invoice.Invoice;
import lab2.currencyExchange.invoice.InvoiceBuilder;
import lab2.currencyExchange.payment.CardCustomer;
import lab2.currencyExchange.payment.CashCustomer;
import lab2.currencyExchange.payment.Customer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExchangeCLI {
    final private Scanner scanner;
    private final InvoiceBuilder invoiceBuilder;
    private int tax = 0;


    public ExchangeCLI(Scanner scanner) {
        this.scanner = scanner;
        this.invoiceBuilder = new InvoiceBuilder();
    }

    public void run() throws Exception {
        this.changeRates();

        while (true) {
            System.out.println("\nWhat will the teller do?");
            System.out.println("""                   
                    n -- Next customer
                    r -- set exchange Rates
                    t -- set exchange Tax
                    c -- Close""");
            System.out.print("Enter command: ");
            String b = this.scanner.nextLine();
            switch (b) {
                case "n":
                    this.greetCustomer();
                    break;
                case "r":
                    this.changeRates();
                    break;
                case "t":
                    this.changeTax();
                    break;
                case "c":
                    return;
                default:
                    System.out.println("Error: Invalid command");
                    break;
            }
        }
    }

    private void changeRates() {
        while (true) {
            System.out.print("\nInput new rate for EUR: ");
            float eur;
            try {
                eur = this.scanner.nextFloat();
                RateService.getInstance().setRate(Currency.EUR, eur);
            } catch (InputMismatchException e) {
                System.out.println("Error: Not a float");
                continue;
            } catch (IllegalArgumentException e) {
                System.out.println(e);
                continue;
            } finally {
                this.scanner.nextLine();
            }
            break;
        }
        while (true) {
            System.out.print("\nInput new rate for USD: ");
            float usd;
            try {
                usd = this.scanner.nextFloat();
                RateService.getInstance().setRate(Currency.USD, usd);
            } catch (InputMismatchException e) {
                System.out.println("Error: Not a float");
                continue;
            } catch (IllegalArgumentException e) {
                System.out.println(e);
                continue;
            } finally {
                this.scanner.nextLine();
            }
            break;
        }
    }

    private void changeTax() {
        while (true) {
            System.out.print("\nInput new tax value: ");
            int tax;
            try {
                tax = this.scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Not an integer");
                continue;
            } finally {
                this.scanner.nextLine();
            }
            if (tax < 0 || tax > 100) {
                System.out.println("Error: Tax must be between 0% and 100%");
                continue;
            }
            this.tax = tax;
            break;
        }
    }

    private void greetCustomer() throws Exception {
        Customer customer;

        System.out.println("\nNext customer, please!");
        System.out.println("Hello, what is your name?");
        System.out.print("Enter name: ");
        String name = this.scanner.nextLine();
        String paymentTypeChoice = this.getPaymentType();

        switch (paymentTypeChoice) {
            case "s":
                System.out.println("\nAnd what's your IDNP?");
                System.out.print("Enter IDNP: ");
                String idnp = this.scanner.nextLine();
                customer = new CashCustomer(name, idnp);
                break;
            case "r":
                System.out.println("\nAnd what's your card number?");
                System.out.print("Enter card number: ");
                String card = this.scanner.nextLine();
                customer = new CardCustomer(name, card);
                break;
            default:
                throw new Exception("Invalid payment type returned");
        }

        this.handleCustomer(customer);
    }

    private String getPaymentType() {
        while (true) {
            System.out.println("\nHow will you be paying today?");
            System.out.println("""
                    s -- caSh
                    r -- caRd""");
            System.out.print("Enter command: ");
            String b = this.scanner.nextLine();
            switch (b) {
                case "s", "r":
                    return b;
                default:
                    System.out.println("Error: Invalid command");
                    break;
            }
        }
    }

    private void handleCustomer(Customer customer) {
        while (true) {
            System.out.println("\nWhat will the customer do?");
            System.out.println("""
                    e -- exchange money
                    l -- leave""");
            System.out.print("Enter command: ");
            String b = this.scanner.nextLine();
            switch (b) {
                case "e":
                    this.exchange(customer);
                    break;
                case "l":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Error: Invalid command");
                    break;
            }
        }
    }

    private void exchange(Customer customer) {
        System.out.println("\nFrom which currency?");
        Currency origin = this.getCurrency();

        System.out.println("\nHow much?");
        float amount = this.getAmount();

        System.out.println("\nTo which currency");
        Currency target = this.getCurrency();

        Invoice invoice = this.invoiceBuilder.
                reset().
                setAmount(amount).
                setOriginCurrency(origin).
                setTargetCurrency(target).
                setTax(this.tax).
                getResult();

        System.out.println();
        customer.createPayment(invoice).execute();
    }

    private Currency getCurrency() {
        while (true) {
            System.out.println("Available currencies: MDL, EUR, USD");
            System.out.print("Enter currency: ");
            String currency = this.scanner.nextLine();
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
                amount = this.scanner.nextFloat();
            } catch (InputMismatchException e) {
                System.out.println("Error: Not a float");
                continue;
            } finally {
                this.scanner.nextLine();
            }
            if (amount < 0) {
                System.out.println("Error: Amount must be greater than 0");
                continue;
            }
            return amount;
        }
    }
}
