package lab3.currencyExchange.payment;

import lab3.logging.Logger;

public class LoggedPayment implements Payment {
    private final Logger logger;
    private final Payment payment;

    public LoggedPayment(Logger logger, Payment payment) {
        this.logger = logger;
        this.payment = payment;
    }

    public void execute() {
        this.logger.log("Preparing to execute payment");
        this.payment.execute();
        this.logger.log("Executed payment");
    }
}
