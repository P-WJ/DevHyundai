import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankTest {
    @Test
    void testStealBank() {
        // 은행
        Bank bank = new Bank();

        // 은행 계좌들
        Account account1 = new Account(3_000_000);
        Account account2 = new Account(3_000_000);
        Account account3 = new Account(4_000_000);
        Account account4 = new Account(4_000_000);

        // 은행에 계좌 등록
        bank.createAccount(account1);
        bank.createAccount(account2);
        bank.createAccount(account3);
        bank.createAccount(account4);

        assertEquals(4, bank.getAccountCount());

        // 은행 강도 발생
        assertEquals(14_000_000, bank.stealBank());

        // 도둑맞은 계좌들
        assertEquals(0, account1.getBalance());
        assertEquals(0, account2.getBalance());
        assertEquals(0, account3.getBalance());
        assertEquals(0, account4.getBalance());
    }
}

