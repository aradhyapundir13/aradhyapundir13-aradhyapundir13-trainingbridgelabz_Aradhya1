class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds for this withdrawal.");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}