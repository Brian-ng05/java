package BankingSystem.v2;

import java.util.Scanner;

class Account {
    private double balance;
    private double[] transactions;

    public Account(double initialBalance) {
        setBalance(initialBalance);
        this.transactions = new double[5];
    }

    public void setBalance(double balance ){
        this.balance = balance;
    }
    public double getBalance(){
        return balance;
    }
    public void printTransactionHistory(){
        for (double t : transactions){
            if (t != 0.0) {
                System.out.println((t > 0 ? "+" : "") + t);
            }
        } System.out.println();
    }
    public void deposit(double newChange){
        this.balance += newChange;
    }
    public void withdraw(double newChange){
        this.balance -= newChange;
    }
    public void updateTransactionHistory(double transaction){
        for (int i = transactions.length - 1; i > 0; i--) {
            transactions[i] = transactions[i - 1];
        }
        transactions[0] = transaction;
    }
}

public class Banking {
    public static boolean checkSelected(int selected) {
        if (selected == -1) {
            System.out.println("Please select an account first.");
            System.out.println();
            return false;
        }
        return true;
    }
    public static boolean checkIsEmpty(String value) {
        return value.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account[] accounts = new Account[5];
        int selectedAccount = -1;
        int accountCount;
        boolean running = false;

        while (true) {
            System.out.print("Enter number of account to create (1-5): ");
            String acc = scanner.nextLine().trim();
            System.out.println();

            if (checkIsEmpty(acc)) {
                System.out.println("Invalid input. Number of account cannot be empty.\n");
                continue;
            }

            try {
                accountCount = Integer.parseInt(acc);
                if ( accountCount < 1 || accountCount > 5) {
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Please enter a valid number.");
                System.out.println();
            }
        }

        for (int i = 0; i < accountCount; i++) {
            System.out.print("Enter balance for account " + (i + 1) + ": ");

            double initialBalance = Double.parseDouble(scanner.nextLine());
            accounts[i] = new Account(initialBalance);

            System.out.println("Account " + (i + 1) + " has been created with initial balance: " + accounts[i].getBalance());
            System.out.println();
        }

        do {
            String[] menu = {"Banking Menu:", "1. Choice An Account", "2. Deposit", "3. Withdraw", "4. Transaction History", "5. Check balance of all account" , "6. Exit"};
            for (String i : menu) {
                System.out.println(i);
            }
            System.out.print("Please enter your option: ");
            String userChoice = scanner.nextLine();

            switch (userChoice) {
                case "1":
                    System.out.print("Please choice an account (1-" + accountCount + "): ");
                    int accountChoice = Integer.parseInt(scanner.nextLine());
                    if (accountChoice >= 1 && accountChoice <= accountCount) {
                        selectedAccount = accountChoice - 1;
                        System.out.println("Selected account: " + (selectedAccount + 1));
                        System.out.println();
                    } else {
                        System.out.println("Invalid account number.");
                    }

                    break;
                case "2": // Deposit
                    if (!checkSelected(selectedAccount)) break;

                    Account accDeposit = accounts[selectedAccount];

                    System.out.print("Enter deposit amount: ");
                    String depositInput = scanner.nextLine().trim();

                    if (checkIsEmpty(depositInput)) {
                        System.out.println("Invalid input. Deposit amount cannot be empty.");
                        System.out.println();
                        break;
                    }

                    double depositAmount;
                    try {
                        depositAmount = Double.parseDouble(depositInput);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number format. Please enter a valid number.");
                        System.out.println();
                        break;
                    }

                    if (depositAmount > 0) {

                        accDeposit.deposit(depositAmount);

                        System.out.println("Updated balance: " + accDeposit.getBalance());
                        System.out.println();

                        accDeposit.updateTransactionHistory(depositAmount);

                    } else {
                        System.out.println("Invalid deposit amount. Please enter a positive number.");
                        System.out.println();
                    }
                    break;

                case "3": // Withdraw
                    if (!checkSelected(selectedAccount)) break;

                    Account accWithdraw = accounts[selectedAccount];

                    System.out.print("Enter withdrawal amount: ");
                    String withdrawInput = scanner.nextLine().trim();

                    if (checkIsEmpty(withdrawInput)) {
                        System.out.println("Invalid withdrawal amount. Please enter a positive number and ensure sufficient balance.");
                        System.out.println();
                        break;
                    }

                    double withdrawAmount;
                    try {
                        withdrawAmount = Double.parseDouble(withdrawInput);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number format. Please enter a valid number.");
                        System.out.println();
                        break;
                    }

                    if (withdrawAmount > 0 && withdrawAmount <= accWithdraw.getBalance()) {
                        accWithdraw.withdraw(withdrawAmount);
                        System.out.println("Updated balance: " + accWithdraw.getBalance());
                        System.out.println();

                        accWithdraw.updateTransactionHistory(-withdrawAmount);
                    } else {
                        System.out.println("Invalid deposit amount. Please enter a positive number.");
                        System.out.println();
                    }
                    break;
                case "4":
                    if (!checkSelected(selectedAccount)) {
                        break;
                    }
                    accounts[selectedAccount].printTransactionHistory();
                    System.out.println();
                    break;
                case "5":
                    for(int i = 0; i < accountCount; i++){
                    System.out.println("Balance of account " + (i + 1) + ": " + accounts[i].getBalance());
                    }
                    System.out.println();
                    break;
                case "6":
                    System.out.println("Exiting...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please select a valid option (1-6).");
                    System.out.println();
                    break;
            }
        } while (running);
    }
}