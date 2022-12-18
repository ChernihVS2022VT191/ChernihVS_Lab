package bank.service;

import bank.entity.Bank;
import bank.exceptions.AtmAnotherBankException;
import bank.exceptions.EmployeeAnotherBankException;
import bank.exceptions.OfficeAnotherBankException;
import bank.exceptions.UserAnotherBankException;

public interface BankService {
    void create(Integer id, String name);
    void update(Bank bank);
    void delete();
    Bank getBank();

    void addBankOffice(BankOfficeService bankOffice) throws OfficeAnotherBankException;
    Boolean delBankOffice(BankOfficeService bankOffice);
    void addBankATM(AtmService bankATM) throws AtmAnotherBankException;
    Boolean delBankATM(AtmService bankATM);
    void addEmployee(EmployeeService employee) throws EmployeeAnotherBankException;
    Boolean delEmployee(EmployeeService employee);
    void addUser(UserService user) throws UserAnotherBankException;
    Boolean delUser(UserService user);

    void addMoney(Bank bank, Double sumMoney);
    Boolean subtractMoney(Bank bank, Double sumMoney);
}