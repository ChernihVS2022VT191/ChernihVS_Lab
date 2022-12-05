package bank;

import bank.entity.BankOffice;
import bank.entity.Employee;
import bank.entity.exceptions.*;
import bank.entity.helpClass.StatusATM;
import bank.entity.helpClass.StatusOffice;
import bank.service.BankService;
import bank.service.UserService;
import bank.service.impl.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<BankService> sortBanksByCriteria(ArrayList<BankService> banks, Double loanSum) {
        ArrayList<BankService> banksWithMoney = new ArrayList<>();
        ArrayList<Double> criteria = new ArrayList<>();
        for (BankService bank : banks) {
            if (bank.getBank().getMoney() >= loanSum) {
                banksWithMoney.add(bank);
                criteria.add(bank.getBank().getCountOffice() + bank.getBank().getCountATM() +
                        bank.getBank().getCountEmployees() + (20 - bank.getBank().getInterestRate()));
            }
        }
        for (int i = 0; i < criteria.size(); i++) {
            for (int j = 0; j < criteria.size(); j++) {
                if (criteria.get(j) < criteria.get(i)) {
                    Double crit = criteria.get(i);
                    BankService bank = banksWithMoney.get(i);

                    criteria.set(i, criteria.get(j));
                    banksWithMoney.set(i, banksWithMoney.get(j));
                    criteria.set(j, crit);
                    banksWithMoney.set(j, bank);
                }
            }
        }
        return banksWithMoney;
    }


    public static void main(String[] args) throws EmployeeAnotherBankException, EmployeeAnotherOfficeException,
            AtmAnotherOfficeException, AtmAnotherBankException, OfficeAnotherBankException, PayAccAnotherUserException,
            CreditAccAnotherUserException, UserAnotherBankException, BadUserRatingException, CreditException {
        ArrayList<BankService> banks = new ArrayList<>();
        ArrayList<UserService> users = new ArrayList<>();
        for (int i_1 = 0; i_1 < 5; i_1++) {
            BankServiceImpl bankService = new BankServiceImpl();
            bankService.create(i_1, String.format("Банк_№%d", i_1));
            for (int i_2 = 0; i_2 < 3; i_2++) {
                BankOfficeServiceImpl bankOfficeService = new BankOfficeServiceImpl();
                bankOfficeService.create(i_2 + i_1, String.format("Офис_№%d", i_2), bankService.getBank(),
                        String.format("Адрес%d", i_2), StatusOffice.Work, 15000.0);
                bankOfficeService.addMoney(bankService.getBank().getMoney()/3);
                for (int i_3 = 0; i_3 < 5; i_3++) {
                    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
                    employeeService.create(i_3 + 5 * i_2 + 3 * i_1, String.format("Клим_%d", i_3 + 5 * i_2 + 3 * i_1), "Жуков",
                            LocalDate.of(1977, 3, 27), bankService.getBank(),
                            bankOfficeService.getBankOffice(), String.format("Работа_%d", i_3), 100.0);
                    bankOfficeService.addEmployee(employeeService);
                    bankService.addEmployee(employeeService);
                }
                AtmServiceImpl atmService = new AtmServiceImpl();
                atmService.create(i_2 + i_1, String.format("Банкомат_%d", i_2 + i_1), StatusATM.Work, Boolean.TRUE, Boolean.TRUE,
                        100.0, bankOfficeService.getBankOffice().getBank(),
                        bankOfficeService.getBankOffice(), bankOfficeService.getBankOffice().getEmployees().get(1));
                atmService.addMoney(bankOfficeService.getBankOffice().getMoney());
                bankOfficeService.addBankATM(atmService);
                bankService.addBankATM(atmService);
                bankService.addBankOffice(bankOfficeService);
            }

            UserServiceImpl userService = new UserServiceImpl();
            userService.create(i_1, String.format("Дмитрий_%d", i_1), "Пучков", LocalDate.of(1961,
                    8, 2), String.format("Работа_%d", i_1));
            for (int i_2 = 0; i_2 < 2; i_2++) {
                PaymentAccountServiceImpl paymentAccountService = new PaymentAccountServiceImpl();
                paymentAccountService.create(i_2 + i_1, userService.getUser(), bankService.getBank());

                CreditAccountServiceImpl creditAccountService = new CreditAccountServiceImpl();
                creditAccountService.create(i_2 + i_1, userService.getUser(), bankService.getBank(),
                        bankService.getBank().getEmployees().get(1), paymentAccountService.getPayAcc(),
                        LocalDate.of(2022, 11, 11), 12, 150.0);
                userService.addPayAcc(paymentAccountService);
                userService.addCreditAcc(creditAccountService);
            }
            bankService.addUser(userService);
            banks.add(bankService);
            users.add(userService);
        }

        System.out.println("Клиент");
        UserService workUser = users.get(0);
        System.out.println(workUser.getUser());
        System.out.println("\nПопытка получения нового кредита");
        Scanner input = new Scanner(System.in);
        System.out.println("Введите сумму кредита: ");
        double loanSum = input.nextDouble();
        System.out.println("Введите количество месяцев: ");
        int countMonth = input.nextInt();
        ArrayList<BankService> banksWithMoney = sortBanksByCriteria(banks, loanSum);
        System.out.println("\nПредложенные банки:");
        for (int i = 0; i < banksWithMoney.size(); i++) {
            if (i != 0) {
                System.out.printf("\nБанк №%d%n", i+1);
            }
            else {
                System.out.printf("Банк №%d%n", i+1);
            }
            System.out.println(banksWithMoney.get(i).getBank());
        }
        System.out.println("\nВыберите из предложенных банков: ");
        int bankID = input.nextInt();
        BankService workBank = banksWithMoney.get(bankID - 1);

        System.out.println("\nПредложенные банковские офисы:");
        for (int i = 0; i < workBank.getBank().getOffices().size(); i++) {
            if (i != 0) {
                System.out.printf("\nОфис №%d%n", i+1);
            }
            else {
                System.out.printf("Офис №%d%n", i+1);
            }
            System.out.println(workBank.getBank().getOffices().get(i));
        }
        System.out.println("\nВыберите из предложенных офисов: ");
        int officeID = input.nextInt();
        BankOffice workOffice = workBank.getBank().getOffices().get(officeID - 1);
        System.out.println("\nПредложенные сотрудники:");
        for (int i = 0; i < workOffice.getEmployees().size(); i++) {
            if (i != 0) {
                System.out.printf("\nСотрудник №%d%n", i+1);
            }
            else {
                System.out.printf("Сотрудник №%d%n", i+1);
            }
            System.out.printf("id %d%n", workOffice.getEmployees().get(i).getId());
            System.out.printf("Имя %s", workOffice.getEmployees().get(i).getName());
            if (workOffice.getEmployees().get(i).getCanIssue()) {
                System.out.println("\nМожет выдавать кредиты");
            }
            else {
                System.out.println("\nНе может выдавать кредиты");
            }
        }
        System.out.println("\nВыберите из предложенных сотрудников: ");
        int employeeID = input.nextInt();
        Employee workEmployee = workOffice.getEmployees().get(employeeID);
        //Берём кредит
        PaymentAccountServiceImpl payAcc = new PaymentAccountServiceImpl();
        CreditAccountServiceImpl creditAcc = new CreditAccountServiceImpl();
        workUser.applyLoan(workBank, workOffice, workEmployee, workOffice.getBankATMS().get(0), loanSum,
                LocalDate.of(2022, 11, 11), countMonth, payAcc, creditAcc);
        System.out.println("Кредит успешно оформлен.");
        int size = workUser.getUser().getCreditAccounts().size();
        System.out.println(workUser.getUser().getCreditAccounts().get(size - 1));
    }
}