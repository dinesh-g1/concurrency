package bankingproblem;

public class Transaction implements Runnable {
    private final Account sourceAccount;
    private final Account destinationAccount;
    private final int transferAmount;
    private final Bank bank;

    public Transaction(Account sourceAccount, Account destinationAccount, int transferAmount, Bank bank) {
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.transferAmount = transferAmount;
        this.bank = bank;
    }

    @Override
    public void run() {
        bank.transfer(sourceAccount, destinationAccount, transferAmount);
    }
}
