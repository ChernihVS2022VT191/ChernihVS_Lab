package bank.service;

import bank.entity.BankATM;

public interface AtmService {
    Boolean addMoney(BankATM bankATM, Double sumMoney);
    Boolean subtractMoney(BankATM bankATM, Double sumMoney);
}