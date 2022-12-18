package bank.service.impl;

import bank.entity.Bank;
import bank.entity.BankATM;
import bank.entity.BankOffice;
import bank.entity.Employee;
import bank.exceptions.AtmAnotherOfficeException;
import bank.exceptions.EmployeeAnotherOfficeException;
import bank.enums.StatusOffice;
import bank.service.AtmService;
import bank.service.BankOfficeService;
import bank.service.EmployeeService;

import java.util.ArrayList;
import java.util.Objects;

public class BankOfficeServiceImpl implements BankOfficeService {
    private BankOffice bankOffice = null;

    /*Создание экземпляра офиса*/
    @Override
    public void create(Integer id, String name, Bank bank, String address, StatusOffice status, Double rentCost) {
        bank.setCountOffice(bank.getCountOffice() + 1);
        this.bankOffice = new BankOffice(id, name, bank, address, status, rentCost);
    }

    /*Обновление экземпляра офиса*/
    @Override
    public void update(BankOffice bankOffice) {
        this.bankOffice = bankOffice;
    }

    /*Обнуление экземпляра офиса*/
    @Override
    public void delete() {
        this.bankOffice = null;
    }

    /*Возврат экземпляра офиса*/
    @Override
    public BankOffice getBankOffice() {
        return this.bankOffice;
    }

    /*Добавление банкомата в список банкоматов офиса*/
    @Override
    public void addBankATM(AtmService atm) throws AtmAnotherOfficeException {
        if (!Objects.equals(atm.getBankATM().getBankOffice(), this.bankOffice))
            throw new AtmAnotherOfficeException();
        ArrayList<BankATM> bankATMS = this.bankOffice.getBankATMS();
        bankATMS.add(atm.getBankATM());
        this.bankOffice.setBankATMS(bankATMS);
        atm.getBankATM().setBankOffice(this.bankOffice);
    }

    /*Удаление банкомата из списка банкоматов офиса*/
    @Override
    public Boolean delBankATM(AtmService atm) {
        if (!Objects.equals(atm.getBankATM().getBankOffice(), this.bankOffice))
            return false;
        ArrayList<BankATM> bankATMS = this.bankOffice.getBankATMS();
        bankATMS.remove(atm.getBankATM());
        this.bankOffice.setBankATMS(bankATMS);
        atm.getBankATM().setBankOffice(this.bankOffice);
        return true;
    }

    /*Добавление работника в список работников офиса*/
    @Override
    public void addEmployee(EmployeeService employee) throws EmployeeAnotherOfficeException {
        if (!Objects.equals(employee.getEmployee().getBankOffice(), this.bankOffice))
            throw new EmployeeAnotherOfficeException();
        ArrayList<Employee> employees = this.bankOffice.getEmployees();
        employees.add(employee.getEmployee());
        this.bankOffice.setEmployees(employees);
        employee.getEmployee().setBankOffice(this.bankOffice);
    }

    /*Удаление работника из списка работников офиса*/
    @Override
    public Boolean delEmployee(EmployeeService employee) {
        if (!Objects.equals(employee.getEmployee().getBankOffice(), this.bankOffice))
            return false;
        ArrayList<Employee> employees = this.bankOffice.getEmployees();
        employees.remove(employee.getEmployee());
        this.bankOffice.setEmployees(employees);
        employee.getEmployee().setBankOffice(this.bankOffice);
        return true;
    }

    /*Добавление суммы денег в офис, и затем в банк этого офиса*/
    @Override
    public void addMoney(Double sumMoney) {
        Double sumBank = this.bankOffice.getBank().getMoney();
        Double sumOffice = this.bankOffice.getMoney();
        this.bankOffice.getBank().setMoney(sumBank + sumMoney);
        this.bankOffice.setMoney(sumOffice + sumMoney);
    }

    /*Вычитание суммы денег из офиса и из банка этого офиса, с проверкой того, достаточно ли денег в офисе,
    чтобы их вычесть. Если не достаточно, то возвращается false, иначе true*/
    @Override
    public Boolean subtractMoney(Double sumMoney) {
        Double sumBank = this.bankOffice.getBank().getMoney();
        Double sumOffice = this.bankOffice.getMoney();
        if (sumOffice < sumMoney)
            return Boolean.FALSE;
        this.bankOffice.getBank().setMoney(sumBank - sumMoney);
        this.bankOffice.setMoney(sumOffice - sumMoney);
        return Boolean.TRUE;
    }

    /*Вычитание банкомата из офиса, и затем из банка этого офиса*/
    @Override
    public void subtractATM(BankATM bankATM) {
        this.bankOffice.setCountATM(this.bankOffice.getCountATM() - 1);
        this.bankOffice.getBank().setCountATM(this.bankOffice.getCountATM() - 1);
        bankATM.setBankOffice(null);
    }

    /*Разрешить офису добавлять банкоматы*/
    @Override
    public void toMaySetATM() {
        this.bankOffice.setMaySetATM(Boolean.TRUE);
    }

    /*Запретить офису добавлять банкоматы*/
    @Override
    public void toNotMaySetATM() {
        this.bankOffice.setMaySetATM(Boolean.FALSE);
    }

    /*Разрешить офису работать на выдачу денег*/
    @Override
    public void toMayWithdrawMoney() {
        this.bankOffice.setMayWithdrawMoney(Boolean.TRUE);
    }

    /*Запретить офису работать на выдачу денег*/
    @Override
    public void toNotMayWithdrawMoney() {
        this.bankOffice.setMayWithdrawMoney(Boolean.FALSE);
    }

    /*Разрешить офису работать на внос денег*/
    @Override
    public void toMayDepositMoney() {
        this.bankOffice.setMayDepositMoney(Boolean.TRUE);
    }

    /*Запретить офису работать на внос денег*/
    @Override
    public void toNotMayDepositMoney() {
        this.bankOffice.setMayDepositMoney(Boolean.FALSE);
    }


    /*Разрешить офису выдавать кредиты*/
    @Override
    public void toMayApplyLoan() {
        this.bankOffice.setMayApplyLoan(Boolean.TRUE);
    }

    /*Запретить офису выдавать кредиты*/
    @Override
    public void toNotMayApplyLoan() {
        this.bankOffice.setMayApplyLoan(Boolean.FALSE);
    }

}