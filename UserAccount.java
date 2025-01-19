public class UserAccount {
    private int accountNumber;
    private String pin;
    private String firstName;
    private String lastName;
    private double balance;

    public UserAccount(int accountNumber, String pin, String firstName, String lastName, double balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public boolean validatePin(String inputPin) {
        return this.pin.equals(inputPin);
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public void updateName(String firstName, String lastName) {
        this.firstName = capitalizeFirstLetter(firstName);
        this.lastName = lastName.toUpperCase();
        System.out.println("Name updated to: " + getFullName());
    }

    private String capitalizeFirstLetter(String name) {
        name = name.trim();
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }
}
