package bank.service.impl;

import bank.entity.Bank;
import bank.entity.BankATM;
import bank.entity.BankOffice;
import bank.entity.Employee;
import bank.enums.StatusATM;
import bank.service.AtmService;

import java.util.Objects;

public class AtmServiceImpl implements AtmService {
    private BankATM bankATM = null;

    /*Создание экземпляра банкомата*/
    @Override
    public void create(Integer id, String name, StatusATM status, Boolean workPayMoney, Boolean workDepositMoney,
                       Double maintenanceCost, Bank bank, BankOffice bankOffice, Employee employee) {
        bank.setCountATM(bank.getCountATM() + 1);
        bankOffice.setCountATM(bankOffice.getCountATM() + 1);
        this.bankATM = new BankATM(id, name, status, workPayMoney, workDepositMoney, maintenanceCost, bank,
                bankOffice, employee);
    }

    /*Обновление экземпляра банкомата*/
    @Override
    public void update(BankATM bankATM) {
        this.bankATM = bankATM;
    }

    /*Обнуление экземпляра банкомата*/
    @Override
    public void delete() {
        this.bankATM = null;
    }

    /*Возврат экземпляра банкомата*/
    @Override
    public BankATM getBankATM() {
        return this.bankATM;
    }

    /*Если в банкомат в рабочем состоянии, то вносятся деньги  в банкомат, затем в офис этого банкомата, а затем в банк
    этого офиса, затем возвращает true, иначе false*/
    @Override
    public Boolean addMoney(Double sumMoney) {
        if (!Objects.equals(this.bankATM.getStatus(), StatusATM.Work)) {
            return Boolean.FALSE;
        }
        this.bankATM.setMoney(this.bankATM.getMoney() + sumMoney);
        this.bankATM.getBankOffice().setMoney(this.bankATM.getBankOffice().getMoney() + sumMoney);
        this.bankATM.getBank().setMoney(this.bankATM.getBank().getMoney() + sumMoney);
        return Boolean.TRUE;
    }

    /*Если в банкомат в рабочем состоянии и в нём достаточно денег, то выносятся деньги из банкомат, затем из офиса
    этого банкомата, а затем из банка этого офиса, затем возвращает true, иначе false*/
    @Override
    public Boolean subtractMoney(Double sumMoney) {
        if ((Objects.equals(this.bankATM.getStatus(), StatusATM.NotWork)) || (Objects.equals(this.bankATM.getStatus(),
                StatusATM.NoMoney)) || (this.bankATM.getMoney() < sumMoney))
            return Boolean.FALSE;
        if (Objects.equals(this.bankATM.getMoney(), sumMoney))
            this.bankATM.setStatus(StatusATM.NoMoney);
        this.bankATM.setMoney(this.bankATM.getMoney() - sumMoney);
        this.bankATM.getBankOffice().setMoney(this.bankATM.getBankOffice().getMoney() - sumMoney);
        this.bankATM.getBank().setMoney(this.bankATM.getBank().getMoney() - sumMoney);
        return Boolean.TRUE;
    }


    /*Разрешить банкому выдавать деньги*/
    @Override
    public void toWorkIssuanceMoney() {
        this.bankATM.setWorkIssuanceMoney(Boolean.TRUE);
    }

    /*Запретить банкому выдавать деньги*/
    @Override
    public void toDoesNotWorkIssuanceMoney() {
        this.bankATM.setWorkIssuanceMoney(Boolean.TRUE);
    }

    /*Разрешить банкому получать деньги*/
    @Override
    public void toWorkDepositMoney() {
        this.bankATM.setWorkDepositMoney(Boolean.TRUE);
    }

    /*Запретить банкому получать деньги*/
    @Override
    public void toDoesNotWorkDepositMoney() {
        this.bankATM.setWorkDepositMoney(Boolean.TRUE);
    }
}
