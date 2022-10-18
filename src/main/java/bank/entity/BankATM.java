package bank.entity;

import bank.entity.helpClass.StatusATM;

public class BankATM {
    private Integer id;
    private String name;
    private Bank bank;
    private BankOffice bankOffice;
    private Employee employee;
    private StatusATM status;
    private Boolean workPayMoney;
    private Boolean workDepositMoney;
    private Double money;
    private Double maintenanceCost;

    public BankATM(Integer id, String name, StatusATM status, Boolean workPayMoney, Boolean workDepositMoney,
                   Double maintenanceCost, Bank bank, BankOffice bankOffice, Employee employee) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.workPayMoney = workPayMoney;
        this.workDepositMoney = workDepositMoney;
        this.maintenanceCost = maintenanceCost;
        this.bank = bank;
        this.employee = employee;
        this.money = 0.0;
        this.bankOffice = bankOffice;
    }

    public BankATM() {
        this.id = -1;
        this.name = "";
        this.status = StatusATM.Work;
        this.workPayMoney = Boolean.TRUE;
        this.workDepositMoney = Boolean.TRUE;
        this.maintenanceCost = -1.0;
        this.bank = null;
        this.employee = null;
        this.money = 0.0;
        this.bankOffice = null;
    }

    @Override
    public String toString() {
        String str = "Имя банкомата: " + name + "\nАдрес: " + bankOffice.getAddress() + "\nСтатус: ";
        switch (status) {
            case Work -> str += "работает";
            case NotWork -> str += "Не работает";
            case NoMoney -> str += "Нет денег";
        }
        str += "\nИмя банка: " + bank.getName() + "\nИмя офиса: " + bankOffice.getName() +
                "\nИмя обслуживающего сотрудника: " + employee.getName();
        if (workPayMoney)
            str += "\nРаботает на выдачу денег";
        else
            str += "\nНе работает на выдачу денег";
        if (workDepositMoney)
            str += "\nМожно внести деньги";
        else
            str += "\nНельзя внести деньги";
        str += "\nДенежная сумма: " + money + "\nСтоимость обслуживания: " + maintenanceCost;
        return str;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public StatusATM getStatus() {
        return status;
    }

    public void setStatus(StatusATM statusATM) {
        this.status = statusATM;
    }

    public Boolean getWorkPayMoney() {
        return workPayMoney;
    }

    public void setWorkPayMoney(Boolean workPayMoney) {
        this.workPayMoney = workPayMoney;
    }

    public Boolean getWorkDepositMoney() {
        return workDepositMoney;
    }

    public void setWorkDepositMoney(Boolean workDepositMoney) {
        this.workDepositMoney = workDepositMoney;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Double getMaintenanceCost() {
        return maintenanceCost;
    }

    public void setMaintenanceCost(Double maintenanceCost) {
        this.maintenanceCost = maintenanceCost;
    }
}