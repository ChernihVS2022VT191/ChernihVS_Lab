package bank.service;

import bank.entity.CreditAccount;
import bank.entity.Employee;
import bank.entity.PaymentAccount;

public interface CreditAccountService {
    Boolean applyLoan(CreditAccount creditAcc, PaymentAccount paymentAccount, Employee employee);
}
