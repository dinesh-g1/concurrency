package bankingproblem;

public class Bank {

    public synchronized void  transfer(Account src, Account dst, int amount) {
        Account account1, account2;
        if (src.getId() < dst.getId()) {
            account1 = src;
            account2 = dst;
        } else {
            account1 = dst;
            account2 = src;
        }
        synchronized (account1) {
            synchronized (account2) {
                src.debit(amount);
                dst.credit(amount);
            }
        }
    }
}
