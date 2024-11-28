# Behavioral Design Patterns

## Author: Nejințev Nicolai

----

## Objectives:

1. Study and understand the Behavioral Design Patterns.
2. As a continuation of the previous laboratory work, think about what communication between software entities might be
   involved in your system.
3. Implement some additional functionalities using behavioral design patterns.

## Used Design Patterns:

- State

## Implementation

In the last lab, the CLI was one big class with very intertwined methods. In this lab, I split it into multiple classes,
using the State Behavioral Pattern.

The common values like the logger and the invoice builder are stored in the shared context.

Run with this command:

```bash
mvn package -Dlab=3 && java -jar ./target/lab3.jar 
 ```

### Snippets

Main menu class.  
You can see how the context is set, ant the state is changed to allow for different sub-menus.

```java
public class initialState implements CLIState {
   private ExchangeCLI context;

   public void setContext(ExchangeCLI cli) {
      this.context = cli;
   }

   public void runDialog() {
      System.out.println("\nWhat will the teller do?");
      System.out.println("""
              n -- Next customer
              r -- set exchange Rates
              t -- set exchange Tax
              c -- Close""");
      System.out.print("Enter command: ");
      String b = this.context.getScanner().nextLine();
      switch (b) {
         case "n":
            this.context.setState(new greetCustomer());
            break;
         case "r":
            this.context.setState(new setRates());
            break;
         case "t":
            this.context.setState(new setTax());
            break;
         case "c":
            this.context.setState(new stop());
            return;
         default:
            System.out.println("Error: Invalid command");
            break;
      }
   }
}
```

Part of CLI Class.  
It has become just a runner that infinitely calls `runDialog` on the state until a state calls `stop()`

```java
public class ExchangeCLI {
   private CLIState state;
   private boolean stop = false;

   public void stop() {
      this.stop = true;
   }

   public void setState(CLIState state) {
      state.setContext(this);
      this.state = state;
   }

   public void run() throws Exception {
      if (this.state == null) {
         throw new Exception("State is not initialized");
      }
      while (!this.stop) {
         this.state.runDialog();
      }
   }
}
```

## Conclusions / Results

Using behavioral design patterns can greatly simplify the internal structure of a complicated system. In this laboratory
work, I have realized that the structure of my CLI is too complex, and found a better structure for it.