package bankingproblem;

import java.util.List;

public class Auditor implements Runnable{
    private final List<Account> accounts;

    public Auditor(List<Account> accounts, Bank bank) {
        this.accounts = accounts;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (accounts.get(0)) {
                synchronized (accounts.get(1)) {
                    synchronized (accounts.get(2)) {
                        synchronized (accounts.get(3)) {
                            synchronized (accounts.get(4)) {
                                int sum = 0;
                                for (Account a: accounts) {
                                    System.out.printf("Money in bank account id, %d, is: %d\n", a.getId(), a.getAmount());
                                    sum += a.getAmount();
                                }
                                System.out.println("Total amount in the bank: " + sum);
                                try {
                                    Thread.sleep(5000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
