package bank.service.impl;

import bank.entity.PaymentAccount;
import bank.service.PaymentAccountService;

public class PaymentAccountServiceImpl implements PaymentAccountService {
    /*Добавление суммы денег на платёжный счёт, и затем добавление суммы денег в банк этого платёжного счёта,
    которому принадлежит данный платёжный счёт*/
    @Override
    public void addMoney(PaymentAccount payAcc, Double sumMoney) {
        payAcc.setAmountPayAcc(payAcc.getAmountPayAcc() + sumMoney);
        payAcc.setMoneyBank(payAcc.getMoneyBank() + sumMoney);
    }

    /*Вычитание суммы денег с платёжного счёта, и, соответственно, вычитание суммы денег из банка этого платёжного
    счёта, с проверкой того, достаточно ли денег на платёжном счету, чтобы их вычесть. Если не достаточно,
    то возвращается false, иначе true*/
    @Override
    public Boolean subtractMoney(PaymentAccount payAcc, Double sumMoney) {
        if (payAcc.getAmountPayAcc() < sumMoney)
            return Boolean.FALSE;
        payAcc.setAmountPayAcc(payAcc.getAmountPayAcc() - sumMoney);
        payAcc.setMoneyBank(payAcc.getMoneyBank() - sumMoney);
        return Boolean.TRUE;
    }
}
