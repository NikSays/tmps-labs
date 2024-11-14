package lab2.currencyExchange.payment;

import lab2.logging.Logger;

public class LoggedPayment implements Payment {
    private final Logger logger;
    private final Payment payment;

    public LoggedPayment(Logger logger, Payment payment) {
        this.logger = logger;
        this.payment = payment;
    }

    @Override
    public void execute() {
        this.logger.log("Preparing to execute payment");
        this.payment.execute();
        this.logger.log("Executed payment");
    }
}
