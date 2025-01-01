package bankingproblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BankRunner {
    public static void main(String[] args) {
        Bank bank = new Bank();
        List<Account> accounts = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i <= 5; i++) {
            Account account = new Account(i, random.nextInt(100, 200));
            accounts.add(account);
        }
        int totalAmountInTheBank = 0;
        for (Account account : accounts) {
            System.out.printf("Money in bank account id, %d, is: %d\n", account.getId(), account.getAmount());
            totalAmountInTheBank += account.getAmount();
        }
        System.out.println("Total amount in bank anytime should be: " + totalAmountInTheBank);
        Thread transaction = new Thread(new Transaction(accounts.get(0), accounts.get(2), 20, bank));
        transaction.start();
        Thread transaction1 = new Thread(new Transaction(accounts.get(1), accounts.get(3), 20, bank));
        transaction1.start();
        Thread auditor = new Thread(new Auditor(accounts, bank));
        auditor.start();
    }
}
