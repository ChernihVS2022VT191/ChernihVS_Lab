package bank.service.impl;

import bank.entity.BankATM;
import bank.entity.helpClass.StatusATM;
import bank.service.AtmService;

import java.util.Objects;

public class AtmServiceImpl implements AtmService {
    /*Если в банкомат в рабочем состоянии, то вносятся деньги  в банкомат, затем в офис этого банкомата, а затем в банк
    этого офиса, затем возвращает true, иначе false*/
    @Override
    public Boolean addMoney(BankATM bankATM, Double sumMoney) {
        if (!Objects.equals(bankATM.getStatus(), StatusATM.Work)) {
            return Boolean.FALSE;
        }
        bankATM.setMoney(bankATM.getMoney() + sumMoney);
        bankATM.getBankOffice().setMoney(bankATM.getBankOffice().getMoney() + sumMoney);
        bankATM.getBank().setMoney( bankATM.getBank().getMoney() + sumMoney);
        return Boolean.TRUE;
    }

    /*Если в банкомат в рабочем состоянии и в нём достаточно денег, то выносятся деньги из банкомат, затем из офиса
    этого банкомата, а затем из банка этого офиса, затем возвращает true, иначе false*/
    @Override
    public Boolean subtractMoney(BankATM bankATM, Double sumMoney) {
        if ((Objects.equals(bankATM.getStatus(), StatusATM.NotWork)) || (Objects.equals(bankATM.getStatus(),
                StatusATM.NoMoney)) || (bankATM.getMoney() < sumMoney))
            return Boolean.FALSE;
        if (Objects.equals(bankATM.getMoney(), sumMoney))
            bankATM.setStatus(StatusATM.NoMoney);
        bankATM.setMoney(bankATM.getMoney() - sumMoney);
        bankATM.getBankOffice().setMoney(bankATM.getBankOffice().getMoney() - sumMoney);
        bankATM.getBank().setMoney( bankATM.getBank().getMoney() - sumMoney);
        return Boolean.TRUE;
    }
}
