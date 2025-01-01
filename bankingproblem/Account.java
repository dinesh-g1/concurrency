package bankingproblem;

public class Account {
    private final int id;

    private int amount;


    public Account(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public void credit(int amt) {
        this.amount += amt;
    }

    public void debit(int amt) {
        if (amt > amount)
            throw new IllegalArgumentException("Not enough money present in the account");
        this.amount -= amt;
    }

    public int getAmount() {
        return amount;
    }

    public int getId() {
        return id;
    }
}
