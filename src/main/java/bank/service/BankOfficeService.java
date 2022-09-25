package bank.service;

import bank.entity.BankOffice;

public interface BankOfficeService {
    void addMoney(BankOffice office, Double sumMoney);
    Boolean subtractMoney(BankOffice office, Double sumMoney);
    Boolean addATM(BankOffice office);
    Boolean subtractATM(BankOffice office);
}