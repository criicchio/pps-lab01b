package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    //TODO remove magic numbers
    private SilverBankAccount silverAccount;
    private BronzeBankAccount bronzeBankAccount;
    private GoldBankAccount goldBankAccount;

    @BeforeEach
    void init(){
        CoreBankAccount bankAccount = new CoreBankAccount();
        this.silverAccount = new SilverBankAccount(bankAccount);
        this.bronzeBankAccount = new BronzeBankAccount(bankAccount);
        this.goldBankAccount = new GoldBankAccount(bankAccount);

    }

    @Test
    public void testInitiallyEmpty() {
        assertEquals(0, this.silverAccount.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.silverAccount.deposit(1000);
        assertAll(
                () -> assertEquals(1000, this.silverAccount.getBalance()),
                () -> assertEquals(1000, this.bronzeBankAccount.getBalance()),
                () -> assertEquals(1000, this.goldBankAccount.getBalance())
        );

    }

    @Test
    public void testCanWithdraw() {
        this.silverAccount.deposit(1000);
        this.silverAccount.withdraw(200);
        assertEquals(799, this.silverAccount.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        this.silverAccount.deposit(1000);
        assertThrows(IllegalStateException.class, () -> this.silverAccount.withdraw(1200));
    }

}
