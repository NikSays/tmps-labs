package lab0;

import lab0.encryption.EncryptionMethod;

import java.util.List;
import java.util.Scanner;

public class CLI {

    private final ToDoList toDoList;
    private final EncryptionMethod cipher;

    private final Scanner scanner;

    public CLI(ToDoList toDoList, EncryptionMethod cipher, Scanner scanner) {
        this.toDoList = toDoList;
        this.cipher = cipher;
        this.scanner = scanner;
    }

    public void start() {
        String command = "";
        while (!command.equals("exit")) {
            System.out.println();
            System.out.println("Choose an option: (add, list, raw, remove, exit)");
            command = this.scanner.nextLine();
            System.out.println();

            switch (command) {
                case "add":
                    System.out.println("Enter a task:");
                    String task = this.scanner.nextLine();
                    this.toDoList.addItem(this.cipher.encrypt(task));
                    break;
                case "list":
                    System.out.println("To-Do List:");
                    List<String> tasks = this.toDoList.getItems();
                    for (int i = 0; i < tasks.size(); i++) {
                        String decryptedTask = this.cipher.decrypt(tasks.get(i));
                        System.out.printf("%d: %s\n", i, decryptedTask);
                    }
                    break;
                case "raw":
                    System.out.println("Encrypted To-Do List Data:");
                    this.toDoList.getItems().forEach(System.out::println);
                    break;
                case "remove":
                    System.out.println("Enter the index to remove:");
                    int index = Integer.parseInt(this.scanner.nextLine());
                    try {
                        this.toDoList.removeItem(index);
                    } catch (Exception e) {
                        System.out.println("Invalid index!");
                    }
                    break;
            }
        }
        this.scanner.close();
    }
}

