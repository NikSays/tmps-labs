package lab1.paymentSystem.ledger;

import java.util.ArrayList;

public class Ledger {
    private static Ledger instance;

    private ArrayList<Float> invoices;

    private Ledger() {
        this.invoices = new ArrayList<>();
    }

    public static Ledger getInstance() {
        if (instance == null) {
            instance = new Ledger();
        }
        return instance;
    }

}
