import java.util.ArrayList;

class Account {
    private int accountNumber;
    private double balance;
    private Bank bank;

    public Account(int accountNumber, Bank bank) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.bank = bank;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Bank getBank() {
        return bank;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
        }
    }
}

class Customer {
    private String name;
    private ArrayList<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void viewBalance() {
        System.out.println("\nCustomer: " + name);
        for (Account acc : accounts) {
            System.out.println("Bank: " + acc.getBank().getName() +
                               " | Account No: " + acc.getAccountNumber() +
                               " | Balance: " + acc.getBalance());
        }
    }
}

class Bank {
    private String name;
    private ArrayList<Account> accounts;
    private static int accountCounter = 1001;

    public Bank(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Account openAccount(Customer customer) {
        Account account = new Account(accountCounter++, this);
        accounts.add(account);
        customer.addAccount(account);
        return account;
    }
}

public class AccountDemo {
    public static void main(String[] args) {
        Bank bank1 = new Bank("State Bank");
        Bank bank2 = new Bank("City Bank");

        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");

        Account acc1 = bank1.openAccount(customer1);
        acc1.deposit(5000);

        Account acc2 = bank1.openAccount(customer2);
        acc2.deposit(3000);

        Account acc3 = bank2.openAccount(customer1);
        acc3.deposit(7000);

        customer1.viewBalance();
        customer2.viewBalance();
    }
}
