package bank.service;

import bank.entity.Bank;
import bank.entity.BankATM;
import bank.entity.BankOffice;
import bank.entity.exceptions.AtmAnotherOfficeException;
import bank.entity.exceptions.EmployeeAnotherOfficeException;
import bank.entity.helpClass.StatusOffice;

public interface BankOfficeService {
    void create(Integer id, String name, Bank bank, String address, StatusOffice status, Double rentCost);
    void update(BankOffice bankOffice);
    void delete();
    BankOffice getBankOffice();

    void addBankATM(AtmService atm) throws AtmAnotherOfficeException;
    Boolean delBankATM(AtmService atm);
    void addEmployee(EmployeeService employee) throws EmployeeAnotherOfficeException;
    Boolean delEmployee(EmployeeService employee);

    void addMoney(Double sumMoney);
    Boolean subtractMoney(Double sumMoney);
    void subtractATM(BankATM bankATM);
    void toMaySetATM();
    void toNotMaySetATM();
    void toMayWithdrawMoney();
    void toNotMayWithdrawMoney();
    void toMayDepositMoney();
    void toNotMayDepositMoney();
    void toMayApplyLoan();
    void toNotMayApplyLoan();
}