package bank.entity;

import bank.entity.parentClasses.BankAccount;

public class PaymentAccount extends BankAccount {
    private Double amount;

    public PaymentAccount(Integer id, User user, Bank bank) {
        super(id,user,bank);
        this.amount = 0.0;
    }

    public PaymentAccount() {
        super(-1, new User(), new Bank());
        this.amount = 0.0;
    }

    @Override
    public String toString() {
        return "Имя банка: " + super.getBank().getName() + "\nФИО пользователя: " + super.getUser().getName().toString()
                + "\nСумма денег: " + amount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
