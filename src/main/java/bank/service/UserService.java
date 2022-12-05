package bank.service;

import bank.entity.*;
import bank.entity.exceptions.*;

import java.time.LocalDate;

public interface UserService {
    void create(Integer id, String name, String surname, LocalDate birthDay, String work);
    void update(User user);
    void delete();
    User getUser();

    void addBank(Bank bank);
    void delBank(Bank bank);
    void addCreditAcc(CreditAccountService creditAcc) throws CreditAccAnotherUserException;
    Boolean delCreditAcc(CreditAccountService creditAcc);
    void addPayAcc(PaymentAccountService payAcc) throws PayAccAnotherUserException;
    Boolean delPayAcc(PaymentAccountService payAcc);

    void changeWork(String newWork, Double newMonthSalary);
    void changeMonthSalary(Double newMonthSalary);

    void applyLoan(BankService bank, BankOffice bankOffice, Employee employee, BankATM bankATM, Double sumCredit,
                   LocalDate startDate, Integer countMonths, PaymentAccountService paymentAccount,
                   CreditAccountService creditAccount) throws CreditException, BadUserRatingException,
                   PayAccAnotherUserException, UserAnotherBankException, CreditAccAnotherUserException;
}
