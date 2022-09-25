package bank.service.impl;

import bank.entity.BankOffice;
import bank.service.BankOfficeService;

public class BankOfficeServiceImpl implements BankOfficeService {
    /*Добавление суммы денег в офис, и затем в банк этого офиса*/
    @Override
    public void addMoney(BankOffice office, Double sumMoney) {
        office.setMoneyBank(office.getMoneyBank() + sumMoney);
        office.setMoneyOffice(office.getMoneyOffice() + sumMoney);
    }

    /*Вычитание суммы денег из офиса и из банка этого офиса, с проверкой того, достаточно ли денег в офисе,
    чтобы их вычесть. Если не достаточно, то возвращается false, иначе true*/
    @Override
    public Boolean subtractMoney(BankOffice office, Double sumMoney) {
        if (office.getMoneyOffice() < sumMoney)
            return Boolean.FALSE;
        office.setMoneyBank(office.getMoneyBank() - sumMoney);
        office.setMoneyOffice(office.getMoneyOffice() - sumMoney);
        return Boolean.TRUE;
    }

    /*Добавление нового банкомата в офис, и затем в банк этого офиса, с проверкой того, можно ли добавить
    в этот офис новый банкомат. Если нельзя, то возвращается false, иначе true*/
    @Override
    public Boolean addATM(BankOffice office) {
        if (!office.getMaySetATM())
            return Boolean.FALSE;
        office.setCountATMOffice(office.getCountATMOffice() + 1);
        office.setCountATMBank(office.getCountATMBank() + 1);
        return Boolean.TRUE;
    }

    /*Вычитание банкомата из офиса, и затем из банка этого офиса*/
    @Override
    public Boolean subtractATM(BankOffice office) {
        if (!office.getMaySetATM())
            return Boolean.FALSE;
        office.setCountATMOffice(office.getCountATMOffice() - 1);
        office.setCountATMBank(office.getCountATMBank() - 1);
        return Boolean.TRUE;
    }
}