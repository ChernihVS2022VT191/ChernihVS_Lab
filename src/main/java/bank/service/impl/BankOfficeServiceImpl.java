package bank.service.impl;

import bank.entity.Bank;
import bank.entity.BankATM;
import bank.entity.BankOffice;
import bank.entity.helpClass.StatusOffice;
import bank.service.BankOfficeService;

public class BankOfficeServiceImpl implements BankOfficeService {
    private BankOffice bankOffice = null;

    /*Создание экземпляра офиса*/
    @Override
    public void create(Integer id, String name, Bank bank, String address, StatusOffice status, Double rentCost) {
        bank.setCountOffice(bank.getCountOffice() + 1);
        this.bankOffice = new BankOffice(id, name, bank, address, status, rentCost);
    }

    /*Обновление экземпляра офиса*/
    @Override
    public void update(BankOffice bankOffice) {
        this.bankOffice = bankOffice;
    }

    /*Обнуление экземпляра офиса*/
    @Override
    public void delete() {
        this.bankOffice = null;
    }

    /*Возврат экземпляра офиса*/
    @Override
    public BankOffice getBankOffice() {
        return this.bankOffice;
    }

    /*Добавление суммы денег в офис, и затем в банк этого офиса*/
    @Override
    public void addMoney(Double sumMoney) {
        Double sumBank = this.bankOffice.getBank().getMoney();
        Double sumOffice = this.bankOffice.getMoney();
        this.bankOffice.getBank().setMoney(sumBank + sumMoney);
        this.bankOffice.setMoney(sumOffice + sumMoney);
    }

    /*Вычитание суммы денег из офиса и из банка этого офиса, с проверкой того, достаточно ли денег в офисе,
    чтобы их вычесть. Если не достаточно, то возвращается false, иначе true*/
    @Override
    public Boolean subtractMoney(Double sumMoney) {
        Double sumBank = this.bankOffice.getBank().getMoney();
        Double sumOffice = this.bankOffice.getMoney();
        if (sumOffice < sumMoney)
            return Boolean.FALSE;
        this.bankOffice.getBank().setMoney(sumBank - sumMoney);
        this.bankOffice.setMoney(sumOffice - sumMoney);
        return Boolean.TRUE;
    }

    /*Добавление нового банкомата в офис, и затем в банк этого офиса, с проверкой того, можно ли добавить
    в этот офис новый банкомат. Если нельзя, то возвращается false, иначе true*/
    @Override
    public Boolean addATM() {
        if (!this.bankOffice.getMaySetATM())
            return Boolean.FALSE;
        this.bankOffice.setCountATM(this.bankOffice.getCountATM() + 1);
        this.bankOffice.getBank().setCountATM(this.bankOffice.getBank().getCountATM() + 1);
        return Boolean.TRUE;
    }

    /*Вычитание банкомата из офиса, и затем из банка этого офиса*/
    @Override
    public void subtractATM(BankATM bankATM) {
        this.bankOffice.setCountATM(this.bankOffice.getCountATM() - 1);
        this.bankOffice.getBank().setCountATM(this.bankOffice.getCountATM() - 1);
        bankATM.setBankOffice(null);
    }

    /*Разрешить офису добавлять банкоматы*/
    @Override
    public void toMaySetATM() {
        this.bankOffice.setMaySetATM(Boolean.TRUE);
    }

    /*Запретить офису добавлять банкоматы*/
    @Override
    public void toNotMaySetATM() {
        this.bankOffice.setMaySetATM(Boolean.FALSE);
    }

    /*Разрешить офису работать на выдачу денег*/
    @Override
    public void toMayWithdrawMoney() {
        this.bankOffice.setMayWithdrawMoney(Boolean.TRUE);
    }

    /*Запретить офису работать на выдачу денег*/
    @Override
    public void toNotMayWithdrawMoney() {
        this.bankOffice.setMayWithdrawMoney(Boolean.FALSE);
    }

    /*Разрешить офису работать на внос денег*/
    @Override
    public void toMayDepositMoney() {
        this.bankOffice.setMayDepositMoney(Boolean.TRUE);
    }

    /*Запретить офису работать на внос денег*/
    @Override
    public void toNotMayDepositMoney() {
        this.bankOffice.setMayDepositMoney(Boolean.FALSE);
    }


    /*Разрешить офису выдавать кредиты*/
    @Override
    public void toMayApplyLoan() {
        this.bankOffice.setMayApplyLoan(Boolean.TRUE);
    }

    /*Запретить офису выдавать кредиты*/
    @Override
    public void toNotMayApplyLoan() {
        this.bankOffice.setMayApplyLoan(Boolean.FALSE);
    }

}