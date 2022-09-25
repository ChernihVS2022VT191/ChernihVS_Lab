package bank.service.impl;

import bank.entity.Bank;
import bank.service.BankService;

public class BankServiceImpl implements BankService {
    /*Добавление суммы денег в банк, путём взятия суммы из банка, добавления к ней суммы, которую хотим внести
    и внесения в банк новой получившейся суммы*/
    @Override
    public void addMoney(Bank bank, Double sumMoney) {
        Double sum = bank.getMoneyBank();
        bank.setMoneyBank(sum + sumMoney);
    }

    /*Вычитание суммы денег из банка, путём взятия денег из банка, сравнения её с суммой списания, вычитание суммы
    списания из суммы, взятой из банка, и запись в банк новой суммы*/
    @Override
    public Boolean subtractMoney(Bank bank, Double sumMoney) {
        Double sum = bank.getMoneyBank();
        if (sumMoney > sum)
            return Boolean.FALSE;
        bank.setMoneyBank(sum - sumMoney);
        return Boolean.TRUE;
    }
}
