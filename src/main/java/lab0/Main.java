package lab0;

import lab0.encryption.CaesarCipher;
import lab0.encryption.DummyCipher;
import lab0.encryption.EncryptionMethod;
import lab0.encryption.MonoalphabeticCipher;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose encryption method:\n  0) No encryption\n  1) Monoalphabetic Substitution\n  2) Caesar Cipher");
        int choice = Integer.parseInt(scanner.nextLine());

        EncryptionMethod cipher;

        try {
            cipher = switch (choice) {
                case 0 -> new DummyCipher();
                case 1 -> buildMonoalphabeticCipher(scanner);
                case 2 -> buildCaesarCipher(scanner);
                default -> throw new Exception("Invalid choice. Exiting.");
            };
        } catch (Exception e) {
            System.out.printf("Error: %s\n", e);
            return;
        }

        ToDoList toDoList = new ToDoList();
        CLI cli = new CLI(toDoList, cipher, scanner);
        cli.start();

        scanner.close();
    }
    private static MonoalphabeticCipher buildMonoalphabeticCipher(Scanner scanner) throws Exception {
        System.out.println("Enter shuffled alphabet (26 letters):");
        String shuffledAlphabet = scanner.nextLine().toUpperCase();
        if (shuffledAlphabet.length() != 26) {
            throw new Exception("Invalid alphabet. Exiting.");
        }
        return new MonoalphabeticCipher(shuffledAlphabet);
    }

    public static CaesarCipher buildCaesarCipher(Scanner scanner) throws Exception {
        System.out.println("Enter Caesar Cipher shift (0-25):");
        int shift = Integer.parseInt(scanner.nextLine());
        return new CaesarCipher(shift);
    }
}