package lab0;

import lab0.encryption.DummyCipher;
import lab0.encryption.EncryptionMethod;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EncryptionMethod cipher;

        cipher = new DummyCipher();

        ToDoList toDoList = new ToDoList();
        CLI cli = new CLI(toDoList, cipher, scanner);
        cli.start();

        scanner.close();
    }
}