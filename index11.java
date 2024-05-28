import java.util.Scanner;

class Bank {

  static class BankAccount { // Made BankAccount class static

    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    BankAccount(String name, String id) {
      this.customerName = name; // Corrected variable assignment
      this.customerId = id; // Corrected variable assignment
    }

    void deposit(int amount) {
      if (amount > 0) {
        balance = balance + amount;
        System.out.println("your total balance: " + balance);
        previousTransaction = amount; // Corrected variable assignment
      }
    }

    void withdraw(int amount) {
      if (amount > 0 && balance >= amount) { // Added condition to check if enough balance is available
        balance = balance - amount;
        System.out.println("your total balance: " + balance);
        previousTransaction = -amount; // Corrected variable assignment
      } else {
        System.out.println("Insufficient balance.");
      }
    }

    void getPreviousTransaction() { // Renamed method to follow Java naming convention
      if (previousTransaction > 0) {
        System.out.println("Deposited: " + previousTransaction);
      } else if (previousTransaction < 0) {
        System.out.println("Withdrawn: " + Math.abs(previousTransaction));
      } else {
        System.out.println("No transaction occurred");
      }
    }

    void showMenu() {
      Scanner sc = new Scanner(System.in);
      System.out.println("Welcome " + customerName);
      System.out.println("Your Id is " + customerId);
      System.out.println();

      char option;
      do {
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous Transaction");
        System.out.println("E. Exit");
        System.out.println("Enter an Option");
        option = sc.next().charAt(0);
        System.out.println();

        switch (option) {
          case 'A':
            System.out.println("Balance = " + balance);
            System.out.println();
            break;
          case 'B':
            System.out.println("Enter an amount to deposit: ");
            int amount1 = sc.nextInt();
            deposit(amount1);
            System.out.println();
            break;
          case 'C':
            System.out.println("Enter an amount to withdraw: ");
            int amount2 = sc.nextInt();
            withdraw(amount2);
            System.out.println();
            break;
          case 'D':
            System.out.println();
            getPreviousTransaction();
            System.out.println();
            break;
          case 'E':
            System.out.println("**********");
            break;
          default:
            System.out.println("Invalid option");
            break;
        }
      } while (option != 'E');
      System.out.println("Thank you for using our services");
    }
  }

  public static void main(String[] args) {
    System.out.println("hello world");
    BankAccount obj = new BankAccount("manas", "1098");
    obj.showMenu();

  }
}
