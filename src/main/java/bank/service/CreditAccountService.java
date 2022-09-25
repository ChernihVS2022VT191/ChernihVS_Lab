package bank.service;

import bank.entity.CreditAccount;
import bank.entity.Employee;

public interface CreditAccountService {
    Boolean applyLoan(CreditAccount creditAcc, Employee employee);
}
