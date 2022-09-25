package bank.service;

import bank.entity.PaymentAccount;

public interface PaymentAccountService {
    void addMoney(PaymentAccount payAcc, Double sumMoney);
    Boolean subtractMoney(PaymentAccount payAcc, Double sumMoney);
}
