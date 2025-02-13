public class Account {
    private double balance;
    private String accountNumber;


    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) balance -= amount;
    }

    public double getBalance() { return balance; }


    public static void main(String[] args) {
        Account acc = new Account();
        acc.deposit(700);
        acc.withdraw(100);
        System.out.println("Баланс: " + acc.getBalance());
    }
}