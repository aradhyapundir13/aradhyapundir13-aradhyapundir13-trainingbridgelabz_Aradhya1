public class BankingSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(500.0);
        try {
            account.withdraw(600.0);
            System.out.println("Withdrawal successful. Remaining balance: " + account.getBalance());
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}