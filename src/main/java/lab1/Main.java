package lab1;

import lab1.exchangeCLI.ExchangeCLI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ExchangeCLI exchangeCLI = new ExchangeCLI(scanner);
        exchangeCLI.run();
    }
}
