package bank.entity;

import java.time.LocalDate;
import bank.entity.parentClasses.BankAccount;

public class CreditAccount extends BankAccount {
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer countMonth;
    private Double amount;
    private Double monthlyAmount;
    private Double interestRate;
    private Employee employee;
    private PaymentAccount paymentAccount;

    public CreditAccount(Integer id, User user, Bank bank, Employee employee, PaymentAccount paymentAccount,
                         LocalDate startDate, Integer countMonth, Double amount) {
        super(id, user, bank);
        this.startDate = startDate;
        this.countMonth = countMonth;
        this.endDate = startDate.plusMonths(this.countMonth);
        this.amount = amount;
        this.interestRate = bank.getInterestRate();
        this.monthlyAmount = (1 + getInterestRate() / 100) * amount / countMonth;
        this.employee = employee;
        this.paymentAccount = paymentAccount;
    }

    public CreditAccount() {
        super();
        this.startDate = LocalDate.of(1, 1, 1);
        this.countMonth = 1;
        this.endDate = startDate.plusMonths(this.countMonth);
        this.amount = -1.0;
        this.interestRate = 1.0;
        this.monthlyAmount = (1 + getInterestRate() / 100) * amount / countMonth;
        this.employee = new Employee();
        this.paymentAccount = new PaymentAccount();
    }

    @Override
    public String toString() {
        return "Имя банка: " + super.getBank().getName() + "\nИмя пользователя: " + super.getUser().getName() +
                "\nКоличество месяцев: " + countMonth + "\nДата взятия кредита: " + startDate.toString() +
                "\nПредполагаемая дата погашения кредита:" + endDate.toString() + "\nСумма кредита: " +
                amount + "\nПроцентная ставка: " + interestRate + "%" + "\nЕжемесячный платёж: " +
                countMonth + "\nСотрудник, который выдал кредит: " + employee.getName() +
                "\nId платёжного счёта: " + paymentAccount.getId().toString();
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getCountMonth() {
        return countMonth;
    }

    public void setCountMonth(Integer countMonth) {
        this.countMonth = countMonth;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getMonthlyAmount() {
        return monthlyAmount;
    }

    public void setMonthlyAmount(Double monthlyAmount) {
        this.monthlyAmount = monthlyAmount;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public PaymentAccount getPaymentAccount() {
        return paymentAccount;
    }

    public void setPaymentAccount(PaymentAccount paymentAccount) {
        this.paymentAccount = paymentAccount;
    }
}