package bank.service;

import bank.entity.BankATM;
import bank.entity.BankOffice;

public interface BankOfficeService {
    void addMoney(BankOffice office, Double sumMoney);
    Boolean subtractMoney(BankOffice office, Double sumMoney);
    Boolean addATM(BankOffice office);
    void subtractATM(BankOffice office, BankATM bankATM);
}