package bank.entity;

import java.text.DecimalFormat;
import java.time.LocalDate;
import bank.entity.parentClasses.Human;

public class Employee extends Human {
    private Bank bank;
    private BankOffice bankOffice;
    private String profession;
    private Boolean distantWork;
    private Boolean canIssue;
    private Double salary;

    public Employee(Integer id, String name, String surname, LocalDate birthday, Bank bank, BankOffice bankOffice, String profession,
                    Double salary) {
        super(id, name, surname, birthday);
        this.bank = bank;
        this.bankOffice = bankOffice;
        this.profession = profession;
        this.distantWork = true;
        this.canIssue = true;
        this.salary = salary;
    }

    public Employee(Integer id, String name, String surname,  String middleName, LocalDate birthday, Bank bank, BankOffice bankOffice, String profession,
                    Double salary) {
        super(id, name, surname, middleName, birthday);
        this.bank = bank;
        this.bankOffice = bankOffice;
        this.profession = profession;
        this.distantWork = true;
        this.canIssue = true;
        this.salary = salary;
    }

    @Override
    public String toString() {
        String str = "ФИО: " + super.getFullName() + "\nДата рождения: " + super.getBirthDay() +
                "\nДолжность: " + profession + "\nИмя банка: " + bank.getName();
        if (distantWork)
            str += "\nРаботает в офисе";
        else
            str += "\nРаботает удалённо";
        if (canIssue)
            str += "\nМожет выдавать кредиты";
        else
            str += "\nНе может выдавать кредиты";
        str += "\nИмя офиса: " + bankOffice.getName() + "\nЗарплата: " + new DecimalFormat("#0.00").format(salary);
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

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Boolean getDistantWork() {
        return distantWork;
    }

    public void setDistantWork(Boolean distantWork) {
        this.distantWork = distantWork;
    }

    public Boolean getCanIssue() {
        return canIssue;
    }

    public void setCanIssue(Boolean canIssue) {
        this.canIssue = canIssue;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
