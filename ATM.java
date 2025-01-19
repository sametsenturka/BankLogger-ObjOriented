import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ATM {
    private Map<Integer, UserAccount> accounts = new HashMap<>();
    private Scanner input = new Scanner(System.in);

    public ATM() {
        // Initialize with sample accounts
        accounts.put(12345, new UserAccount(12345, "1234", "Joseph", "LEDET", 1000.0));
        accounts.put(67890, new UserAccount(67890, "5678", "Yusuf", "OGRENCI", 1500.0));
    }

    public void start() {
        System.out.print("Enter account number: ");
        int accountNumber = input.nextInt();
        System.out.print("Enter PIN: ");
        String pin = input.next();

        UserAccount account = accounts.get(accountNumber);
        if (account != null && account.validatePin(pin)) {
            showMenu(account);
        } else {
            System.out.println("ERROR: Account/PIN combination not found.");
        }
    }

    private void showMenu(UserAccount account) {
        String[] options = {"Account Balance", "Deposit", "Withdrawal", "Change Name"};
        int choice;
        do {
            System.out.println("Hello " + account.getFullName());
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + " - " + options[i]);
            }
            System.out.println("0 to Quit");
            System.out.print("Please enter your selection >> ");
            choice = input.nextInt();
            input.nextLine(); // get newline

            switch (choice) {
                case 0:
                    System.out.println("Thank you for using our ATM. Have a nice day!");
                    break;
                case 1:
                    System.out.println("Your balance is: " + account.getBalance());
                    break;
                case 2:
                    System.out.print("How much are you depositing? ");
                    double depositAmount = input.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("How much are you withdrawing? ");
                    double withdrawalAmount = input.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;
                case 4:
                    System.out.print("Enter new first name: ");
                    String firstName = input.nextLine();
                    System.out.print("Enter new last name: ");
                    String lastName = input.nextLine();
                    account.updateName(firstName, lastName);
                    break;
                default:
                    System.out.println("ERROR: Invalid Entry.");
            }
        } while (choice != 0);
    }
}
