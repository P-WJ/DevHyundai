public class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int money) {
        this.balance += money;
    }

    public void withdraw(int money) {
        if (money > this.balance) {
//            this.balance = 0;
            throw new IllegalArgumentException("출금하려는 금액이 잔고보다 많습니다.");
        } else {
            this.balance -= money;
        }
    }

    public void send(int money, Account otherAccount) {
        if (money > balance) {
            throw new IllegalArgumentException("송금하려는 금액이 잔고보다 많습니다.");
        } else {
            withdraw(money);
            otherAccount.deposit(money);
        }
    }


    private int interestPer;

    public void applyInterestFive() {
        setInterestPer(5);
        applyInterest();
    }

    public void setInterestPer(int interestPer) {
        this.interestPer = interestPer;
    }

    private int getInterest(int balance) {
        double rate = 0.01 * interestPer;
        return (int)(balance * rate);
    }

    public void applyInterest() {
        int interest = getInterest(balance);
        balance += interest;
    }

    public int predictBalance(int targetYear) {
        int predictBalance = balance;
        for (int year = 1; year <= targetYear; year++) {
            predictBalance += getInterest(predictBalance);
        }
        return predictBalance;
    }

    public void stolen() {
        this.balance = 0;
    }
}
