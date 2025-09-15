class BankAccount {
    String accountHolder;
    int accountNumber;
    double balance;

    BankAccount(String accountHolder, int accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    void displayBalance() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: " + balance);
        System.out.println("-----------------------------");
    }
}

public class BankAccounts {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Shivam", 1001, 5000);

        acc1.displayBalance();
        acc1.deposit(2000);
        acc1.displayBalance();
        acc1.withdraw(3000);
        acc1.displayBalance();
        acc1.withdraw(5000); // This should fail
    }
}
