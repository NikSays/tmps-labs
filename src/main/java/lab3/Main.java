package lab3;

import lab3.exchangeCLI.ExchangeCLI;
import lab3.exchangeCLI.states.initialState;
import lab3.logging.EverywhereLogger;
import lab3.logging.Logger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Logger logger = new EverywhereLogger("./log.txt", "https://postman-echo.com/post");

        ExchangeCLI exchangeCLI = new ExchangeCLI(scanner, logger);
        exchangeCLI.setState(new initialState());
        exchangeCLI.run();
    }
}
