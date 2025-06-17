package BankingSystem.v0;

import java.util.Scanner;

public class Banking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter your initial balance: ");
//        double balance = Double.parseDouble(sc.nextLine());
//        System.out.println();
        double balance = 0.0;
        while (true){
            System.out.print("Enter your initial amount: ");
            String balanceInput = sc.nextLine().trim();
            System.out.println();

            if (balanceInput.isEmpty()) {
                System.out.println("Invalid input. Initial balance amount cannot be empty.\n");
                continue;
            }

            try {
                balance = Double.parseDouble(balanceInput);
            if (balance < 0) {
                System.out.println("Initial balance cannot be negative.\n");
                continue;
            }
            break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Please enter a valid number.");
                System.out.println();
            }
        }

        boolean running = true;
        boolean hasTransactionHistory = false;
        String [] transactionHistory = new String[5];
//        Deque<String> transactionHistory = new ArrayDeque<>();
        do {
            String[] menu = {"Banking Menu:", "1. Deposit", "2. Withdraw", "3. Transaction History", "4. Exit"};
            for (String i : menu) {
                System.out.println(i);
            }
            System.out.println();
            System.out.print("Enter your option (1-4): ");
            String userChoice = sc.nextLine();

            switch (userChoice) {
                case "1":
                    System.out.print("Enter your deposit amount: ");
                    String depositInput = sc.nextLine().trim();

                    if (depositInput.isEmpty()) {
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
                        balance += depositAmount;
                        System.out.println("Updated balance: " + balance);
                        System.out.println();
                        hasTransactionHistory = true;

                        for (int i  = transactionHistory.length - 1; i > 0; i--) {
                            transactionHistory[i] = transactionHistory[i - 1];
                        }

                        transactionHistory[0] = "Deposit amount: " + depositAmount;
                    } else {
                        System.out.println("Invalid deposit amount. Please enter a positive number.");
                        System.out.println();
                    }
                    break;
                case "2":
                    System.out.print("Enter your withdraw amount: ");
                    String withdrawInput = sc.nextLine().trim();

                    if (withdrawInput.isEmpty()) {
                        System.out.println("Invalid input. Withdraw amount cannot be empty.");
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

                    if (withdrawAmount <= balance && withdrawAmount > 0) {
                        balance -= withdrawAmount;
                        System.out.println("Update balance: " + balance);
                        System.out.println();
                        hasTransactionHistory = true;

                        for (int i  = transactionHistory.length - 1; i > 0; i--) {
                            transactionHistory[i] = transactionHistory[i - 1];
                        }

                        transactionHistory[0] = "Withdraw amount: -" + withdrawAmount;
                    } else {
                        System.out.println("Insufficient balance. Please try again.");
                        System.out.println();
                    }
                    break;
                case "3":
                    if (!hasTransactionHistory) {
                        System.out.println("No transactions found.");
                        System.out.println();
                    } else {
                        System.out.println("Transaction History");
                        System.out.println("-------------------");
                        for (String i : transactionHistory) {
                            if (i != null) {
                                System.out.println(i);
                            }
                        }
                        System.out.println();
                    }
                    break;
                case "4":
                    System.out.println("Exiting.......");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please select a valid option (1-4).");
                    System.out.println();
                    break;
            }
        } while (running);
    }
}

//transactionHistory.addFirst("Withdraw: -" + withdrawAmount);
//if (transactionHistory.size() > 5) {
//        transactionHistory.removeLast();