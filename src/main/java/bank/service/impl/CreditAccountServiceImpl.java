package bank.service.impl;

import bank.entity.CreditAccount;
import bank.entity.Employee;
import bank.entity.PaymentAccount;
import bank.service.CreditAccountService;

import java.util.Objects;

public class CreditAccountServiceImpl implements CreditAccountService {
    /*Одобрение заявки на кредит. В случае одобрения, если выбранный сотрудник совпадает с сотрудником,
    фактически оформляющим кредит, если банк имеет достаточную сумму для выдачи кредита и если выбранный
    сотрудник может оформлять кредиты, то на платёжный счёт пользователя поступает запрошенная сумма, а
    из банка списывается указанная в заявке сумма. В случае оформления возвращается true, иначе false.*/
    @Override
    public Boolean applyLoan(CreditAccount creditAcc, PaymentAccount paymentAccount, Employee employee) {
        if ((creditAcc.getAmount() > creditAcc.getBank().getMoney()) || (!employee.getCanLend())
                || (!Objects.equals(creditAcc.getEmployee(), employee)))
            return Boolean.FALSE;
        creditAcc.getBank().setMoney(creditAcc.getBank().getMoney() - creditAcc.getAmount());
        paymentAccount.setAmount(paymentAccount.getAmount() + creditAcc.getAmount());
        return Boolean.TRUE;
    }
}
