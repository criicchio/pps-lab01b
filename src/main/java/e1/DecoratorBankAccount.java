package e1;

public class DecoratorBankAccount implements BankAccount{

    protected BankAccount bankAccount;

    public DecoratorBankAccount(BankAccount bankAccount){
        this.bankAccount = bankAccount;
    }

    @Override
    public int getBalance() {
        return this.bankAccount.getBalance();
    }

    @Override
    public void deposit(int amount) {
        this.bankAccount.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        this.bankAccount.withdraw(amount);
    }
}
