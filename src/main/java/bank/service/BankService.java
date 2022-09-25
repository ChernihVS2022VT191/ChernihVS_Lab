package bank.service;

import bank.entity.Bank;

public interface BankService {
    void addMoney(Bank bank, Double sumMoney);
    Boolean subtractMoney(Bank bank, Double sumMoney);
}