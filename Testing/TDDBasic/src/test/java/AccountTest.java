import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

///  요구사항
/// - 계좌를 생성하면, 10,000이 기본적으로 생성된다.
/// - 계좌 생성시 초기 입금 금액을 정할 수 있다.
/// - 입금하기 구현
/// - 출금하기 구현

public class AccountTest {
    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account(10000);
    }
    @Test
    void createAccountWithDeposit() {
        assertEquals(10000, account.getBalance());
    }

    @Test
    void createAccountWithNoMoney() {
        Account account = new Account(0);
        assertEquals(0, account.getBalance());
    }

    @Test
    void deposit() {
        assertEquals(10000, account.getBalance());
        account.deposit(2000);
        assertEquals(12000, account.getBalance());
    }

    @Test
    void withdraw() {
        assertEquals(10000, account.getBalance());
        account.withdraw(1000);
        assertEquals(9000, account.getBalance());
    }

    @Test
    void withdrawMoreThanBalance() {
        assertEquals(10000, account.getBalance());
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(100000);
        });
        assertEquals("출금하려는 금액이 잔고보다 많습니다.", e.getMessage());
    }

    @Test
    void sendToOtherBigMoney() {
        // 받는 사람의 계좌
        Account otherAccount = new Account(10000);
        assertEquals(10000, otherAccount.getBalance());

        // 송금
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            account.send(50000, otherAccount);
        });
        assertEquals("송금하려는 금액이 잔고보다 많습니다.", e.getMessage());

        // 받은 사람의 계좌
        assertEquals(10000, otherAccount.getBalance());
    }

    @Test
    void applyFivePercentInterest() {
        account.applyInterestFive();
        assertEquals(10500, account.getBalance());
    }

    @Test
    void setterInterest() {
        account.setInterestPer(5);
        account.applyInterest();
        assertEquals(10500, account.getBalance());
    }

    @Test
    void predictNYearInterest() {
        account.setInterestPer(10);
        int ret = account.predictBalance(3);
        assertEquals(13310, ret);
    }

    @Test
    void testStolen() {
        account.stolen();
        assertEquals(0, account.getBalance());
    }
}
