package e1;

public class SilverBankAccount extends DecoratorBankAccount{

    public SilverBankAccount(BankAccount bankAccount) {
        super(bankAccount);
    }

    @Override
    public int getBalance() {
        return super.getBalance();
    }

    @Override
    public void deposit(int amount) {
        super.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        if (this.getBalance() < amount){
            throw new IllegalStateException();
        }
        super.withdraw(amount + 1);
    }
}
