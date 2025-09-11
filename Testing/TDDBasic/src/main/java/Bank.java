import java.util.ArrayList;
import java.util.List;

public class Bank {
    List<Account> accounts = new ArrayList<>();

    public void createAccount(Account account) {
        accounts.add(account);
    }

    public int getAccountCount() {
        return accounts.size();
    }

    public int stealBank() {
        int totalMoney = 0;
        for (int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i);
            totalMoney += account.getBalance();
            account.stolen();
        }
        return totalMoney;
    }
}


