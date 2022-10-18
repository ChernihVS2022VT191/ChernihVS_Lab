package bank.service.impl;

import bank.entity.PaymentAccount;
import bank.service.PaymentAccountService;

public class PaymentAccountServiceImpl implements PaymentAccountService {
    /*Добавление суммы денег на платёжный счёт, и затем добавление суммы денег в банк этого платёжного счёта,
    которому принадлежит данный платёжный счёт*/
    @Override
    public void addMoney(PaymentAccount payAcc, Double sumMoney) {
        payAcc.setAmount(payAcc.getAmount() + sumMoney);
        payAcc.getBank().setMoney(payAcc.getBank().getMoney() + sumMoney);
    }

    /*Вычитание суммы денег с платёжного счёта, и, соответственно, вычитание суммы денег из банка этого платёжного
    счёта, с проверкой того, достаточно ли денег на платёжном счету, чтобы их вычесть. Если не достаточно,
    то возвращается false, иначе true*/
    @Override
    public Boolean subtractMoney(PaymentAccount payAcc, Double sumMoney) {
        if (payAcc.getAmount() < sumMoney)
            return Boolean.FALSE;
        payAcc.setAmount(payAcc.getAmount() - sumMoney);
        payAcc.getBank().setMoney(payAcc.getBank().getMoney() - sumMoney);
        return Boolean.TRUE;
    }
}
