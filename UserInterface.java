import java.util.Scanner;

public class UserInterface {
    private static Account[] accounts = new Account[100]; // Array for storing accounts
    private static int accountCount = 0;
    private static int nextAccountNumber = 1001;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            mainMenu();
        }
    }

    private static void mainMenu() {
        System.out.println("\n--- Welcome to the Banking Application ---");
        System.out.println("1. Create a new account");
        System.out.println("2. Deposit money");
        System.out.println("3. Withdraw money");
        System.out.println("4. View account details");
        System.out.println("5. Update contact details");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");

        int choice = sc.nextInt();
        sc.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                createAccount();
                break;
            case 2:
                performDeposit();
                break;
            case 3:
                performWithdrawal();
                break;
            case 4:
                showAccountDetails();
                break;
            case 5:
                updateContact();
                break;
            case 6:
                System.out.println("Thank you for using the Banking Application!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
        }
    }

    private static void createAccount() {
        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();
        System.out.print("Enter initial deposit amount: ");
        double initialBalance = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter email address: ");
        String email = sc.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = sc.nextLine();

        Account newAccount = new Account(nextAccountNumber, name, initialBalance, email, phoneNumber);
        accounts[accountCount++] = newAccount;
        System.out.println("Account created successfully with Account Number: " + nextAccountNumber);
        nextAccountNumber++;
    }

    private static Account findAccount(int accountNumber) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                return accounts[i];
            }
        }
        return null;
    }

    private static void performDeposit() {
        System.out.print("Enter account number: ");
        int accNum = sc.nextInt();
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        Account account = findAccount(accNum);
        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Account not found!");
        }
    }

    private static void performWithdrawal() {
        System.out.print("Enter account number: ");
        int accNum = sc.nextInt();
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        Account account = findAccount(accNum);
        if (account != null) {
            account.withdraw(amount);
        } else {
            System.out.println("Account not found!");
        }
    }

    private static void showAccountDetails() {
        System.out.print("Enter account number: ");
        int accNum = sc.nextInt();
        sc.nextLine();

        Account account = findAccount(accNum);
        if (account != null) {
            account.displayAccountDetails();
        } else {
            System.out.println("Account not found!");
        }
    }

    private static void updateContact() {
        System.out.print("Enter account number: ");
        int accNum = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter new email: ");
        String email = sc.nextLine();
        System.out.print("Enter new phone number: ");
        String phoneNumber = sc.nextLine();

        Account account = findAccount(accNum);
        if (account != null) {
            account.updateContactDetails(email, phoneNumber);
        } else {
            System.out.println("Account not found!");
        }
    }
}
