public class Account {
    private double balance;

    public Account() {
        this.balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println(" Deposited: " + amount);
            System.out.println(" Your balance: " + getBalance());
        } else {
            System.out.println(" Not a valid amount to deposit.");
        }
    }

    public void withdraw(double amount) {
        if (balance < amount) {
            System.out.println(" Your balance is not sufficient.");
            System.out.println(" Your balance: " + getBalance());
        } else if (amount > 0) {
            balance = balance - amount;
            System.out.println(" Withdrew: " + amount);
            System.out.println(" Your balance: " + getBalance());
        } else {
            System.out.println(" Not a valid amount to withdraw.");
        }
    }
}
