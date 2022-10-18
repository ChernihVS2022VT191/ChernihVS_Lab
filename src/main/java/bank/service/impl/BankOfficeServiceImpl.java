package bank.service.impl;

import bank.entity.BankATM;
import bank.entity.BankOffice;
import bank.service.BankOfficeService;

public class BankOfficeServiceImpl implements BankOfficeService {
    /*Добавление суммы денег в офис, и затем в банк этого офиса*/
    @Override
    public void addMoney(BankOffice office, Double sumMoney) {
        Double sumBank = office.getBank().getMoney();
        Double sumOffice = office.getMoney();
        office.getBank().setMoney(sumBank + sumMoney);
        office.setMoney(sumOffice + sumMoney);
    }

    /*Вычитание суммы денег из офиса и из банка этого офиса, с проверкой того, достаточно ли денег в офисе,
    чтобы их вычесть. Если не достаточно, то возвращается false, иначе true*/
    @Override
    public Boolean subtractMoney(BankOffice office, Double sumMoney) {
        Double sumBank = office.getBank().getMoney();
        Double sumOffice = office.getMoney();
        if (sumOffice < sumMoney)
            return Boolean.FALSE;
        office.getBank().setMoney(sumBank - sumMoney);
        office.setMoney(sumOffice - sumMoney);
        return Boolean.TRUE;
    }

    /*Добавление нового банкомата в офис, и затем в банк этого офиса, с проверкой того, можно ли добавить
    в этот офис новый банкомат. Если нельзя, то возвращается false, иначе true*/
    @Override
    public Boolean addATM(BankOffice office) {
        if (!office.getMaySetATM())
            return Boolean.FALSE;
        office.setCountATM(office.getCountATM() + 1);
        office.getBank().setCountATM(office.getBank().getCountATM() + 1);
        return Boolean.TRUE;
    }

    /*Вычитание банкомата из офиса, и затем из банка этого офиса*/
    @Override
    public void subtractATM(BankOffice office, BankATM bankATM) {
        office.setCountATM(office.getCountATM() - 1);
        office.getBank().setCountATM(office.getCountATM() - 1);
        bankATM.setBankOffice(new BankOffice());
    }
}