package bank.entity;

import java.util.Date;
import bank.entity.helpClass.FullName;
import bank.entity.parentClasses.Human;

public class Employee extends Human {
    private Bank bank;
    private BankOffice bankOffice;
    private String job;
    private Boolean distantWork;
    private Boolean canLend;
    private Double salary;

    public Employee(Integer id, FullName name, Date birthday, Bank bank, BankOffice bankOffice, String job,
                    Double salary) {
        super(id, name, birthday);
        this.bank = bank;
        this.bankOffice = bankOffice;
        this.job = job;
        this.distantWork = true;
        this.canLend = true;
        this.salary = salary;
    }

    public Employee() {
        super(-1, new FullName("", ""), new Date());
        this.bank = new Bank();
        this.bankOffice = new BankOffice();
        this.job = "";
        this.distantWork = true;
        this.canLend = true;
        this.salary = -1.0;
    }

    @Override
    public String toString() {
        String str = "ФИО: " + super.getName().toString() + "\nДата рождения: " + super.getBirthDay() +
                "\nДолжность: " + job + "\nИмя банка: " + bank.getName();
        if (distantWork)
            str += "\nРаботает удалённо";
        else
            str += "\nРаботает в офисе";
        if (canLend)
            str += "\nМожет выдавать кредиты";
        else
            str += "\nНе может выдавать кредиты";
        str += "\nИмя офиса: " + bankOffice.getName() + "\nЗарплата: " + salary;
        return str;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public BankOffice getBankOffice() {
        return bankOffice;
    }

    public void setBankOffice(BankOffice bankOffice) {
        this.bankOffice = bankOffice;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Boolean getDistantWork() {
        return distantWork;
    }

    public void setDistantWork(Boolean distantWork) {
        this.distantWork = distantWork;
    }

    public Boolean getCanLend() {
        return canLend;
    }

    public void setCanLend(Boolean canLend) {
        this.canLend = canLend;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
