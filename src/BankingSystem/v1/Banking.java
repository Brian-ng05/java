package BankingSystem.v1;

import java.util.Scanner;

public class Banking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] balances = new double[5];
        double[][] transactions = new double[5][5];
        int selectedAccount = -1;
        int accountCount = 0;

        while (true) {
            System.out.print("Enter number of account to create (1-5): ");
            String acc = scanner.nextLine().trim();
            System.out.println();

            if (acc.isEmpty()) {
                System.out.println("Invalid input. Number of account cannot be empty.\n");
                continue;
            }

            try {
                accountCount = Integer.parseInt(acc);
                if (accountCount < 0 || accountCount > 5) {
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
            balances[i] = Double.parseDouble(scanner.nextLine());
            System.out.println("Account " + (i + 1) + " has been created with initial balance: " + balances[i]);
        }

        boolean running = true; // Variable to store user's choice

        do {
            String[] menu = {"Banking Menu:", "1. Choice An Account", "2. Deposit", "3. Withdraw", "4. Transaction History", "5. Exit"};
            for (String i : menu) {
                System.out.println(i);
            }

            String userChoice = scanner.nextLine(); // Read user's choice

            switch (userChoice) {
                case "1":
                    System.out.print("Please choice an account (1-" + accountCount + "): ");
                    int accountChoice = Integer.parseInt(scanner.nextLine());
                    if (accountChoice >= 1 && accountChoice <= accountCount) {
                        selectedAccount = accountChoice - 1;
                        System.out.println("Selected account: " + (selectedAccount + 1));
                    } else {
                        System.out.println("Invalid account number.");
                    }
                    break;
                case "2": // Deposit
                    if (!checkSelected(selectedAccount)) break;
                    System.out.print("Enter deposit amount: ");
                    String depositInput = scanner.nextLine().trim();

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
                        balances[selectedAccount] += depositAmount;
                        System.out.println("Updated balance: " + balances[selectedAccount]);
                        System.out.println();

                        for (int i = transactions.length - 1; i > 0; i--) {
                            transactions[selectedAccount][i] = transactions[selectedAccount][i - 1];
                        }

                        transactions[selectedAccount][0] = depositAmount;
                    } else {
                        System.out.println("Invalid deposit amount. Please enter a positive number.");
                        System.out.println();
                    }
                    break;

                case "3": // Withdraw
                    if (!checkSelected(selectedAccount)) break;
                    System.out.print("Enter withdrawal amount: ");
                    String withdrawInput = scanner.nextLine().trim();

                    if (withdrawInput.isEmpty()) {
                        System.out.println("Invalid input. Deposit amount cannot be empty.");
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

                    if (withdrawAmount > 0 && withdrawAmount <= balances[selectedAccount]) {
                        balances[selectedAccount] -= withdrawAmount;
                        System.out.println("Updated balance: " + balances[selectedAccount]);
                        System.out.println();

                        for (int i = transactions.length - 1; i > 0; i--) {
                            transactions[selectedAccount][i] = transactions[selectedAccount][i - 1];
                        }

                        transactions[selectedAccount][0] = -withdrawAmount;
                    } else {
                        System.out.println("Invalid deposit amount. Please enter a positive number.");
                        System.out.println();
                    }
                    break;
                case "4":
                    if (!checkSelected(selectedAccount)) break;
                    else {
                        System.out.println("Transaction History");
                        System.out.println("-------------------");
                        for (double i : transactions[selectedAccount]) {
                            if (i != 0.0) {
                                System.out.println((i > 0 ? "+" : "") + i);
                            }
                        }
                        System.out.println();
                    }
                    break;
                case "5":
                    System.out.println("Exiting...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please select a valid option (1-4).");
                    break;
            }
        } while (running);
    }
    static boolean checkSelected(int selected) {
        if (selected == -1) {
            System.out.println("Please select an account first.");
            System.out.println();
            return false;
        }
        return true;
    }
}