class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class ATM {
    private int balance = 10000;

    public void withdraw(int amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient Balance! Your current balance is ₹" + balance);
        } else {
            balance -= amount;
            System.out.println("Withdrawal Successful! ₹" + amount + " withdrawn.");
            System.out.println("Remaining Balance: ₹" + balance);
        }
    }
}

public class ATMWithdrawal {
    public static void main(String[] args) {
        ATM atm = new ATM();

        try {
            atm.withdraw(12000);
        } catch (InsufficientFundsException e) {
            System.out.println("Transaction Failed: " + e.getMessage());
        }

        System.out.println("\nTrying another withdrawal...");
        try {
            atm.withdraw(5000);
        } catch (InsufficientFundsException e) {
            System.out.println("Transaction Failed: " + e.getMessage());
        }
    }
}
