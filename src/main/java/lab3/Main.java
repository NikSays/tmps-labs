package lab3;

import lab3.exchangeCLI.ExchangeCLI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ExchangeCLI exchangeCLI = new ExchangeCLI(scanner);
        exchangeCLI.run();
    }
}
